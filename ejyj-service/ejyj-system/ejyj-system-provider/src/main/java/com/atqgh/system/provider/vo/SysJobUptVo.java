package com.atqgh.system.provider.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * 定时任务调度表.
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@ApiModel
@Data
public class SysJobUptVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("任务ID")
    @NotNull
    private Long id;

    @ApiModelProperty("任务名称")
    @NotNull
    private String jobName;

    @ApiModelProperty("任务组名")
    @NotNull
    private String jobGroup;

    @ApiModelProperty("调用目标字符串")
    @NotNull
    private String invokeTarget;

    @ApiModelProperty("cron执行表达式")
    private String cronExpression;

    @ApiModelProperty("计划执行错误策略（1立即执行 2执行一次 3放弃执行）")
    private String misfirePolicy;

    @ApiModelProperty("是否并发执行（0允许 1禁止）")
    private String concurrent;

    @ApiModelProperty("状态（0正常 1暂停）")
    private String status;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("备注信息")
    private String remark;

}
