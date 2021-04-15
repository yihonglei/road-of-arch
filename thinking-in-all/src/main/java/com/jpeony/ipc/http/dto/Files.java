package com.jpeony.ipc.http.dto;

import java.util.List;

public class Files {
  private List<String> fileName;
  
  private String fileType;
  
  public void setFileName(List<String> fileName) {
    this.fileName = fileName;
  }
  
  public List<String> getFileName() {
    return this.fileName;
  }
  
  public void setFileType(String fileType) {
    this.fileType = fileType;
  }
  
  public String getFileType() {
    return this.fileType;
  }
}
