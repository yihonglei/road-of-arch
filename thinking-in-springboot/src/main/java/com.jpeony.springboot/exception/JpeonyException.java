package com.jpeony.springboot.exception;

/**
 * 自定义异常
 *
 * @author yihonglei
 */
public class JpeonyException extends RuntimeException {
    private Integer code;

    private String msg;

    public JpeonyException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public JpeonyException(Integer code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {

        return code;
    }

    public String getMsg() {

        return msg;
    }
}
