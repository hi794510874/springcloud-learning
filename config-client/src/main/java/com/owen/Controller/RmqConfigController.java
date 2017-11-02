package com.owen.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huang_b on 2017/11/2.
 */
@RestController
@RefreshScope //注解@RefreshScope指示Config客户端在服务器配置改变时，也刷新注入的属性值
public class RmqConfigController
{
    @Value("${rmq-address}")
    private String rmqAddress;

    @RequestMapping("/getRmqAddress")
    public  String getRmqAddress(){
        return rmqAddress;
    }
}
