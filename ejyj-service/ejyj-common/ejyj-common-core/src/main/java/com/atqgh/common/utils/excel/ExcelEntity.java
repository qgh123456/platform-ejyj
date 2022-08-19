package com.atqgh.common.utils.excel;

/**
 * excel的实体.
 * @author Mubai
 * @date 2022/7/27 9:23 下午
 **/
public class ExcelEntity extends ExcelBase {

    @Override
    protected String getExcelLocation() {
        return "classpath:template/measure.xlsx";
    }

    @Override
    protected String getExcelFileName() {
        return "测试";
    }

}
