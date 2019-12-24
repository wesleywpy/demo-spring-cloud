package com.wesley.order.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * <p>
 *  OAuth2 资源服务器配置
 * </p>
 *
 * @author Created by Yani on 2019/12/24
 */
@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        // 资源服务器Id 与 认证服务器保持一致
        resources.resourceId("order-service");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            // 权限表达式配置
            .antMatchers(HttpMethod.POST).access("#oauth2.hasScope('write')")
            .antMatchers(HttpMethod.GET).access("#oauth2.hasScope('read')");

    }

}
