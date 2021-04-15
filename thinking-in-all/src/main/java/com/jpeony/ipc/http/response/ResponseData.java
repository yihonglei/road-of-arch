package com.jpeony.ipc.http.response;

public class ResponseData {
  protected Boolean success;
  
  protected Integer code;
  
  protected String message;
  
  protected Object data;
  
  public Boolean getSuccess() {
    return this.success;
  }
  
  public void setSuccess(Boolean success) {
    this.success = success;
  }
  
  public Integer getCode() {
    return this.code;
  }
  
  public void setCode(Integer code) {
    this.code = code;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public void setMessage(String message) {
    this.message = message;
  }
  
  public Object getData() {
    return this.data;
  }
  
  public void setData(Object data) {
    this.data = data;
  }
  
  public ResponseData() {}
  
  public ResponseData(Boolean success, Integer code, String message, Object data) {
    this.success = success;
    this.code = code;
    this.message = message;
    this.data = data;
  }

  @Override
  public String toString() {
    return "ResponseData(success=" + getSuccess() + ", code=" + getCode() + ", message=" + getMessage() + ", data=" + getData() + ")";
  }
}
