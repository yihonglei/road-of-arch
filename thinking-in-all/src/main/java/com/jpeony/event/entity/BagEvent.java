package com.jpeony.event.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BagEvent implements Serializable {
    private static final long serialVersionUID = 1L;

    private String clientId;

    private String type;

    private Date time;

    private String relativeTime;

    private String timeStr;

    private Date createTime;

    private List<BagFile> files;

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getTimeStr() {
        return this.timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getTime() {
        return this.time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRelativeTime() {
        return this.relativeTime;
    }

    public void setRelativeTime(String relativeTime) {
        this.relativeTime = relativeTime;
    }

    public List<BagFile> getFiles() {
        return this.files;
    }

    public void setFiles(List<BagFile> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "BagEvent{, clientId=" + this.clientId + ", timeStr=" + this.timeStr + ", type=" + this.type + ", createTime=" + this.createTime + ", time=" + this.time + ", relativeTime=" + this.relativeTime + ", files=" + ((this.files == null) ? "" : this.files

                .toString()) + "}";
    }
}
