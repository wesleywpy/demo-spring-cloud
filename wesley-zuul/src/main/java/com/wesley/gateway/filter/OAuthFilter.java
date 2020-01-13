package com.wesley.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.wesley.gateway.dto.TokenInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * OAuth 认证过滤器
 * </p>
 *
 * @author Created by Yani on 2019/12/25
 */
@Slf4j
//@Component SpringSecurity已实现
public class OAuthFilter extends ZuulFilter {

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。
     * pre，代表会在请求被路由之前执行。
     * post:  路由到微服务以后执行
     * error: {@link ZuulFilter#run()} 抛出异常执行
     * route: 请求路由到微服务
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        if(StringUtils.startsWith(request.getRequestURI(), "/token")) {
            log.info("----- 认证请求不进行验证 {} ------", request.getRequestURI());
            return null;
        }

        String authHeader = request.getHeader("Authorization");

        if(StringUtils.isBlank(authHeader)) {
            return null;
        }

        if(!StringUtils.startsWithIgnoreCase(authHeader, "bearer ")) {
            return null;
        }

        try {
            TokenInfo info = getTokenInfo(authHeader);
            request.setAttribute("tokenInfo", info);

        } catch (Exception e) {
            log.error("get token info fail", e);
        }

        return null;
    }

    /**
     * 通过认证服务器 校验Token
     * @param authHeader
     * @return
     */
    private TokenInfo getTokenInfo(String authHeader) {
        String token = StringUtils.substringAfter(authHeader, "bearer ");
        String oauthServiceUrl = "http://localhost:9090/oauth/check_token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        // Basic认证, Basic gateway:123456
        headers.set("Authorization", "Basic Z2F0ZXdheToxMjM0NTY=");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("token", token);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);

        ResponseEntity<TokenInfo> response = restTemplate.exchange(oauthServiceUrl, HttpMethod.POST, entity, TokenInfo.class);
        log.info("token info :" + response.getBody());

        return response.getBody();
    }
}
