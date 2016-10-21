package org.wesley.cloud.jms;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 * @author Created by Wesley on 2016/10/17.
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {

    /**
     * RabbitHandler注解来指定对消息的处理方法
     * @param content
     */
    @RabbitHandler
    public void process(String content) {
        System.out.println("Receiver : " + content);
    }
}
