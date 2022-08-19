package com.atqgh.common.enums;

import lombok.Getter;

/**
 * 结果.
 *
 * @author qiguohui
 * @since 2019/6/24
 */
@Getter
public enum ResultStatus {

    /**
     * 成功.
     */
    SUCCESS(true, 20000, "成功"),

    UNKNOWN_REASON(false, 20001, "未知错误"),

    BAD_SQL_GRAMMAR(false, 21002, "sql语法错误"),

    JSON_PARSE_ERROR(false, 21003, "json解析异常"),

    PARAM_ERROR(false, 21004, "输入的参数不符合规范"),

    FILE_UPLOAD_ERROR(false, 21005, "文件上传错误"),

    EXCEL_DATA_IMPORT_ERROR(false, 21006, "Excel数据导入错误"),

    UNIVERSAL_HANDLER_ERROR(false, 21008, "其他异常"),

    FORM_VALIDATION_ERROR(false, 21009, "表单验证错误"),

    BUSINESS_REQUEST_FAILED(false, 21007, "业务请求失败");

    /**
     * 成功.
     */
    private final Boolean success;

    /**
     * 返回码.
     */
    private final Integer code;

    /**
     * 返回消息.
     */
    private final String message;

    ResultStatus(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

}
