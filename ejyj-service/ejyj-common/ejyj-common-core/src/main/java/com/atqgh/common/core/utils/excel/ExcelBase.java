package com.atqgh.common.core.utils.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * 导入导出的实体基础类.
 * @author Mubai
 * @date 2022/7/27 11:18 上午
 **/
public abstract class ExcelBase {

    private final List<SheetBase> sheetBases = new ArrayList<>();

    /**
     * 获取excel模版存放的路径.
     * @return 路径
     */
    protected abstract String getExcelLocation();

    /**
     * 导出的文件名称.
     * @return 文件名称
     */
    protected abstract String getExcelFileName();

    /**
     * 获取sheets.
     * @return sheet
     */
    public List<SheetBase> getSheetBases() {
        return this.sheetBases;
    }

    /**
     * 构建ExcelBase对象.
     * @param sheetBase sheet
     * @return ExcelBase对象
     */
    public ExcelBase buildExcelBase(SheetBase sheetBase) {

        sheetBases.add(sheetBase);
        return this;
    }

}
