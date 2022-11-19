package com.zz.testminio.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

  @Autowired
  private MinioProperties minioProperties;

  @Bean
  MinioClient minioClient() {
    return MinioClient.builder()
            .endpoint(minioProperties.getEndPoint())
            .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
            .build();
  }

}
