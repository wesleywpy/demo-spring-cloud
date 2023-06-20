package org.wesley.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Created by Wesley on 2016/8/12.
 */
@RestController
public class CommonController {

    @RequestMapping("/uuid")
    public String uuid() {
        System.out.println("uuid generating ...");
        return UUID.randomUUID().toString();
    }

}
