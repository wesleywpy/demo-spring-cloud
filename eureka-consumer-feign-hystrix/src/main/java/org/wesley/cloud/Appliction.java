package org.wesley.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author Created by Wesley on 2016/8/12.
 */
@SpringCloudApplication
@EnableFeignClients
public class Appliction {

    public static void main(String[] args){
        SpringApplication.run(Appliction.class, args);
    }

}
