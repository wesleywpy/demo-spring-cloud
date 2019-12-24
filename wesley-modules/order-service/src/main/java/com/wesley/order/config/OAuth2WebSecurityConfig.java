package com.wesley.order.config;

import com.wesley.order.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.*;

/**
 * <p>
 * 应用Web安全配置
 * </p>
 *
 * @author Created by Yani on 2019/12/24
 */
@Configuration
@EnableWebSecurity
public class OAuth2WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Bean
    public ResourceServerTokenServices tokenServices() {
        // 与认证服务器通信, 进行Token验证
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId("orderService");
        tokenServices.setClientSecret("123456");
        tokenServices.setCheckTokenEndpointUrl("http://localhost:9090/oauth/check_token");
        tokenServices.setAccessTokenConverter(getAccessTokenConverter());
        return tokenServices;
    }

    /**
     * token转换器
     */
    private AccessTokenConverter getAccessTokenConverter() {
        DefaultAccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();
        DefaultUserAuthenticationConverter authenticationConverter = new DefaultUserAuthenticationConverter();
        authenticationConverter.setUserDetailsService(userDetailsService);
        tokenConverter.setUserTokenConverter(authenticationConverter);
        return tokenConverter;
    }
}
