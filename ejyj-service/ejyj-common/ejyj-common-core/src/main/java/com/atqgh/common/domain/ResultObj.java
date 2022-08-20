package com.atqgh.common.domain;

import com.atqgh.common.enums.ResultStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * 返回数据.
 *
 *
 * @author Mubai
 */
@Getter
@Setter
public final class ResultObj<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private ResultObj(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功.
     * @param data 数据
     * @param <T> 泛型
     * @return 结果
     */
    public static <T> ResultObj<T> success(T data) {

        return new ResultObj<T>(ResultStatus.SUCCESS.getCode(), ResultStatus.SUCCESS.getMessage(), data);
    }

    /**
     * 成功.
     * @param msg 消息
     * @param data 数据
     * @param <T> 泛型
     * @return 结果
     */
    public static <T> ResultObj<T> success(String msg, T data) {
        return new ResultObj<T>(ResultStatus.SUCCESS.getCode(), msg, data);
    }


    /**
     * 错误参数.
     * @return 结果
     */
    public static ResultObj<Object> error() {
        return new ResultObj<Object>(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), ResultStatus.BUSINESS_REQUEST_FAILED.getMessage(), null);
    }

    /**
     * 错误参数.
     * @param msg 消息
     * @return 结果
     */
    public static ResultObj<Object> error(String msg) {
        return error(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), msg, null);
    }

    /**
     * 错误结果.
     * @param code 编码
     * @param msg 消息
     * @return 结果
     */
    public static ResultObj<Object> error(int code, String msg) {

        return error(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), msg, null);
    }

    /**
     * 错误结果.
     * @param code 编码
     * @param msg 消息
     * @param data 数据
     * @param <T> 泛型
     * @return 结果
     */
    public static <T> ResultObj<T> error(int code, String msg, T data) {

        return new ResultObj<T>(code, msg, data);
    }

//    /**
//    * 利用fastjson进行反序列化.
//    *
//    * @param typeReference 转换的目标对象
//    * @param <T> 目标对象类型
//    * @return 结果
//    */
//    public <T> T getData(TypeReference<T> typeReference) {
//
//        T t = JSON.parseObject(data, typeReference);
//        String key = "data";
//        return getData(key, typeReference);
//    }
//
//    /**
//    * 利用fastjson进行反序列化.
//    * @param key key
//    * @param typeReference 类型
//    * @param <T> 参数类型
//    * @return 结果
//    */
//    public <T> T getData(String key, TypeReference<T> typeReference) {
//        // 默认是map
//        Object data = get(key);
//        String jsonString = JSON.toJSONString(data);
//        T t = JSON.parseObject(jsonString, typeReference);
//        return t;
//    }

}
