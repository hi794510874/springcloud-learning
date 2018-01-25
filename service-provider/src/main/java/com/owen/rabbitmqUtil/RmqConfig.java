package com.owen.rabbitmqUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by huang_b on 2018/1/25.
 */
@Component
@RefreshScope
public class RmqConfig {

    @Value("${rabbitmq.host}")
    private String rmqHost;

    public String getrmqHost() {
        return rmqHost;
    }

    @Value("${rabbitmq.port}")
    private String rmqProt;

    public String getRmqProt() {
        return rmqProt;
    }
    @Value("${rabbitmq.username}")
    private String rmqUserName;

    public String getRmqUserName() {
        return rmqUserName;
    }
    @Value("${rabbitmq.password}")
    private String rmqPassword;

    public String getRmqPassword() {
        return rmqPassword;
    }


}
