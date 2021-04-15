package com.jpeony.event.util;


import java.util.Map;

import com.jpeony.ipc.http.IpcController;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OkHttpCli {
  private static Logger log = LoggerFactory.getLogger(IpcController.class);
  
  private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
  
  private static final MediaType XML = MediaType.parse("application/xml; charset=utf-8");
  
  @Autowired
  private OkHttpClient okHttpClient;
  
  public String doGet(String url) {
    return doGet(url, null, null);
  }
  
  public String doGet(String url, Map<String, String> params) {
    return doGet(url, params, null);
  }
  
  public String doGet(String url, String[] headers) {
    return doGet(url, null, headers);
  }
  
  public String doGet(String url, Map<String, String> params, String[] headers) {
    StringBuilder sb = new StringBuilder(url);
    if (params != null && params.keySet().size() > 0) {
      boolean firstFlag = true;
      for (String key : params.keySet()) {
        if (firstFlag) {
          sb.append("?").append(key).append("=").append(params.get(key));
          firstFlag = false;
          continue;
        } 
        sb.append("&").append(key).append("=").append(params.get(key));
      } 
    } 
    Request.Builder builder = new Request.Builder();
    if (headers != null && headers.length > 0) {
      if (headers.length % 2 == 0) {
        int i;
        for (i = 0; i < headers.length; i += 2) {
          builder.addHeader(headers[i], headers[i + 1]);
        }
      } else {
        log.warn("headers's length[{}] is error.", Integer.valueOf(headers.length));
      }
    }
    Request request = builder.url(sb.toString()).build();
    log.info("do get request and url[{}]", sb.toString());
    return execute(request);
  }
  
  public String doPost(String url, Map<String, String> params) {
    FormBody.Builder builder = new FormBody.Builder();
    if (params != null && params.keySet().size() > 0) {
      for (String key : params.keySet()) {
        builder.add(key, params.get(key));
      }
    }
    Request request = (new Request.Builder()).url(url).post((RequestBody)builder.build()).build();
    log.info("do post request and url[{}]", url);
    return execute(request);
  }
  
  public String doPostJson(String url, String json) {
    log.info("do post request and url[{}]", url);
    return exectePost(url, json, JSON);
  }
  
  public String doPostXml(String url, String xml) {
    log.info("do post request and url[{}]", url);
    return exectePost(url, xml, XML);
  }
  
  private String exectePost(String url, String data, MediaType contentType) {
    RequestBody requestBody = RequestBody.create(contentType, data);
    Request request = (new Request.Builder()).url(url).post(requestBody).build();
    return execute(request);
  }
  
  private String execute(Request request) {
    Response response = null;
    try {
      response = this.okHttpClient.newCall(request).execute();
      if (response.isSuccessful()) {
        return response.body().string();
      }
    } catch (Exception e) {
      log.error(e.getMessage());
    } finally {
      if (response != null) {
        response.close();
      }
    } 
    return "";
  }
}
