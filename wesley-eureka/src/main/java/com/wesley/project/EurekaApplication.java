package com.wesley.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 通过@EnableEurekaServer注解启动一个服务注册中心提供给其他应用进行对话
 * @author Created by Wesley on 2016/7/29.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args){
        SpringApplication.run(EurekaApplication.class, args);
    }
}
