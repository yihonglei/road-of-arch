package com.jpeony.netty.mq.common;

import java.io.Serializable;

/**
 * @author yihonglei
 */
public class Message implements Serializable {
    private String clientId;
    private int cmd;
    private String data;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getCmd() {
        return cmd;
    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MessageData{" +
                "clientId='" + clientId + '\'' +
                ", cmd=" + cmd +
                ", data='" + data + '\'' +
                '}';
    }
}
