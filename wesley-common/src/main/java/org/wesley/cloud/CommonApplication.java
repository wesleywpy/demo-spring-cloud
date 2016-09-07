package org.wesley.cloud;

/**
 * @author Created by Wesley on 2016/8/11.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CommonApplication {

    public static void main(String[] args){
        SpringApplication.run(CommonApplication.class, args);
    }
}
