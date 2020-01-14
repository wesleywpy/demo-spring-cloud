package com.wesley.gateway.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 审计日志过滤器, 配合SpringSecurity使用
 * </p>
 *
 * @author Created by Yani on 2020/01/14
 */
public class GatewayAuditLogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 用户登录信息
        String user = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("------ 1. 添加 "+ user +"用户访问日志 ------");

        filterChain.doFilter(request, response);

        // 访问日志没有更新过
        if (StringUtils.isBlank((String) request.getAttribute("logUpdated"))) {
            System.out.println("------ 3. 更新访问日志为成功 ------");
        }
    }
}
