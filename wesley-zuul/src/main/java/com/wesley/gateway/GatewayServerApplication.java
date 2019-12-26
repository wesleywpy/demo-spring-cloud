package com.wesley.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * <p>
 *  网关服务
 * </p>
 *
 * @author Created by Yani on 2019/12/25
 */
@SpringBootApplication(scanBasePackages = "com.wesley.gateway")
@EnableZuulProxy
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }

}
