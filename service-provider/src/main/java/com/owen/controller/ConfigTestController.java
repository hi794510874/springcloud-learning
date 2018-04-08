package com.owen.controller;

import com.owen.spring.cloud.config.git.JdbcConfig;
import com.owen.spring.cloud.config.git.RedisConfig;
import com.owen.spring.cloud.config.git.RmqConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huang_b on 2018/4/8.
 */
@RequestMapping("/configtest")
@RestController
public class ConfigTestController {

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private JdbcConfig jdbcConfig;
    @Autowired
    private RmqConfig rmqConfig;

    @RequestMapping(value = "/getredisenv", method = RequestMethod.GET)
    public String getRedisEnv() {
        return redisConfig.getEnv();
    }

    @RequestMapping(value = "/getjdbcenv", method = RequestMethod.GET)
    public String getJdbcEnv() {

        return jdbcConfig.getEnv();
    }
    @RequestMapping(value = "/getrmqnv", method = RequestMethod.GET)
    public String getRmqEnv() {
        return rmqConfig.getEnv();
    }
}
