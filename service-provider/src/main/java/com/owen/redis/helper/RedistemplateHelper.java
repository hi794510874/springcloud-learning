package com.owen.redis.helper;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.TimeUnit;

/**
 * Created by huang_b on 2017/12/6.
 */
public class RedistemplateHelper {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;



    private final String keyPrefix = "redistemplate:test:%s";

    private String generyKey(String keySuffix) {
        String key = String.format(keyPrefix, keySuffix);
        return key;
    }

    /*==================  string start ==================*/
    public void strSet(String key, String value) {
        key = generyKey(key);
        redisTemplate.opsForValue().set(key, value, 10);
    }

    public Object strGet(String key) {
        key = generyKey(key);
        Object str = redisTemplate.opsForValue().get(key);

        return str;
    }

     /*==================  string end ==================*/
}
