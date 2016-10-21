package org.wesley.cloud;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wesley.cloud.jms.Sender;

/**
 * @author Created by Wesley on 2016/10/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MqAppliction.class)
public class MqApplictionTest {

    @Autowired
    Sender sender;

    /**
     * 先运行MqApplication
     */
    @Test
    public void hello(){
        sender.send();
    }
}