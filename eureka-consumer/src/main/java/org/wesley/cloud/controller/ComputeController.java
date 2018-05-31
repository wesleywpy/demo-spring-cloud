package org.wesley.cloud.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Created by Wesley on 2016/8/11.
 */
@RestController
public class ComputeController {

    private final Log log = LogFactory.getLog(this.getClass());

//    @Autowired
//    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    /**
     * 手动选择服务
     */
//    @RequestMapping("/consumer")
//    public String dc(){
//        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
//        System.out.println(url);
//        return restTemplate.getForObject(url, String.class);
//    }

    /**
     * RestTemplate Ribbon
     */
    @GetMapping("/consumer")
    public String dcRibbon(){
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }
}
