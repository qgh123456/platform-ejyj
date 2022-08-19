package com.atqgh.system.provider.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户信息表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@ApiModel
@Data
public class SysUserPageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID.
     */
    @ApiModelProperty("用户ID")
    private Long id;

    /**
     * 用户编码.
     */
    @ApiModelProperty("用户编码")
    private String code;

    /**
     * 部门编码.
     */
    @ApiModelProperty("部门编码")
    private String deptCode;

    /**
     * 用户账号.
     */
    @ApiModelProperty("用户账号")
    private String userName;

    /**
     * 用户昵称.
     */
    @ApiModelProperty("用户昵称")
    private String nickName;

    /**
     * 用户类型（00系统用户）.
     */
    @ApiModelProperty("用户类型（00系统用户）")
    private String userType;

    /**
     * 用户邮箱.
     */
    @ApiModelProperty("用户邮箱")
    private String email;

    /**
     * 手机号码.
     */
    @ApiModelProperty("手机号码")
    private String phonenumber;

    /**
     * 用户性别（0男 1女 2未知）.
     */
    @ApiModelProperty("用户性别（0男 1女 2未知）")
    private String sex;

    /**
     * 头像地址.
     */
    @ApiModelProperty("头像地址")
    private String avatar;

    /**
     * 密码.
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 帐号状态（0正常 1停用）.
     */
    @ApiModelProperty("帐号状态（0正常 1停用）")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）.
     */
    @ApiModelProperty("删除标志（0代表存在 2代表删除）")
    private String delFlag;

    /**
     * 最后登录IP.
     */
    @ApiModelProperty("最后登录IP")
    private String loginIp;

    /**
     * 最后登录时间.
     */
    @ApiModelProperty("最后登录时间")
    private Date loginDate;

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
