package org.wesley.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.core.io.ClassPathResource;

/**
 * 分布式配置中心
 * @author Created by Wesley on 2016/9/12.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApp {

    public static void main(String[] args){
        new SpringApplicationBuilder(ConfigServerApp.class).web(true).run(args);
    }
}
