package com.atqgh.common.aspect;

import com.atqgh.common.anno.FillInDefaultValue;
import com.atqgh.common.enums.ResultStatus;
import com.atqgh.common.exception.MicroException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * 填充属性.
 * @since 2022/2/28 3:40 下午
 * @author qiguohui
 */
@Aspect
@Component
@Slf4j
public class FillInDefaultAspect {

    /**
     * 分布式锁point.
     *
     * @param fillInDefaultValue CacheLock注解实例
     */
    @Pointcut("@annotation(fillInDefaultValue)")
    public void pointCut(FillInDefaultValue fillInDefaultValue) {
    }

    /**
     * 给请求参数中加入默认的值.
     * @param joinPoint 切点
     * @param fillInDefaultValue 注解
     */
    @Before(value = "pointCut(fillInDefaultValue)", argNames = "joinPoint,fillInDefaultValue")
    public void before(JoinPoint joinPoint, FillInDefaultValue fillInDefaultValue) {

        // 获取参数值
        Object[] args = joinPoint.getArgs();
        if (ObjectUtils.isNotEmpty(args)) {
            // 获取默认值
            String[] values = fillInDefaultValue.values();
            Class clazz = fillInDefaultValue.clazz();
            String[] filedNames = fillInDefaultValue.filedNames();
            if (args.length == 1) {
                // 如果是一个参数默认为目标类对象
                Object obj = args[0];
                fillInAttr(filedNames, values, obj);
            } else {
                for (Object obj : args) {
                    if (obj.getClass().equals(clazz)) {
                        fillInAttr(filedNames, values, obj);
                    }
                }
            }
        }
    }

    private void fillInAttr(@NonNull String[] filedNames, @NonNull String[] values, Object obj) {

        if (filedNames.length != values.length) {
            throw new MicroException(ResultStatus.FORM_VALIDATION_ERROR.getCode(), "默认值在定义的时候参数有误");
        }
        for (int index = 0; index < filedNames.length; index++) {
            String filedName = filedNames[index];
            String value = values[index];
            try {
                PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(obj.getClass(), filedName);
                assert propertyDescriptor != null;
                Method readMethod = propertyDescriptor.getReadMethod();
                readMethod.setAccessible(true);
                Object filedValue = readMethod.invoke(obj);
                if (ObjectUtils.isNotEmpty(filedValue)) {
                    // 如果设置了属性值直接下一步
                    continue;
                }
                Method writeMethod = propertyDescriptor.getWriteMethod();
                // 填充属性
                writeMethod.setAccessible(true);
                Class<?>[] parameterTypes = writeMethod.getParameterTypes();
                Object attrValue = resetValue(value, parameterTypes);
                // 设置默认值
                writeMethod.invoke(obj, attrValue);
            } catch (Exception e) {
                throw new MicroException(ResultStatus.FORM_VALIDATION_ERROR.getCode(), "设置默认值出错");
            }
        }
    }

    private Object resetValue(@NonNull String value, @NonNull Class<?>[] parameterTypes) {

        if (parameterTypes.length != 1) {
            throw new MicroException(ResultStatus.FORM_VALIDATION_ERROR.getCode(), "设置默认值出错");
        }
        Class<?> parameterType = parameterTypes[0];
        if (parameterType.equals(Integer.class)) {
            return Integer.valueOf(value);
        } else if (parameterType.equals(Long.class)) {
            return Long.valueOf(value);
        }
        return value;
    }

}
