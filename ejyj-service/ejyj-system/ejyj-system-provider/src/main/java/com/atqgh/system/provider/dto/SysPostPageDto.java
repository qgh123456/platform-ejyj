package com.atqgh.system.provider.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 岗位信息表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@ApiModel
@Data
public class SysPostPageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 岗位ID.
     */
    @ApiModelProperty("岗位ID")
    private Long id;

    /**
     * 岗位编码.
     */
    @ApiModelProperty("岗位编码")
    private String code;

    /**
     * 岗位名称.
     */
    @ApiModelProperty("岗位名称")
    private String postName;

    /**
     * 显示顺序.
     */
    @ApiModelProperty("显示顺序")
    private Integer postSort;

    /**
     * 状态（0正常 1停用）.
     */
    @ApiModelProperty("状态（0正常 1停用）")
    private String status;

    /**
     * 创建者.
     */
    @ApiModelProperty("创建者")
    private String createBy;

    /**
     * 创建时间.
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新者.
     */
    @ApiModelProperty("更新者")
    private String updateBy;

    /**
     * 更新时间.
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 备注.
     */
    @ApiModelProperty("备注")
    private String remark;

}
