package org.wesley.cloud.jms;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * @author Created by Wesley on 2016/10/17.
 */
@Component
public class Sender {

    /**
     * AmqpTemplate接口定义了一套针对AMQP协议的基础操作
     */
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}
