package org.wesley.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置文件
 * @author Created by Wesley on 2016/10/19.
 */
@RefreshScope
@RestController
public class ConfigController {

    @Value("${app.key}")
    private String app_key;

    @RequestMapping("/app/key")
    public String getAppKey(){
        return app_key;
    }
}
