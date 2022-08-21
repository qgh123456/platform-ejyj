package com.atqgh.common.core.exception;

/**
 * 自定义异常.
 *
 * @author Mark sunlightcs@gmail.com
 */
public class MicroException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;
    
    public MicroException(String msg) {
        super(msg);
    }

    public MicroException(String msg, Throwable e) {
        super(msg, e);
    }

    public MicroException(int code, String msg, Throwable e) {
        super(msg, e);
        this.code = code;
    }

    public MicroException(int code, String msg) {
        super(msg);
        this.code = code;
    }

}
