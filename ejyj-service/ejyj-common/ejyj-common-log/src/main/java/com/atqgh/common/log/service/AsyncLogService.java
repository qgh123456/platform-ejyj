package com.atqgh.common.log.service;

import com.atqgh.common.core.constants.SecurityConstants;
import com.atqgh.system.api.service.ILogService;
import com.atqgh.system.api.vo.SysOperLogVo;
import javax.annotation.Resource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步调用日志服务.
 * 
 * @author Mubai
 */
@Service
public class AsyncLogService {

    @Resource
    private ILogService logService;

    /**
     * 保存系统日志记录.
     * @param sysOperLog 参数
     */
    @Async
    public void saveSysLog(SysOperLogVo sysOperLog) {
        logService.saveLog(sysOperLog, SecurityConstants.INNER);
    }
}
