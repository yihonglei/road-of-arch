package com.jpeony.ipc.http.response;


public class ErrorResponseData extends ResponseData {
    public static final String DEFAULT_ERROR_MESSAGE = "服务异常";

    public static final Integer DEFAULT_ERROR_CODE = Integer.valueOf(500);

    public ErrorResponseData() {
        this.code = DEFAULT_ERROR_CODE;
        this.success = Boolean.valueOf(false);
        this.message = "服务异常";
        this.data = null;
    }

    public ErrorResponseData(String message, Object data) {
        this.code = DEFAULT_ERROR_CODE;
        this.success = Boolean.valueOf(false);
        this.message = message;
        this.data = data;
    }

    public ErrorResponseData(Integer code, String message, Object data) {
        this.code = code;
        this.success = Boolean.valueOf(false);
        this.message = message;
        this.data = data;
    }
}
