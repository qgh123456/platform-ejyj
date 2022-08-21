package com.atqgh.common.core.utils.excel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * excel的字段注解.
 * 标注在导入导出的实体类上
 * @author Mubai
 * @date 2022/7/17 9:46 上午
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface FieldIndex {

    /**
     * 导入导出时字段所在的顺序.
     * @return 顺序
     */
    int index();

}
