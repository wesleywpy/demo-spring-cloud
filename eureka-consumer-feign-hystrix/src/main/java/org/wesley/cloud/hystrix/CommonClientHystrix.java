package org.wesley.cloud.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.wesley.cloud.client.CommonClient;

/**
 * 断路器
 * @author Created by Wesley on 2016/9/8.
 */
@Component
public class CommonClientHystrix implements CommonClient {

    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }

    @Override
    public String consumer() {
        return "fallback";
    }

}
