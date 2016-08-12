package org.wesley.cloud.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by Wesley on 2016/8/11.
 */
@RestController
public class ComputeController {

    private final Log log = LogFactory.getLog(this.getClass());

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b){
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        Integer r = a + b;
        log.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }
}
