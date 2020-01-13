package com.wesley.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * <p>
 *  网关在 OAuth2 中作为资源服务器存在
 * </p>
 *
 * @author Created by Yani on 2020/01/13
 */
@Configuration
@EnableResourceServer
public class GatewaySecurityConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            // 请求Token的请求 不进行验证
            .antMatchers("/token/**").permitAll()
            .anyRequest().authenticated();
    }
}
