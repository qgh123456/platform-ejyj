package com.atqgh.system.provider.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * 定时任务调度日志表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@ApiModel
@Data
public class SysJobLogAddVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("任务名称")
    @NotNull
    private String jobName;

    @ApiModelProperty("任务组名")
    @NotNull
    private String jobGroup;

    @ApiModelProperty("调用目标字符串")
    @NotNull
    private String invokeTarget;

    @ApiModelProperty("日志信息")
    private String jobMessage;

    @ApiModelProperty("执行状态（0正常 1失败）")
    private String status;

    @ApiModelProperty("异常信息")
    private String exceptionInfo;

}
