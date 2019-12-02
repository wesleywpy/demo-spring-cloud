package com.wesley.user.config;

import com.wesley.user.support.ThriftClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/12/02
 */
@SpringBootConfiguration
@Data
public class ThriftClientConfig {

    @Value("${thrift.host}")
    private String host;

    @Value("${thrift.port}")
    private int port;

    @Bean(initMethod = "init")
    public ThriftClient rpcThriftClient() {
        ThriftClient rpcThriftClient = new ThriftClient();
        rpcThriftClient.setHost(host);
        rpcThriftClient.setPort(port);
        return rpcThriftClient;
    }
}
