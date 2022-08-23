package com.atqgh.common.core.exception;

import com.atqgh.common.core.domain.ResultObj;
import com.atqgh.common.core.enums.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * controller的异常拦截.
 *
 * @author Mubai
 * @since 2022/8/22 11:26 上午
 **/
@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * 系统未知异常.
     * @param exception 异常
     * @return 结果
     */
    @ExceptionHandler(value = MicroException.class)
    public ResultObj<Object> handleException(MicroException exception) {

        return ResultObj.error(exception.getCode(), exception.getMessage());
    }

    /**
     * 系统未知异常.
     * @param throwable 异常
     * @return 结果
     */
    @ExceptionHandler(value = Throwable.class)
    public ResultObj<Throwable> handleException(Throwable throwable) {

        return ResultObj.error(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "系统未知异常", throwable);
    }
}
