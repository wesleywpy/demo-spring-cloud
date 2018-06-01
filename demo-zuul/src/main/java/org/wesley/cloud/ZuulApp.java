package org.wesley.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;
import org.wesley.cloud.filter.AccessFilter;

/**
 * @author Created by Wesley on 2016/9/14.
 */
@SpringCloudApplication
@EnableZuulProxy
public class ZuulApp {

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    public static void  main(String[] args){
        SpringApplication.run(ZuulApp.class, args);
    }
}
