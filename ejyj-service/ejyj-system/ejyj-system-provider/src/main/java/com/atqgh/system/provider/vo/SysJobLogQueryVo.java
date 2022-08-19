package com.atqgh.system.provider.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 定时任务调度日志表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@ApiModel
@Data
public class SysJobLogQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任务日志ID.
     */
    @ApiModelProperty("任务日志ID")
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
     * 日志信息.
     */
    @ApiModelProperty("日志信息")
    private String jobMessage;

    /**
     * 执行状态（0正常 1失败）.
     */
    @ApiModelProperty("执行状态（0正常 1失败）")
    private String status;

    /**
     * 异常信息.
     */
    @ApiModelProperty("异常信息")
    private String exceptionInfo;

    /**
     * 创建时间.
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

}
