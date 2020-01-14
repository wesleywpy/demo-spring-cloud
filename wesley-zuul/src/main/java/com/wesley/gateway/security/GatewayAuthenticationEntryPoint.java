package com.wesley.gateway.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.http.AccessTokenRequiredException;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *  认证入口
 * </p>
 *
 * @author Created by Yani on 2020/01/14
 */
@Component
public class GatewayAuthenticationEntryPoint extends OAuth2AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        if (authException instanceof AccessTokenRequiredException) {
            System.out.println("------ 2. 更新用户访问日志结果为 401 ------");
        }else{
            System.out.println("------ 2. 添加用户访问日志结果为 401 ------");
        }
        request.setAttribute("logUpdated", "yes");
        super.commence(request, response, authException);
    }
}
