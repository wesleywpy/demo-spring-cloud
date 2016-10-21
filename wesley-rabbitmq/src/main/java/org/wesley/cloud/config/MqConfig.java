package org.wesley.cloud.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Created by Wesley on 2016/10/17.
 */
@Configuration
public class MqConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }
}
