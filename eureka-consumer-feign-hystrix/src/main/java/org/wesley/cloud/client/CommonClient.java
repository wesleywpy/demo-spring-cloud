package org.wesley.cloud.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wesley.cloud.hystrix.CommonClientHystrix;

/**
 * @author Created by Wesley on 2016/8/12.
 */
@FeignClient(value = "eureka-client", fallback = CommonClientHystrix.class)
public interface CommonClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

    @GetMapping("/dc")
    String consumer();
}
