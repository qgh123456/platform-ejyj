package com.atqgh.system.provider.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * 岗位信息表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@ApiModel
@Data
public class SysPostAddVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("岗位编码")
    @NotNull
    private String code;

    @ApiModelProperty("岗位名称")
    @NotNull
    private String postName;

    @ApiModelProperty("显示顺序")
    @NotNull
    private Integer postSort;

    @ApiModelProperty("状态（0正常 1停用）")
    @NotNull
    private String status;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("备注")
    private String remark;

}
