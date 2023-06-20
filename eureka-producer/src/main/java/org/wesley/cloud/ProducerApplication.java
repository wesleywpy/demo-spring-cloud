package org.wesley.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Created by Wesley on 2016/8/12.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProducerApplication {

    public static void main(String[] args){
        SpringApplication.run(ProducerApplication.class, args);
    }

}
