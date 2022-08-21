package com.atqgh.common.core.utils.exception;

import lombok.Getter;

@Getter
public enum BizCodeEnum {

    /**
     * 系统未知异常.
     */
    UNKNOW_EXCEPTION(10000, "系统未知异常"),

    /**
     * 参数格式校验失败.
     */
    VAILD_EXCEPTION(10001, "参数格式校验失败"),

    /**
     * 请求流量过大，请稍后再试.
     */
    TO_MANY_REQUEST(10002, "请求流量过大，请稍后再试"),

    /**
     * 验证码获取频率太高，请稍后再试.
     */
    SMS_CODE_EXCEPTION(10002, "验证码获取频率太高，请稍后再试"),

    /**
     * 商品上架异常.
     */
    PRODUCT_UP_EXCEPTION(11000, "商品上架异常"),

    /**
     * 存在相同的用户.
     */
    USER_EXIST_EXCEPTION(15001, "存在相同的用户"),

    /**
     * 存在相同的手机号.
     */
    PHONE_EXIST_EXCEPTION(15002, "存在相同的手机号"),

    /**
     * 商品库存不足.
     */
    NO_STOCK_EXCEPTION(21000, "商品库存不足"),

    /**
     * 账号或密码错误.
     */
    LOGINACCT_PASSWORD_EXCEPTION(15003, "账号或密码错误");

    /**
     * 编码.
     */
    private Integer code;

    /**
     * 消息.
     */
    private String msg;

    BizCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
