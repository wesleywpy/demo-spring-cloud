package org.wesley.cloud.controller;

/**
 * 配置文件
 * @author Created by Wesley on 2016/10/19.
 */
//@RefreshScope
//@RestController
public class ConfigController {

//    @Value("${app.key}")
    private String app_key;

//    @RequestMapping("/app/key")
    public String getAppKey(){
        return app_key;
    }
}
