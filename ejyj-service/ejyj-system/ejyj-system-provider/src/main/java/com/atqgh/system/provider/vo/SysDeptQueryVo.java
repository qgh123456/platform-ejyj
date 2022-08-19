package com.atqgh.system.provider.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 部门表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@ApiModel
@Data
public class SysDeptQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id.
     */
    @ApiModelProperty("部门id")
    private Long id;

    /**
     * 部门编码.
     */
    @ApiModelProperty("部门编码")
    private String code;

    /**
     * 父部门编码.
     */
    @ApiModelProperty("父部门编码")
    private String pcode;

    /**
     * 祖级列表.
     */
    @ApiModelProperty("祖级列表")
    private String ancestors;

    /**
     * 部门名称.
     */
    @ApiModelProperty("部门名称")
    private String deptName;

    /**
     * 显示顺序.
     */
    @ApiModelProperty("显示顺序")
    private Integer orderNum;

    /**
     * 负责人.
     */
    @ApiModelProperty("负责人")
    private String leader;

    /**
     * 联系电话.
     */
    @ApiModelProperty("联系电话")
    private String phone;

    /**
     * 邮箱.
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 部门状态（0正常 1停用）.
     */
    @ApiModelProperty("部门状态（0正常 1停用）")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）.
     */
    @ApiModelProperty("删除标志（0代表存在 2代表删除）")
    private String delFlag;

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

}
