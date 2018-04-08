package com.owen.spring.cloud.config.git;

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

    @Value("${spring.rabbitmq.host}")
    private String rmqHost;

    public String getrmqHost() {
        return rmqHost;
    }

    @Value("${spring.rabbitmq.port}")
    private String rmqProt;

    public String getRmqProt() {
        return rmqProt;
    }

    @Value("${spring.rabbitmq.username}")
    private String rmqUserName;

    public String getRmqUserName() {
        return rmqUserName;
    }

    @Value("${spring.rabbitmq.password}")
    private String rmqPassword;

    public String getRmqPassword() {
        return rmqPassword;
    }

    public String getEnv() {
        return env;
    }

    @Value("${spring.rabbitmq.env}")
    private String env;

    public String getRmqHost() {
        return rmqHost;
    }
}
