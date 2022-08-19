package com.atqgh.system.provider.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 角色和菜单关联表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@ApiModel
@Data
public class SysRoleMenuPageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID.
     */
    @ApiModelProperty("角色ID")
    private String roleCode;

    /**
     * 菜单ID.
     */
    @ApiModelProperty("菜单ID")
    private String menuCode;

}
