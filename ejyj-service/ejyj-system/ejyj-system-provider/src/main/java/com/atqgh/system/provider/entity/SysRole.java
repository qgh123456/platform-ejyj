package com.atqgh.system.provider.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 角色信息表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@Data
@TableName("sys_role")
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID.
     */
    @TableId
    private Long id;

    /**
     * 角色编码.
     */
    private String code;

    /**
     * 角色名称.
     */
    private String roleName;

    /**
     * 角色权限字符串.
     */
    private String roleKey;

    /**
     * 显示顺序.
     */
    private Integer roleSort;

    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）.
     */
    private String dataScope;

    /**
     * 菜单树选择项是否关联显示.
     */
    private Integer menuCheckStrictly;

    /**
     * 部门树选择项是否关联显示.
     */
    private Integer deptCheckStrictly;

    /**
     * 角色状态（0正常 1停用）.
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）.
     */
    private String delFlag;

    /**
     * 创建者.
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间.
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新者.
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 更新时间.
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 备注.
     */
    private String remark;

}
