package com.zz.testminio.controller;

import com.zz.testminio.service.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

@RestController
public class MinioController {

  @Autowired
  MinioService minioService;

  @GetMapping("hello")
  public String hello() throws Exception {

    minioService.upload(new FileInputStream("a.txt"), "a.txt", "text/plain");

    return "hello";
  }

  @GetMapping("download")
  public String download() {
    try {
      InputStream download = minioService.download("test.txt");

      FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
      byte[] buffer = new byte[1024];
      int len = 0;
      while((len = download.read(buffer)) != -1) {
        fileOutputStream.write(buffer, 0, len);
      }
      System.out.println("Write ok");

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }
}
