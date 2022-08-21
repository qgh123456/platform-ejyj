package com.atqgh.common.core.utils;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 树基本类.
 *
 * @author qiguohui
 * @since 2021-07-05 08:36
 */
@Data
public class BaseTree implements Serializable {

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("编号")
    private String code;

    @ApiModelProperty("父编码")
    private String pcode;

    @ApiModelProperty("孩子节点")
    private List<BaseTree> children;
}
