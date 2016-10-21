package org.wesley.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author Created by Wesley on 2016/10/17
 */
@SpringBootApplication
public class MqAppliction {

    public static void main(String[] args){
        SpringApplication.run(MqAppliction.class, args);
    }

}
