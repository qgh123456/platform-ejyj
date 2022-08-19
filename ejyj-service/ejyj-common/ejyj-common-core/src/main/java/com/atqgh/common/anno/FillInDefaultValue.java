package com.atqgh.common.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 给请求参数中加入默认的值，如果请求参数只有一个对象，clazz属性可以不写，默认是该对象.
 * @since 2022/2/28 3:40 下午
 * @author qiguohui
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface FillInDefaultValue {

    /**
     * 排序字段名称.
     * @return 排序字段名称
     */
    String[] filedNames();

    /**
     * 设置默认值.
     * @return 默认值
     */
    String[] values();

    /**
     * 目标类型.
     *
     * @return 目标类型
     */
    Class clazz() default Object.class;

}
