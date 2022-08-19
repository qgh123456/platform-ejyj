package com.atqgh.system.provider.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色信息表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@ApiModel
@Data
public class SysRolePageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID.
     */
    @ApiModelProperty("角色ID")
    private Long id;

    /**
     * 角色编码.
     */
    @ApiModelProperty("角色编码")
    private String code;

    /**
     * 角色名称.
     */
    @ApiModelProperty("角色名称")
    private String roleName;

    /**
     * 角色权限字符串.
     */
    @ApiModelProperty("角色权限字符串")
    private String roleKey;

    /**
     * 显示顺序.
     */
    @ApiModelProperty("显示顺序")
    private Integer roleSort;

    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）.
     */
    @ApiModelProperty("数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）")
    private String dataScope;

    /**
     * 菜单树选择项是否关联显示.
     */
    @ApiModelProperty("菜单树选择项是否关联显示")
    private Integer menuCheckStrictly;

    /**
     * 部门树选择项是否关联显示.
     */
    @ApiModelProperty("部门树选择项是否关联显示")
    private Integer deptCheckStrictly;

    /**
     * 角色状态（0正常 1停用）.
     */
    @ApiModelProperty("角色状态（0正常 1停用）")
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

    /**
     * 备注.
     */
    @ApiModelProperty("备注")
    private String remark;

}
