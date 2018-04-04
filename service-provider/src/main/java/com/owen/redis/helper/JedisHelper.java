package com.owen.redis.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.owen.compress.Lz4Helper;
import com.owen.model.PkgSalesOrderMasterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huang_b on 2018/4/4.
 */
@Configuration
public class JedisHelper {


    @Autowired
    private JedisCluster jedisCluster;


    private final String keyPrefix = "jedis:test:%s";

    private String generyKey(String keySuffix) {
        String key = String.format(keyPrefix, keySuffix);
        return key;
    }

    public void strSet(String key, Object value) {
        key = generyKey(key);
        String str = JSON.toJSONStringWithDateFormat(value, "yyy-MM-dd'T'HH:mm:ss.sssX");
        jedisCluster.set(key, str);
        jedisCluster.expire(key, 60 * 20);
    }

    public <T> T strGet(String key, Class<T> tClass) {
        key = generyKey(key);
        String str = jedisCluster.get(key);
        T t = JSON.parseObject(str, tClass);
        return t;
    }

    public void hSet(String key, String filed, Object value) {
        String str = JSON.toJSONStringWithDateFormat(value, "yyy-MM-dd'T'HH:mm:ss.sssX");
        key = generyKey(key);
        jedisCluster.hset(key, filed, str);
        jedisCluster.expire(key, 60 * 20);
    }

    public <T> T hGet(String key, String filed, Class<T> tClass) {
        key = generyKey(key);
        String str = jedisCluster.hget(key, filed);
        T t = JSON.parseObject(str, tClass);

        return t;
    }

    /*
    *写的是  有压缩的
    * */
    public void hSetByte(String key, String filed, Object value) throws IOException {
        key = generyKey(key);
        byte[] k = key.getBytes(Charset.forName("UTF-8"));
        byte[] f = filed.getBytes(Charset.forName("UTF-8"));

        byte[] v = Lz4Helper.lz4Compress(value);

        jedisCluster.hset(k, f, v);
        jedisCluster.expire(key, 60 * 20);
    }

    public <T> T hGetByte(String key, String filed, Class<T> tClass) throws IOException, ClassNotFoundException {
        key = generyKey(key);
        byte[] k = key.getBytes(Charset.forName("UTF-8"));
        byte[] f = filed.getBytes(Charset.forName("UTF-8"));
        byte[] value = jedisCluster.hget(k, f);

        T t = Lz4Helper.lz4Decompress(value);

        return t;
    }

    public void hMset(String key, Map<String, Object> value) {
        key = generyKey(key);
        Map<String, String> map = new HashMap<>();

        for (Map.Entry<String, Object> entry : value.entrySet()) {
            map.put(entry.getKey(), JSON.toJSONStringWithDateFormat(entry.getValue(), "yyy-MM-dd'T'HH:mm:ss.sssX"));
        }

        jedisCluster.hmset(key, map);
        jedisCluster.expire(key, 60 * 20);
    }

    public List<String> hMget(String key, String... fileds) {
        key = generyKey(key);
        List<String> list = jedisCluster.hmget(key, fileds);
        return list;
    }


    public long increate(String key, String filed, int step) {
        key = generyKey(key);
        long t = jedisCluster.hincrBy(key, filed, step);
        return t;
    }


}
