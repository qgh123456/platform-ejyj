package com.atqgh.system.provider.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 字典类型表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@ApiModel
@Data
public class SysDictTypeAddVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("字典名称")
    private String dictName;

    @ApiModelProperty("字典类型")
    private String dictType;

    @ApiModelProperty("状态（0正常 1停用）")
    private String status;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("备注")
    private String remark;

}
