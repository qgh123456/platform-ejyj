package com.atqgh.system.provider.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * 角色信息表.
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@ApiModel
@Data
public class SysRoleUptVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色ID")
    @NotNull
    private Long id;

    @ApiModelProperty("角色编码")
    @NotNull
    private String code;

    @ApiModelProperty("角色名称")
    @NotNull
    private String roleName;

    @ApiModelProperty("角色权限字符串")
    @NotNull
    private String roleKey;

    @ApiModelProperty("显示顺序")
    @NotNull
    private Integer roleSort;

    @ApiModelProperty("数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）")
    private String dataScope;

    @ApiModelProperty("菜单树选择项是否关联显示")
    private Integer menuCheckStrictly;

    @ApiModelProperty("部门树选择项是否关联显示")
    private Integer deptCheckStrictly;

    @ApiModelProperty("角色状态（0正常 1停用）")
    @NotNull
    private String status;

    @ApiModelProperty("删除标志（0代表存在 2代表删除）")
    private String delFlag;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("备注")
    private String remark;

}
