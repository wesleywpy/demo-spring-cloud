package com.wesley.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Web应用安全 表达式处理器
 * </p>
 *
 * @author Created by Yani on 2020/01/14
 */
@Component
public class GatewayWebSecurityExpressionHandler extends OAuth2WebSecurityExpressionHandler {

    @Autowired
    PermissionService permissionService;

    @Override
    protected StandardEvaluationContext createEvaluationContextInternal(Authentication authentication, FilterInvocation invocation) {
        StandardEvaluationContext evaluationContext = super.createEvaluationContextInternal(authentication, invocation);
        evaluationContext.setVariable("permissionService", permissionService);
        return evaluationContext;
    }

}
