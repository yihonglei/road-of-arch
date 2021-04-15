package com.jpeony.netty.auto.common;

/**
 * @author yihonglei
 */
public class MessageData {
    private String clientId;
    private String message;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageData{" +
                "clientId='" + clientId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
