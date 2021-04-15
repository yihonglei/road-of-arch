package com.jpeony.ipc.http.response;


public class SuccessResponseData extends ResponseData {
    public static final String DEFAULT_SUCCESS_MESSAGE = "请求成功";

    public static final Integer DEFAULT_SUCCESS_CODE = Integer.valueOf(200);

    public SuccessResponseData() {
        this.code = DEFAULT_SUCCESS_CODE;
        this.success = Boolean.valueOf(true);
        this.message = "请求成功";
        this.data = null;
    }

    public SuccessResponseData(String message, Object data) {
        this.code = DEFAULT_SUCCESS_CODE;
        this.success = Boolean.valueOf(true);
        this.message = message;
        this.data = data;
    }
}
