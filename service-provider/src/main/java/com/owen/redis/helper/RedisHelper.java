package com.owen.redis.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by huang_b on 2017/12/6.
 */
public class RedisHelper {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JedisConnection jedisConnection;

    public void stringSet(String key, String value) {


        redisTemplate.opsForValue().set(key, value);
    }

}
