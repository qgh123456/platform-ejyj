package com.atqgh.common.core.utils.excel;

import java.io.Serializable;
import lombok.Data;

/**
 * 实体.
 * @author Mubai
 * @date 2022/7/29 3:34 下午
 **/
@Data
public class EntityOne implements Serializable {

    @ExcelId
    private String name;

    private String remark;
}
