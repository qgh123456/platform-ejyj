package com.atqgh.common.core.utils.excel;//package com.atqgh.common.utils.excel;
//
//import javax.annotation.Resource;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.stereotype.Component;
//
///**
// * mo.
// * @author Mubai
// * @date 2022/7/28 5:34 下午
// **/
//@Component
//public class DefaultExcelUtil extends AbstractExcelHandler {
//
//    @Resource
//    private ResourceLoader resourceLoader;
//
//    @Override
//    protected ResourceLoader getResourceLoader() {
//        return resourceLoader;
//    }
//
////    @Override
////    protected void addOrUptData(@NonNull List<List<SheetBase>> list) {
////
////        Class entityClazz = null;
////        String excelidName = null;
////        Object mapper = null;
////        for (int i = 0; i < list.size(); i++) {
////            SheetBase sheetBase = list.get(i).get(0);
////            if (ObjectUtils.isNotEmpty(sheetBase)) {
////                entityClazz = getClass(sheetBase);
////                excelidName = this.getExcelIdName(entityClazz);
////                mapper = getMapper(sheetBase);
////            }
////            List dataList = PropertiesCopyUtils.entityToDto(list.get(i), entityClazz);
////            // 更新或修改数据
////            doAddOrUptData(dataList, excelidName, mapper);
////        }
////    }
////
////    private String getExcelIdName(@NonNull Class entityClazz) {
////
////        Field[] declaredFields = entityClazz.getDeclaredFields();
////        for (int i = 0; i < declaredFields.length; i++) {
////            ExcelId annotation = declaredFields[i].getAnnotation(ExcelId.class);
////            if (ObjectUtils.isNotEmpty(annotation)) {
////                return declaredFields[i].getName();
////            }
////        }
////        return null;
////    }
////
////    private void doAddOrUptData(List dataList, @NonNull String excelidName, @NonNull Object mapper) {
////
////        if (ObjectUtils.isNotEmpty(dataList)) {
////            List<Object> ids = new ArrayList<>();
////            dataList.forEach(item -> {
////                try {
////                    Method readMethod = Objects.requireNonNull(BeanUtils.getPropertyDescriptor(item.getClass(), excelidName)).getReadMethod();
////                    Object id = readMethod.invoke(item);
////                    ids.add(id);
////                } catch (IllegalAccessException | InvocationTargetException e) {
////                    throw new RuntimeException(e);
////                }
////            });
////        }
////    }
////
////    private Class getClass(SheetBase sheetBase) {
////
////        Sheet sheetAnno = getSheetAnno(sheetBase.getClass());
////        String entityName = sheetAnno.entityName();
////        if (ObjectUtils.isEmpty(entityName)) {
////            throw new RuntimeException("获取目标类失败!");
////        }
////        try {
////            Class<?> aClass = Class.forName(entityName);
////            return aClass;
////        } catch (ClassNotFoundException e) {
////            throw new RuntimeException(e.getCause());
////        }
////    }
////
////    private Object getMapper(SheetBase sheetBase) {
////
////        Sheet sheetAnno = getSheetAnno(sheetBase.getClass());
////        String mapperName = sheetAnno.mapperName();
////        return SpringUtils.getBean(mapperName);
////    }
//
//}
