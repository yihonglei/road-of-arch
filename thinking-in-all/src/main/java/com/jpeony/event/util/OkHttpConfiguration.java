package com.jpeony.event.util;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OkHttpConfiguration {
  @Value("${ok.http.connect-timeout}")
  private Integer connectTimeout;
  
  @Value("${ok.http.read-timeout}")
  private Integer readTimeout;
  
  @Value("${ok.http.write-timeout}")
  private Integer writeTimeout;
  
  @Value("${ok.http.max-idle-connections}")
  private Integer maxIdleConnections;
  
  @Value("${ok.http.keep-alive-duration}")
  private Long keepAliveDuration;
  
  @Bean
  public OkHttpClient okHttpClient() {
    return (new OkHttpClient.Builder())
      .sslSocketFactory(sslSocketFactory(), x509TrustManager())
      
      .retryOnConnectionFailure(false)
      .connectionPool(pool())
      .connectTimeout(this.connectTimeout.intValue(), TimeUnit.SECONDS)
      .readTimeout(this.readTimeout.intValue(), TimeUnit.SECONDS)
      .writeTimeout(this.writeTimeout.intValue(), TimeUnit.SECONDS)
      .hostnameVerifier((hostname, session) -> true)
      
      .build();
  }
  
  @Bean
  public X509TrustManager x509TrustManager() {
    return (X509TrustManager) new Object(this);
  }
  
  @Bean
  public SSLSocketFactory sslSocketFactory() {
    try {
      SSLContext sslContext = SSLContext.getInstance("TLS");
      sslContext.init(null, new TrustManager[] { x509TrustManager() }, new SecureRandom());
      return sslContext.getSocketFactory();
    } catch (NoSuchAlgorithmException|java.security.KeyManagementException e) {
      e.printStackTrace();
      return null;
    } 
  }
  
  @Bean
  public ConnectionPool pool() {
    return new ConnectionPool(this.maxIdleConnections.intValue(), this.keepAliveDuration.longValue(), TimeUnit.SECONDS);
  }
}
