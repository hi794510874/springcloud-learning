package com.owen.spring.cloud.config.git;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by huang_b on 2018/4/8.
 */
@Component
@RefreshScope
public class RedisConfig {
    @Value("${spring.redis.cluster.nodes}")
    private String redisClusterConnectionStr;

    @Value("${spring.redis.cluster.env}")
    private String env;

    public String getEnv() {
        return env;
    }

    public String getRedisClusterConnectionStr() {
        return redisClusterConnectionStr;
    }
}
