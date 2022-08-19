package com.atqgh.system.provider.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统访问记录.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Data
@TableName("sys_logininfor")
public class SysLogininfor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 访问ID.
     */
    @TableId
    private Long id;

    /**
     * 用户账号.
     */
    private String userName;

    /**
     * 登录IP地址.
     */
    private String ipaddr;

    /**
     * 登录状态（0成功 1失败）.
     */
    private String status;

    /**
     * 提示信息.
     */
    private String msg;

    /**
     * 访问时间.
     */
    private Date accessTime;

}
