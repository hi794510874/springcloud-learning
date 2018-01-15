package com.owen.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by huang_b on 2017/12/12.
 */
@Configuration
public class JedisClusterInstance {


    @Bean
    public JedisCluster CreateJedisClusterInstance() {
        HashSet<HostAndPort> set = new HashSet<>();
        HostAndPort hostAndPort = new HostAndPort("192.168.119.128", 7000);
        set.add(hostAndPort);
        JedisCluster adapter = new JedisCluster(set);

        return adapter;
    }

}
