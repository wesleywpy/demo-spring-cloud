/**
 * 
 */
package com.wesley.user.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpBasic 认证
 * @author Yani
 *
 */
@Component
@Order(2)
public class BasicAuthecationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		System.out.println(2);

		String authHeader = request.getHeader("Authorization");
		
		if(StringUtils.isNotBlank(authHeader)) {
		    // 解析basic Token
			String token64 = StringUtils.substringAfter(authHeader, "Basic ");
			String token = new String(Base64Utils.decodeFromString(token64));
			String[] items = StringUtils.splitByWholeSeparatorPreserveAllTokens(token, ":");
			
			String username = items[0];
			String password = items[1];

			// 后续业务逻辑, 验证用户信息
		}
		

        filterChain.doFilter(request, response);

	}

}
