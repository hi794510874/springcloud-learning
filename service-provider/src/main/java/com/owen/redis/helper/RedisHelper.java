package com.owen.redis.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by huang_b on 2017/12/6.
 */
public class RedisHelper {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JedisConnection jedisConnection;

    @Autowired
    JedisPool jedisPool;

    public   void stringSet(String key, String value) {

        Jedis jedis = jedisPool.getResource();
        jedis.set("fff", "fff");




        redisTemplate.opsForValue().set(key, value);
    }

    public String stringGet(String key) {
        Jedis jedis = jedisPool.getResource();

        return jedis.get("fff");
    }
}
