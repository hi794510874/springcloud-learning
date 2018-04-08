package com.owen.redis.config;

import com.owen.spring.cloud.config.git.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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

    @Autowired
    private RedisConfig redisConfig;

    @Bean
    @RefreshScope
    public JedisCluster CreateJedisClusterInstance() {
        String s = redisConfig.getRedisClusterConnectionStr();
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
