package com.atqgh.common.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * feign自定义注解.
 * @author Mubai
 * @since 2022/8/7 7:06 下午
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface FeignResultHandler {

    /**
     * 排除需要代理的方法名称集合.
     * @return 排除需要代理的方法名称集合
     */
    String[] exclusionMethods() default {};

    /**
     * 设置默认值.
     * @return 默认值
     */
    String msg() default "远程调用服务失败";

}
