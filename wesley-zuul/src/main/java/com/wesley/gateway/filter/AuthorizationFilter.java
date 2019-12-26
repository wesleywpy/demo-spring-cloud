package com.wesley.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.wesley.gateway.dto.TokenInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 授权过滤器
 * @author jojo
 */
@Slf4j
@Component
public class AuthorizationFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 3;
    }

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		log.info("authorization start");
		
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		
		if(isNeedAuth(request)) {
			TokenInfo tokenInfo = (TokenInfo)request.getAttribute("tokenInfo");
			
			if(tokenInfo != null && tokenInfo.isActive()) {
				if(!hasPermission(tokenInfo, request)) {
					log.info("audit log update fail 403");
					handleError(403, requestContext);
				}
				// 传递用户信息
				requestContext.addZuulRequestHeader("username", tokenInfo.getUser_name());
			}else {
			    // 认证请求不验证
				if(!StringUtils.startsWith(request.getRequestURI(), "/token")) {
					log.info("audit log update fail 401");
					handleError(401, requestContext);
				}
			}
		}
		
		return null;
	}

    /**
     * 处理异常
     * @param status http状态码
     * @param requestContext 请求上下文
     */
	private void handleError(int status, RequestContext requestContext) {
		requestContext.getResponse().setContentType("application/json");
		requestContext.setResponseStatusCode(status);
		requestContext.setResponseBody("{\"message\":\"auth fail\"}");
		requestContext.setSendZuulResponse(false);
	}

    /**
     * 请求是否有权限
     * @param tokenInfo 认证信息
     */
	private boolean hasPermission(TokenInfo tokenInfo, HttpServletRequest request) {
        // TODO: 2019/12/26 0026 根据业务规则进行处理
		return true;
	}

    /**
     * 请求是否需要授权
     */
	private boolean isNeedAuth(HttpServletRequest request) {
        // TODO: 2019/12/26 0026 根据业务规则进行查询
		return true;
	}

}
