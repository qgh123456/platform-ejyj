package com.atqgh.common.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/**
 *json 工具类 .
 *
 * @author Mubai
 * @since 2022/8/13 9:32 上午
 **/
public class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 对象转json的工具类.
     * @param obj 对象
     * @return json字符串
     */
    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        } else {
            try {
                return MAPPER.writeValueAsString(obj);
            } catch (JsonProcessingException var) {
                var.printStackTrace();
                return null;
            }
        }
    }

    /**
     * json字符串转对象.
     * @param json json字符串
     * @param clz 目标对象的class
     * @param <T> 范型
     * @return 目标对象
     * @throws IOException 异常
     */
    public static <T> T parseObject(String json, Class<T> clz) throws IOException {
        return StringUtils.isBlank(json) ? null : MAPPER.readValue(json, clz);
    }

    /**
     * json字符串转对象.
     * @param json json
     * @param type 类型
     * @param <T> 范型
     * @return 目标对象
     * @throws IOException 异常
     */
    public static <T> T parseObject(String json, TypeReference<T> type) throws IOException {
        return StringUtils.isBlank(json) ? null : MAPPER.readValue(json, type);
    }

    /**
     * json字符串转对象.
     * @param json json
     * @param type 类型
     * @param <T> 范型
     * @return 目标对象
     * @throws IOException 异常
     */
    public static <T> T parseArray(String json, TypeReference<T> type) throws IOException {
        return StringUtils.isBlank(json) ? null : MAPPER.readValue(json, type);
    }
}
