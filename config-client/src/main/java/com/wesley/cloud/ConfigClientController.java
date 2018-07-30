package com.wesley.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

  /**
   * 从配置服务读取配置文件信息
   */
  @Value("${spring.application.name}")
  private String profile;

  @GetMapping("/app-name")
  public String getProfile() {
    return this.profile;
  }
}
