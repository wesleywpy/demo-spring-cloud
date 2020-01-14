package com.wesley.gateway.security;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.http.AccessTokenRequiredException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2020/01/14
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        System.out.println("----- " + request.getRequestURI() + " -----");
        System.out.println("----- " + ReflectionToStringBuilder.toString(authentication) + " -----");

        // 未登录用户抛出异常
        if (authentication instanceof AnonymousAuthenticationToken) {
            throw new AccessTokenRequiredException(null);
        }

        // 根据业务逻辑判断用户是否有权限, 通常是从Redis或数据库中获取权限列表

        return RandomUtils.nextInt() % 2 == 0;
    }
}
