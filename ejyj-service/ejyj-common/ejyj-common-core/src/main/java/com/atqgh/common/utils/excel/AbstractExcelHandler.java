package com.atqgh.common.utils.excel;//package com.atqgh.common.utils.excel;
//
//import java.beans.PropertyDescriptor;
//import java.io.BufferedInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.net.URLEncoder;
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import javax.servlet.http.HttpServletResponse;
//import org.apache.commons.lang3.ObjectUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.BeanUtils;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.lang.NonNull;
//import org.springframework.util.Assert;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
///**
// * 用于excel的导入导出.
// *
// * @author Mubai
// * @date 2022/7/27 10:39 上午
// **/
//public abstract class AbstractExcelHandler {
//
//    protected abstract ResourceLoader getResourceLoader();
//
//    /**
//     * 导出模版.
//     * @param response response
//     * @param excelBase excel的实体对象
//     */
//    public void exportTemplate(HttpServletResponse response, ExcelBase excelBase) {
//
//        String fileName = excelBase.getExcelFileName();
//        Assert.notNull(fileName, "导出excel文件名称");
//        byte[] buff = new byte[1024];
//        BufferedInputStream bis = null;
//        OutputStream os;
//        try {
//            response.setContentType("application/ms-excel;charset=UTF-8");
//            response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(
//                    URLEncoder.encode(fileName + ".xlsx", "UTF-8"))));
//            os = response.getOutputStream();
//
//            Assert.notNull(getResourceLoader(), "资源加载类不能为空");
//            // 获取excel注解
//            String location = excelBase.getExcelLocation();
//            Assert.notNull(location, "模版所在位置不能为空");
//            bis = new BufferedInputStream(getResourceLoader().getResource(location).getInputStream());
//            int i = bis.read(buff);
//            while (i != -1) {
//                os.write(buff, 0, buff.length);
//                os.flush();
//                i = bis.read(buff);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            if (bis != null) {
//                try {
//                    bis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    /**
//     * 导入excel.
//     * @param request request请求
//     * @param excelBase excel的实体类
//     * @return 结果
//     * @throws IOException 异常
//     */
//    public Object importExcel(MultipartHttpServletRequest request, ExcelBase excelBase) throws IOException {
//
//        Map<String, MultipartFile> fileMap = request.getFileMap();
//        if (fileMap.size() == 1) {
//            for (String key : fileMap.keySet()) {
//                MultipartFile multipartFile = fileMap.get(key);
//                if (!multipartFile.isEmpty()) {
//                    String name = multipartFile.getOriginalFilename();
//                    // 通过excel的名称创建一个excel对象
//                    List<List<SheetBase>> list = this.readData(readExcel(multipartFile.getInputStream(), name), excelBase);
//                    if (ObjectUtils.isNotEmpty(list)) {
//                        // 校验数据
//                        Object msg = this.checkData(list);
//                        if (ObjectUtils.isNotEmpty(msg)) {
//                            return msg;
//                        }
//                        // 更新数据
//                        this.addOrUptData(list);
//                    }
//                }
//            }
//        } else {
//            throw new RuntimeException("请导入有数据的excel");
//        }
//        return null;
//    }
//
//    /**
//     * 这个地方是默认的新增或这修改, 实现逻辑： 若唯一.
//     * @param list 数据
//     */
//    protected void addOrUptData(@NonNull List<List<SheetBase>> list) {
//    }
//
//    /**
//     * 校验数据.
//     * @param list 集合
//     * @return 判断
//     */
//    protected Object checkData(@NonNull List<List<SheetBase>> list) {
//        return null;
//    }
//
//    private List<List<SheetBase>> readData(@NonNull Workbook workbook, @NonNull ExcelBase excelBase) {
//
//        int numberOfSheets = workbook.getNumberOfSheets();
//        final List<List<SheetBase>> sheetList = new ArrayList<>();
//        if (numberOfSheets == excelBase.getSheetBases().size()) {
//            // 遍历每个sheet，获取对应的excel数据
//            for (int index = 0; index < excelBase.getSheetBases().size(); index++) {
//                final List<SheetBase> rowList = new ArrayList<>();
//                sheetList.add(rowList);
//                org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(index);
//                SheetBase sheetBase = excelBase.getSheetBases().get(index);
//                Sheet sheetAnno = getSheetAnno(sheetBase.getClass());
//                for (int sheetIndex = sheetAnno.rowStartIndex(); sheetIndex < sheet.getPhysicalNumberOfRows(); sheetIndex++) {
//                    Row row = sheet.getRow(sheetIndex);
//                    boolean flag = isPass(row, sheetAnno.columnLength());
//                    if (flag) {
//                        continue;
//                    }
//                    // 读取当前行的excel数据
//                    SheetBase addVo = this.readRowData(row, sheetAnno.columnLength(), sheetBase.getClass());
//                    rowList.add(addVo);
//                }
//            }
//        } else {
//            throw new RuntimeException("导入的excel不正确");
//        }
//        return sheetList;
//    }
//
//    /**
//     * 读取excel中每一行的数据.
//     * @param row 行
//     * @param columnLength 列长度
//     * @param clazz sheet实体类
//     * @return 结果
//     */
//    private SheetBase readRowData(@NonNull Row row, @NonNull int columnLength, @NonNull Class<? extends SheetBase> clazz) {
//
//        Field[] fields = clazz.getDeclaredFields();
//        SheetBase sheetBase = BeanUtils.instantiateClass(clazz);
//        if (fields.length <= columnLength) {
//            for (int i = 0; i < fields.length; i++) {
//
//                PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(clazz, fields[i].getName());
//                assert propertyDescriptor != null;
//                Method writeMethod = propertyDescriptor.getWriteMethod();
//                int columnIndex = this.getColumnIndex(fields[i], i);
//                Object value = this.getColumnValue(getCellToString(row.getCell(columnIndex)), writeMethod.getParameterTypes());
//                writeMethod.setAccessible(true);
//                try {
//                    writeMethod.invoke(sheetBase, value);
//                } catch (IllegalAccessException | InvocationTargetException e) {
//                    throw new RuntimeException(e.getMessage());
//                }
//            }
//        }
//        return sheetBase;
//    }
//
//    protected Object getColumnValue(@NonNull String columnValue, @NonNull Class<?>[] parameterTypes) {
//
//        if (parameterTypes.length != 1) {
//            throw new RuntimeException("设置默认值出错");
//        }
//        Class<?> parameterType = parameterTypes[0];
//        if (parameterType.equals(Integer.class)) {
//            return Integer.valueOf(columnValue);
//        } else if (parameterType.equals(Long.class)) {
//            return Long.valueOf(columnValue);
//        } else {
//            return columnValue;
//        }
//    }
//
//    /**
//     * 获取读取的列索引，默认为字段在类里的排序，若定义了顺序，则以定义的顺序为主.
//     * @param field 字段名
//     * @param i 字段默认顺序
//     * @return 列索引
//     */
//    private int getColumnIndex(@NonNull Field field, @NonNull int i) {
//
//        int index = i;
//        FieldIndex fieldIndex = field.getAnnotation(FieldIndex.class);
//        if (ObjectUtils.isNotEmpty(fieldIndex)) {
//            index = fieldIndex.index();
//        }
//        return index;
//    }
//
//    /**
//     * 获取ExcelColumnIndex的注解.
//     * @param sheetClazz excel的实体类
//     * @return excel注解
//     */
//    protected Sheet getSheetAnno(@NonNull Class<? extends SheetBase> sheetClazz) {
//
//        Sheet sheet = sheetClazz.getAnnotation(Sheet.class);
//        if (ObjectUtils.isEmpty(sheet)) {
//            throw new RuntimeException("excel的实体类不能缺少@Sheet注解");
//        }
//        return sheet;
//    }
//
//    /**
//     * 读取excel.
//     *
//     * @param inputStream 输入流
//     * @param fileName    文件名称
//     * @return workbook
//     * @throws IOException IOException
//     */
//    public Workbook readExcel(InputStream inputStream, String fileName) throws IOException {
//        return getWorkbosuccess(inputStream, fileName);
//    }
//
//    /**
//     * 获取 workbook.
//     *
//     * @param inputStream 输入流
//     * @param fileName    文件名称
//     * @return workbook
//     * @throws IOException IOException
//     */
//    public Workbook getWorkbosuccess(InputStream inputStream, String fileName) throws IOException {
//        Workbook workbook = null;
//        String xls = "xls";
//        String xlsx = "xlsx";
//        if (fileName.endsWith(xls)) {
//            workbook = new HSSFWorkbosuccess(inputStream);
//        } else if (fileName.endsWith(xlsx)) {
//            workbook = new XSSFWorkbosuccess(inputStream);
//        }
//        return workbook;
//    }
//
//    /**
//     * 获取单元表中的数据.
//     *
//     * @param cell cell
//     * @return 数据
//     */
//    public static String getCellToString(Cell cell) {
//
//        String result = "";
//        if (ObjectUtils.isEmpty(cell)) {
//            return result;
//        }
//        CellType cellType = cell.getCellType();
//        if (cellType.equals(CellType.STRING)) {
//            result = cell.getStringCellValue();
//        } else if (cellType.equals(CellType.NUMERIC)) {
//            result = new DecimalFormat("0").format(cell.getNumericCellValue());
//        }
//        return result;
//    }
//
//    /**
//     * 判断指定的列是否需要过滤掉.
//     *
//     * @param row 行
//     * @param columnLength 列的总长度
//     * @return 若需要则返回true，否则返回false
//     */
//    public static boolean isPass(Row row, int columnLength) {
//
//        if (ObjectUtils.isEmpty(row)) {
//            return true;
//        }
//        //去掉为null的cell
//        for (int z = 0; z < columnLength; z++) {
//            nullToEmpty(row, z);
//            //不处理空的行
//            if (StringUtils.isNotBlank(nullToString(getCellToString(row.getCell(z))))) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    /**
//     * excel cell去空处理.
//     *
//     * @param obj      参数对象
//     * @param position 位置
//     * @return cell
//     */
//    public static Cell nullToEmpty(Row obj, Integer position) {
//
//        if (null == obj.getCell(position)) {
//            obj.createCell(position);
//        }
//        return obj.getCell(position);
//    }
//
//    /**
//     * 去空格.
//     *
//     * @param obj 参数对象
//     * @return 无空格字符串
//     */
//    public static String nullToString(Object obj) {
//        if (null == obj) {
//            return null;
//        } else {
//            return obj.toString().replaceAll(" ", "");
//        }
//    }
//
//}
