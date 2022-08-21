package com.atqgh.common.core.utils.excel;

import lombok.Data;

/**
 * 测试excel.
 * @author Mubai
 * @date 2022/7/27 3:50 下午
 **/
@Sheet(columnLength = 2, rowStartIndex = 1)
@Data
public class OneOfSheetsExcel extends SheetBase {

    @FieldIndex(index = 0)
    private String name;

    @FieldIndex(index = 1)
    private String remark;

}
