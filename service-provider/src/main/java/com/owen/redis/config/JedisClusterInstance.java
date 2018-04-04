package com.owen.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;

/**
 * Created by huang_b on 2017/12/12.
 */
@Configuration
public class JedisClusterInstance {


    @Bean
    public JedisCluster CreateJedisClusterInstance() {
        HashSet<HostAndPort> set = new HashSet<>();
        HostAndPort hostAndPort = new HostAndPort("172.18.21.167", 8003);
        set.add(hostAndPort);
        JedisCluster adapter = new JedisCluster(set);

        return adapter;
    }

}
