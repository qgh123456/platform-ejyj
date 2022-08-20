package com.atqgh.common.exception;

/**
 * 权限异常.
 * @author Mubai
 * @date 2022/6/18 5:52 下午
 **/
public class MicroAuthException extends RuntimeException {

    private static final long serialVersionUID = -6916154462432027437L;

    private final Integer code;

    public MicroAuthException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
