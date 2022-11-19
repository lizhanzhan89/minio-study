package com.zz.testminio.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

  private String endPoint;
  private String accessKey;
  private String secretKey;

  public String getEndPoint() {
    return endPoint;
  }

  public MinioProperties setEndPoint(String endPoint) {
    this.endPoint = endPoint;
    return this;
  }

  public String getAccessKey() {
    return accessKey;
  }

  public MinioProperties setAccessKey(String accessKey) {
    this.accessKey = accessKey;
    return this;
  }

  public String getSecretKey() {
    return secretKey;
  }

  public MinioProperties setSecretKey(String secretKey) {
    this.secretKey = secretKey;
    return this;
  }
}
