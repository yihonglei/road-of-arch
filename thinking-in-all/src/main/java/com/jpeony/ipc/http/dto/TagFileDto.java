package com.jpeony.ipc.http.dto;


import java.util.List;

public class TagFileDto {
  private String clientId;
  
  private String beginTime;
  
  private String endTime;
  
  private List<Tags> tags;
  
  private List<Files> files;
  
  public void setClientId(String clientId) {
    this.clientId = clientId;
  }
  
  public String getClientId() {
    return this.clientId;
  }
  
  public void setBeginTime(String beginTime) {
    this.beginTime = beginTime;
  }
  
  public String getBeginTime() {
    return this.beginTime;
  }
  
  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }
  
  public String getEndTime() {
    return this.endTime;
  }
  
  public void setTags(List<Tags> tags) {
    this.tags = tags;
  }
  
  public List<Tags> getTags() {
    return this.tags;
  }
  
  public void setFiles(List<Files> files) {
    this.files = files;
  }
  
  public List<Files> getFiles() {
    return this.files;
  }

  @Override
  public String toString() {
    return "TagFileDto{clientId='" + this.clientId + '\'' + ", beginTime='" + this.beginTime + '\'' + ", endTime='" + this.endTime + '\'' + ", tags=" + this.tags + ", files=" + this.files + '}';
  }
}
