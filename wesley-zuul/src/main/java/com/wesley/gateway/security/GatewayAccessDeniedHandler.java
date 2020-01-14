package com.wesley.gateway.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *  访问拒绝处理器
 * </p>
 *
 * @author Created by Yani on 2020/01/14
 */
@Component
public class  GatewayAccessDeniedHandler extends OAuth2AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
        System.out.println("------ 2. 更新用户访问日志结果为 403 ------");

        request.setAttribute("logUpdated", "yes");

        super.handle(request, response, authException);
    }
}
