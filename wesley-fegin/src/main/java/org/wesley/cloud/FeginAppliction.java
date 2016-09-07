package org.wesley.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author Created by Wesley on 2016/8/12.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeginAppliction {
    public static void main(String[] args){
        SpringApplication.run(FeginAppliction.class, args);
    }
}
