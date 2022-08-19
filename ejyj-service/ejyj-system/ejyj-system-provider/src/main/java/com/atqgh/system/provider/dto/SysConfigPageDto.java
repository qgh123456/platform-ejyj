package com.atqgh.system.provider.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 参数配置表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@ApiModel
@Data
public class SysConfigPageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 参数主键.
     */
    @ApiModelProperty("参数主键")
    private Integer id;

    /**
     * 参数名称.
     */
    @ApiModelProperty("参数名称")
    private String configName;

    /**
     * 参数键名.
     */
    @ApiModelProperty("参数键名")
    private String configKey;

    /**
     * 参数键值.
     */
    @ApiModelProperty("参数键值")
    private String configValue;

    /**
     * 系统内置（Y是 N否）.
     */
    @ApiModelProperty("系统内置（Y是 N否）")
    private String configType;

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
