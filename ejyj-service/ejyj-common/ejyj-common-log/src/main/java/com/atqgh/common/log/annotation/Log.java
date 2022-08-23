package com.atqgh.common.log.annotation;

import com.atqgh.common.log.enums.BusinessType;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.atqgh.common.log.enums.OperatorType;

/**
 * 自定义操作日志记录注解.
 * 
 * @author Mubai
 * @since 2022/8/7 7:06 下午
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 模块.
     * @return 标题
     */
    String title() default "";

    /**
     * 功能.
     * @return 功能
     */
    BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别.
     * @return 类别
     */
    OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数.
     * @return 是否保存请求参数
     */
    boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数.
     * @return 是否保存响应的参数
     */
    boolean isSaveResponseData() default true;
}
