package org.wesley.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 分布式配置中心
 * @author Created by Wesley on 2016/9/12.
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApp {

    public static void main(String[] args){
        SpringApplication.run(ConfigServerApp.class, args);
    }
}
