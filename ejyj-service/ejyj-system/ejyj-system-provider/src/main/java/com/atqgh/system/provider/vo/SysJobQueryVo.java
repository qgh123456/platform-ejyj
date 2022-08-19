package com.atqgh.system.provider.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 定时任务调度表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@ApiModel
@Data
public class SysJobQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任务ID.
     */
    @ApiModelProperty("任务ID")
    private Long id;

    /**
     * 任务名称.
     */
    @ApiModelProperty("任务名称")
    private String jobName;

    /**
     * 任务组名.
     */
    @ApiModelProperty("任务组名")
    private String jobGroup;

    /**
     * 调用目标字符串.
     */
    @ApiModelProperty("调用目标字符串")
    private String invokeTarget;

    /**
     * cron执行表达式.
     */
    @ApiModelProperty("cron执行表达式")
    private String cronExpression;

    /**
     * 计划执行错误策略（1立即执行 2执行一次 3放弃执行）.
     */
    @ApiModelProperty("计划执行错误策略（1立即执行 2执行一次 3放弃执行）")
    private String misfirePolicy;

    /**
     * 是否并发执行（0允许 1禁止）.
     */
    @ApiModelProperty("是否并发执行（0允许 1禁止）")
    private String concurrent;

    /**
     * 状态（0正常 1暂停）.
     */
    @ApiModelProperty("状态（0正常 1暂停）")
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
     * 备注信息.
     */
    @ApiModelProperty("备注信息")
    private String remark;

}
