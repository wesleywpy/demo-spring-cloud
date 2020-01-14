package com.wesley.gateway.config;

import com.wesley.gateway.filter.GatewayAuditLogFilter;
import com.wesley.gateway.security.GatewayAccessDeniedHandler;
import com.wesley.gateway.security.GatewayAuthenticationEntryPoint;
import com.wesley.gateway.security.GatewayWebSecurityExpressionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.access.ExceptionTranslationFilter;

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

    @Autowired
    GatewayWebSecurityExpressionHandler gatewayWebSecurityExpressionHandler;

    @Autowired
    GatewayAccessDeniedHandler gatewayAccessDeniedHandler;

    @Autowired
    GatewayAuthenticationEntryPoint gatewayAuthenticationEntryPoint;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.expressionHandler(gatewayWebSecurityExpressionHandler)
                 .accessDeniedHandler(gatewayAccessDeniedHandler)
                 .authenticationEntryPoint(gatewayAuthenticationEntryPoint);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 审计日志在 权限验证 之前
        http.addFilterBefore(new GatewayAuditLogFilter(), ExceptionTranslationFilter.class)
            .authorizeRequests()
            // 申请token的请求 不进行验证
            .antMatchers("/token/**").permitAll()
            .anyRequest()
            // 自定义安全表达式, 需要写表达式处理器
            .access("#permissionService.hasPermission(request, authentication)");
    }
}
