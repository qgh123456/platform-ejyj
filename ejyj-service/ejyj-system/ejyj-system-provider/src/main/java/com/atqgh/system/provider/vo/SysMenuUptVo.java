package com.atqgh.system.provider.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * 菜单权限表.
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@ApiModel
@Data
public class SysMenuUptVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("菜单ID")
    @NotNull
    private Long id;

    @ApiModelProperty("编码")
    @NotNull
    private String code;

    @ApiModelProperty("菜单名称")
    @NotNull
    private String menuName;

    @ApiModelProperty("父编码")
    private String pcode;

    @ApiModelProperty("显示顺序")
    private Integer orderNum;

    @ApiModelProperty("路由地址")
    private String path;

    @ApiModelProperty("组件路径")
    private String component;

    @ApiModelProperty("路由参数")
    private String query;

    @ApiModelProperty("是否为外链（0是 1否）")
    private Integer isFrame;

    @ApiModelProperty("是否缓存（0缓存 1不缓存）")
    private Integer isCache;

    @ApiModelProperty("菜单类型（M目录 C菜单 F按钮）")
    private String menuType;

    @ApiModelProperty("菜单状态（0显示 1隐藏）")
    private String visible;

    @ApiModelProperty("菜单状态（0正常 1停用）")
    private String status;

    @ApiModelProperty("权限标识")
    private String perms;

    @ApiModelProperty("菜单图标")
    private String icon;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("备注")
    private String remark;

}
