/**
 * 
 */
package com.wesley.user.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 审计日志 拦截
 * @author jojo
 *
 */
@Component
@Slf4j
public class AuditLogInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		log.info("-------- 保存 请求日志 --------");

		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		Long auditLogId = (Long) request.getAttribute("auditLogId");

        log.info("-------- 更新 请求日志 --------");
		
	}

}
