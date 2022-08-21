package com.atqgh.common.core.utils.excel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * excel注解.
 * 标注在导入导出的实体类上
 * @author Mubai
 * @date 2022/7/17 9:46 上午
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Sheet {

    /**
     * sheet校验的列数.
     * @return 列数
     */
    int columnLength();

    /**
     * sheet开始读取的行数.
     * @return 开始行数
     */
    int rowStartIndex();

    /**
     * 目标Mapper的名称.
     *
     * @return 目标类型
     */
    String mapperName() default "";

    /**
     * 对应实体类的全路径.
     * @return 结果
     */
    String entityName() default "";

}
