package com.wesley.auth.config;

import com.wesley.auth.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;

/**
 * <p>
 *  OAuth2 认证服务器配置
 * </p>
 *
 * @author Created by Yani on 2019/12/17
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Bean
    public TokenStore tokenStore() {
        // 使用数据库存储Token信息
//        return new JdbcTokenStore(dataSource);
        // JWT 格式令牌
        return new JwtTokenStore(jwtTokenEnhancer());
    }

    /**
     * {@link org.springframework.security.oauth2.provider.endpoint.TokenKeyEndpoint} 需要依赖JwtAccessTokenConverter
     */
    @Bean
    public JwtAccessTokenConverter jwtTokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        // 设置签名Key
//        converter.setSigningKey("123456");
        // 使用证书作为签名Key
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jojo.key"), "123456".toCharArray());
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("jojo"));
        return converter;
    }

    /**
     * 配置非安全特性相关信息
     * 比如: token存储, token自定义,
     * You shouldn't need to do anything by default, unless you need
     * password grants, in which case you need to provide an {@link AuthenticationManager}.
     *
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .userDetailsService(userDetailsService)
                // Token存储方式
                .tokenStore(tokenStore())
                .tokenEnhancer(jwtTokenEnhancer())
                .authenticationManager(authenticationManager);
    }

    /**
     * 配置与客户端相关的信息
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        String secret = passwordEncoder.encode("123456");

        // 客户端信息 来自内存
        /**
        clients.inMemory()
               // 客户端Id
               .withClient("orderService")
               // 客户端密钥 , Id和密钥用于HttpBasic认证
               .secret(secret)
               // 当前Client 能够访问资源服务器的 自定义权限
               .scopes("read", "write")
               // 当前Client Token有效时间 单位:秒
               .accessTokenValiditySeconds(3600)
               // 当前Client 能够访问哪些 资源服务器, 为空则可以访问所有资源服务器
               .resourceIds("order-service")
               // 当前Client 支持哪些OAuth2的授权模式
               .authorizedGrantTypes("password");
        */
        // 客户端信息 来自数据库
        clients.jdbc(dataSource);
    }

    /**
     * 授权服务器的安全配置
     * 比如 /oauth/token, /oauth/authorize 也需要是安全的
     *
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                // 访问 /oauth/token_key Endpoint需要身份认证
                .tokenKeyAccess("isAuthenticated()")
                // 验证token 也需要是已授权的
                .checkTokenAccess("isAuthenticated()");
    }
}
