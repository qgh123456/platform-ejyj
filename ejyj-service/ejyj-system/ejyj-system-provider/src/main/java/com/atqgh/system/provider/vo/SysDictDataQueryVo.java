package com.atqgh.system.provider.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 字典数据表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@ApiModel
@Data
public class SysDictDataQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 字典编码.
     */
    @ApiModelProperty("字典编码")
    private Long id;

    /**
     * 字典排序.
     */
    @ApiModelProperty("字典排序")
    private Integer dictSort;

    /**
     * 字典标签.
     */
    @ApiModelProperty("字典标签")
    private String dictLabel;

    /**
     * 字典键值.
     */
    @ApiModelProperty("字典键值")
    private String dictValue;

    /**
     * 字典类型.
     */
    @ApiModelProperty("字典类型")
    private String dictType;

    /**
     * 样式属性（其他样式扩展）.
     */
    @ApiModelProperty("样式属性（其他样式扩展）")
    private String cssClass;

    /**
     * 表格回显样式.
     */
    @ApiModelProperty("表格回显样式")
    private String listClass;

    /**
     * 是否默认（Y是 N否）.
     */
    @ApiModelProperty("是否默认（Y是 N否）")
    private String isDefault;

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
