package com.zz.testminio.service;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.UUID;

@Service
public class MinioService {

  @Autowired
  private MinioClient minioClient;

  @Value("${minio.bucketName}")
  private String bucketName;

  public void upload(InputStream is, String filename, String contentType) throws Exception {
    String uuid = UUID.randomUUID().toString().replace("-", "");
    minioClient.putObject(PutObjectArgs.builder()
            .bucket(bucketName)
            .object(filename).stream(is, is.available(), -1)
            .contentType(contentType)
            .build());
    Character a = new Character('a');
  }

  public InputStream download(String filename) throws Exception {
    return minioClient.getObject(GetObjectArgs.builder()
            .bucket(bucketName)
            .object(filename)
            .build());
  }
}