package com.owen.controller;

import com.netflix.discovery.converters.Auto;
import com.owen.jsonUtil.JacksonUtils;
import com.owen.mapper.BlogMapper;
import com.owen.model.BlogEntity;
import com.owen.model.CommonRQ;
import com.owen.model.CommonRS;
import com.owen.model.Head;
import com.owen.rabbitmqUtil.RmqConfig;
import com.owen.redis.helper.RedisHelper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.SpanAccessor;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Created by huang_b on 2017/9/25.
 * redis  自动缓存 http://blog.csdn.net/tianyaleixiaowu/article/details/70314277
 *//*
@RequestMapping("blog")*/
@RestController
public class BlogController {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private Tracer tracer;

    @Autowired
    private SpanAccessor accessor;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RmqConfig rmqConfig;

    /*@GetMapping(value = "getblogbyid")*/
    @RequestMapping(value = "/getblogbyid/{id}", method = RequestMethod.GET)
    public CommonRS<BlogEntity> getBlogById(@PathVariable String id) throws Exception {

        BlogEntity blogEntity = blogMapper.getOne(id);
        CommonRS<BlogEntity> blogEntityCommonRS = new CommonRS<>();
        Head head = new Head();
        head.setCode(200);
        head.setMsg("ok");
        blogEntityCommonRS.setData(blogEntity);
        blogEntityCommonRS.setHead(head);
        this.tracer.addTag("request", JacksonUtils.toJson(id));
        this.tracer.addTag("response", JacksonUtils.toJson(blogEntityCommonRS));


        return blogEntityCommonRS;
    }

    @RequestMapping(value = "getAllBlog", method = RequestMethod.GET)
    public CommonRS<List<BlogEntity>> getAllBlog() {
        List<BlogEntity> blogEntityList = blogMapper.getAll();
        CommonRS<List<BlogEntity>> listBlogCommonRS = new CommonRS<>();
        listBlogCommonRS.setData(blogEntityList);
        Head head = new Head();
        head.setMsg("ok");
        head.setCode(200);
        listBlogCommonRS.setHead(head);

        return listBlogCommonRS;
    }

    @RequestMapping(value = "addBlog/{id}", method = RequestMethod.POST)
    public CommonRS<Boolean> addBlog(@RequestBody CommonRQ<BlogEntity> request, @PathVariable String id) {
        BlogEntity entity = request.data;
        entity.setId(id);
        blogMapper.insert(entity);

        CommonRS<Boolean> rs = new CommonRS<>();
        Head head = new Head();
        head.setCode(200);
        head.setMsg("ok");
        rs.setData(true);
        rs.setHead(head);

        this.tracer.addTag("request", JacksonUtils.toJson(request));
        this.tracer.addTag("response", JacksonUtils.toJson(rs));
        return rs;
    }

    @RequestMapping(value = "/delblogbyid/{id}", method = RequestMethod.GET)
    public CommonRS<Boolean> delBlogById(@PathVariable String id) {

        CommonRS<Boolean> rs = new CommonRS<>();
        Head head = new Head();
        head.setCode(200);
        head.setMsg("ok");

        blogMapper.delete(id);

        rs.setData(true);
        rs.setHead(head);
        return rs;
    }

    @RequestMapping(value = "/updateblogbyid/{id}", method = RequestMethod.POST)
    public CommonRS<BlogEntity> updateBlogById(@RequestBody CommonRQ<BlogEntity> request) throws Exception {

        blogMapper.update(request.data);
        CommonRS<BlogEntity> blogEntityCommonRS = new CommonRS<>();
        Head head = new Head();
        head.setCode(200);
        head.setMsg("ok");
        blogEntityCommonRS.setData(request.data);
        blogEntityCommonRS.setHead(head);
        this.tracer.addTag("request", JacksonUtils.toJson(request));
        this.tracer.addTag("response", JacksonUtils.toJson(blogEntityCommonRS));

        return blogEntityCommonRS;
    }


    @RequestMapping(value = "/saveperson2redis/{id}", method = RequestMethod.POST)
    public CommonRS<Boolean> saveperson2redis(@RequestBody CommonRQ<BlogEntity> request) {

        CommonRS<Boolean> rs = new CommonRS<>();
        Head head = new Head();
        head.setCode(200);
        head.setMsg("ok");

        String hash = "ddd";

        redisTemplate.opsForHash().put(hash, "kkkt", request);

        request = (CommonRQ<BlogEntity>) redisTemplate.opsForHash().get(hash, "kkkt");
        rs.setData(true);
        rs.setHead(head);
        return rs;
    }

    private static final String EXCHANGE_NAME = "logs";

    @RequestMapping(value = "/sendrmqmessage/{id}", method = RequestMethod.POST)
    public CommonRS<Boolean> sendRmqMessage(@RequestBody CommonRQ<BlogEntity> request) throws IOException, TimeoutException {

        CommonRS<Boolean> result = new CommonRS<Boolean>();
        String host = rmqConfig.getrmqHost();
        String port = rmqConfig.getRmqProt();
        String userName = rmqConfig.getRmqUserName();
        String passWord = rmqConfig.getRmqPassword();

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(Integer.parseInt(port));
        factory.setUsername(userName);
        factory.setPassword(passWord);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        String message = JacksonUtils.toJson(request);

        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();


        return result;
    }
}
