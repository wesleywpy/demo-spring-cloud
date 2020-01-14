package com.wesley.gateway.security;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  权限服务, 细粒度的权限控制
 * </p>
 *
 * @author Created by Yani on 2020/01/14
 */
public interface PermissionService {

    /**
     *
     * @param request 客户端请求
     * @param authentication 认证信息
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
