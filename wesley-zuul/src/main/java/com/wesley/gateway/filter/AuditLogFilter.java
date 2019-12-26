package com.wesley.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  审计日志 过滤器
 * </p>
 *
 * @author Created by Yani on 2019/12/26
 */
@Slf4j
@Component
public class AuditLogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		log.info("----- 审计日志入库 -----");
		return null;
	}



}
