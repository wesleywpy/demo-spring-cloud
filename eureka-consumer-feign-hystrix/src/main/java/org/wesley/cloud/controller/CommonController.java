package org.wesley.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wesley.cloud.client.CommonClient;

/**
 * @author Created by Wesley on 2016/8/12.
 */
@RestController
public class CommonController {

    @Autowired
    CommonClient commonClient;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return commonClient.add(10, 20);
    }

    @RequestMapping("/consumer")
    public String dc() {
        return commonClient.consumer();
    }

}
