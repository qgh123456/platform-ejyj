package com.atqgh.common.core.utils;

import com.atqgh.common.core.exception.MicroException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;

/**
 * 属性赋值.
 *
 * @author Mubai
 * @date 2022/6/29 5:19 下午
 **/
public class PropertiesCopyUtils {

    /**
     * 集合属性赋值.
     *
     * @param list 集合
     * @param clazz 集合
     * @param <T> 类型
     * @return 集合
     */
    public static <T> List<T> entityToDto(List<?> list, @NonNull Class<T> clazz) {

        if (ObjectUtils.isNotEmpty(list)) {
            List<T> dos = new ArrayList<>(list.size());
            for (Object item : list) {
                T dto;
                try {
                    dto = clazz.newInstance();
                } catch (Exception e) {
                    throw new MicroException("对象创建失败", e);
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
    public static <T> T entityToDto(@NonNull Object origin, @NonNull Class<T> clazz) {

        T dto;
        try {
            dto = clazz.newInstance();
        } catch (Exception e) {
            throw new MicroException("对象创建失败", e);
        }
        BeanUtils.copyProperties(origin, dto);
        return dto;
    }
}
