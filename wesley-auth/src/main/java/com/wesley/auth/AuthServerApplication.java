package com.wesley.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 认证服务器
 * </p>
 *
 * @author Created by Yani on 2019/12/17
 */
@SpringBootApplication(scanBasePackages = "com.wesley.auth")
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class);
    }

}
