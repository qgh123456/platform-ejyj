package com.atqgh.system.api.service;

import com.atqgh.common.core.constants.SecurityConstants;
import com.atqgh.common.core.domain.ResultObj;
import com.atqgh.system.api.vo.SysLogininforVo;
import com.atqgh.system.api.vo.SysOperLogVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * 日志操作.
 *
 * @author Mubai
 * @since 2022/8/23 8:25 上午
 **/
public interface ILogService {

    /**
     * 保存系统日志.
     *
     * @param sysOperLog 日志实体
     * @param source 请求来源
     * @return 结果
     */
    @PostMapping("/operlog")
    ResultObj<Boolean> saveLog(@RequestBody SysOperLogVo sysOperLog, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 保存访问记录.
     *
     * @param sysLogininforVo 访问实体
     * @param source 请求来源
     * @return 结果
     */
    @PostMapping("/logininfor")
    ResultObj<Boolean> saveLogininfor(@RequestBody SysLogininforVo sysLogininforVo, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
