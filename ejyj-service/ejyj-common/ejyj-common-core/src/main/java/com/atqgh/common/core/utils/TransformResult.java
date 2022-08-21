package com.atqgh.common.core.utils;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;

/**
 * 用于转换.
 * @author Mubai
 * @date 2022/7/3 9:01 下午
 **/
public class TransformResult {

    /**
     * 集合属性赋值.
     *
     * @param list 集合
     * @param clazz 集合
     * @param <T> 类型
     * @return 集合
     */
    public static <T> List<T> entitysToDtos(@NotNull List<?> list, @NotNull Class<T> clazz) {

        if (ObjectUtils.isNotEmpty(list)) {
            List<T> dos = new ArrayList<>(list.size());
            for (Object item : list) {
                T dto;
                try {
                    dto = clazz.newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                BeanUtils.copyProperties(item, dto);
                dos.add(dto);
            }
            return dos;
        }
        return new ArrayList<>();
    }

    /**
     * 转换.
     * @param origin 源对象
     * @param clazz 目标对象类型
     * @param <T> 范型
     * @return 目标对象
     */
    public static <T> T entityToDto(@NotNull Object origin, @NotNull Class<T> clazz) {

        T dto;
        try {
            dto = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        BeanUtils.copyProperties(origin, dto);
        return dto;
    }

}
