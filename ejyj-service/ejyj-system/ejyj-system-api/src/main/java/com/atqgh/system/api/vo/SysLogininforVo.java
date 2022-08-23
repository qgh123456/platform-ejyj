package com.atqgh.system.api.vo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统访问记录表 sys_logininfor.
 * 
 * @author Mubai
 */
@Data
public class SysLogininforVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 用户账号. */
    private String userName;

    /** 状态 0成功 1失败. */
    private String status;

    /** 地址. */
    private String ipaddr;

    /** 描述. */
    private String msg;

    /** 访问时间. */
    private Date accessTime;

}
