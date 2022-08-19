package com.atqgh.system.provider.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户和角色关联表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@ApiModel
@Data
public class SysUserRolePageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID.
     */
    @ApiModelProperty("用户ID")
    private String userCode;

    /**
     * 角色ID.
     */
    @ApiModelProperty("角色ID")
    private String roleCode;

}
