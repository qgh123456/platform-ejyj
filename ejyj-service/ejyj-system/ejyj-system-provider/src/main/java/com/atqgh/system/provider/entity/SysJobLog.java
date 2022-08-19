package com.atqgh.system.provider.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 定时任务调度日志表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Data
@TableName("sys_job_log")
public class SysJobLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任务日志ID.
     */
    @TableId
    private Long id;

    /**
     * 任务名称.
     */
    private String jobName;

    /**
     * 任务组名.
     */
    private String jobGroup;

    /**
     * 调用目标字符串.
     */
    private String invokeTarget;

    /**
     * 日志信息.
     */
    private String jobMessage;

    /**
     * 执行状态（0正常 1失败）.
     */
    private String status;

    /**
     * 异常信息.
     */
    private String exceptionInfo;

    /**
     * 创建时间.
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
