package com.owen.redis.config;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${spring.redis.cluster.nodes}")
    private String redisClusterConnectionStr;

    @Bean
    public JedisCluster CreateJedisClusterInstance() {

        String s = redisClusterConnectionStr;
        String[] hostAndP = s.split(",");
        HashSet<HostAndPort> set = new HashSet<>();
        for (int i = 0; i < hostAndP.length; i++) {
            String[] hp = hostAndP[i].split(":");
            HostAndPort hostAndPort = new HostAndPort(hp[0], Integer.parseInt(hp[1]));
            set.add(hostAndPort);
        }
        JedisCluster adapter = new JedisCluster(set);

        return adapter;
    }

}
