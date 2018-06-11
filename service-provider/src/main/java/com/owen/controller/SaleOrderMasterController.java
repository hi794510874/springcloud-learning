package com.owen.controller;

import com.owen.jsonUtil.JacksonUtils;
import com.owen.mapper.PkgOrderMasterANDSalesOrderMasterEntityMapper;
import com.owen.mapper.PkgSalesOrderMasterEntityMapper;
import com.owen.model.*;
import com.owen.rabbitmqUtil.RmqHelper;
import com.owen.redis.helper.JedisHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Created by huang_b on 2018/4/3.
 */

@RequestMapping("/order")
@RestController
public class SaleOrderMasterController {
    Logger logger = Logger.getLogger(SaleOrderMasterController.class);

    @Autowired
    private PkgSalesOrderMasterEntityMapper salesOrderMasterEntityMapper;

    @Autowired
    private PkgOrderMasterANDSalesOrderMasterEntityMapper pkgOrderMasterANDSalesOrderMasterEntityMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RmqHelper rmqHelper;
    @Autowired
    private Tracer tracer;
    @Autowired
    private JedisHelper jedisHelper;

    /*
    * 调用自动生成代码
    * */
    @RequestMapping(value = "/getsalesordermasterbyorderno/{salesOrderNo}", method = RequestMethod.GET)
    public CommonRS<PkgSalesOrderMasterEntity> getSaleOrderMasterByOrderNo(@PathVariable int salesOrderNo) {
        PkgSalesOrderMasterEntity result = salesOrderMasterEntityMapper.selectByPrimaryKey(salesOrderNo);

        CommonRS<PkgSalesOrderMasterEntity> commonRS = new CommonRS<>();
        commonRS.setData(result);
        Head head = new Head();
        head.setMsg("ok");
        head.setCode(200);
        commonRS.setHead(head);
        return commonRS;
    }

    /*
    * 手动 mapping
    * */
    @RequestMapping(value = "/getsaleordermasterandpkgordermaster/{pkgorderno}", method = RequestMethod.GET)
    public CommonRS<List<PkgOrderMasterANDSalesOrderMasterEntity>> getSaleOrderMasterByOrderNo(@PathVariable String pkgorderno) {
        List<PkgOrderMasterANDSalesOrderMasterEntity> result = pkgOrderMasterANDSalesOrderMasterEntityMapper.selectByPkgOrderNo(pkgorderno);

        CommonRS<List<PkgOrderMasterANDSalesOrderMasterEntity>> commonRS = new CommonRS<>();
        commonRS.setData(result);
        Head head = new Head();
        head.setMsg("ok");
        head.setCode(200);
        commonRS.setHead(head);

        this.tracer.addTag("request", JacksonUtils.toJson(pkgorderno));
        this.tracer.addTag("response", JacksonUtils.toJson(commonRS));
        //long traceId = tracer.getCurrentSpan().getTraceId();
        String traceId = tracer.getCurrentSpan().traceIdString();
        logger.debug("traceid" + traceId);
        return commonRS;
    }


    @RequestMapping(value = "/sendrmqmessage/{id}", method = RequestMethod.POST)
    public CommonRS<Boolean> sendRmqMessage(@RequestBody CommonRQ<PkgSalesOrderMasterEntity> request) throws IOException, TimeoutException {

        CommonRS<Boolean> result = new CommonRS<Boolean>();
        rmqHelper.initAmq();
        rmqHelper.send(JacksonUtils.toJson(request));
        result.setData(true);
        return result;
    }

    @RequestMapping(value = "/senddata2redis/{id}", method = RequestMethod.POST)
    public CommonRS<Boolean> sendData2Redis(@RequestBody CommonRQ<PkgSalesOrderMasterEntity> request) throws IOException, ClassNotFoundException {
        CommonRS<Boolean> commonRS = new CommonRS<>();

       /* redisTemplate.opsForHash().put("redistemplate:test:hash", "salesOrderMaster", request.data);
        Object object = redisTemplate.opsForHash().get("redistemplate:test:hash", "salesOrderMaster");*/


        jedisHelper.hSet("hash", "salesOrderMaster", request.data);
        PkgSalesOrderMasterEntity pkgSalesOrderMasterEntity = jedisHelper.hGet("hash", "salesOrderMaster", PkgSalesOrderMasterEntity.class);

        jedisHelper.hSetByte("hash", "salesOrderMaster-byte", request.data);
        pkgSalesOrderMasterEntity = jedisHelper.hGetByte("hash", "salesOrderMaster-byte", PkgSalesOrderMasterEntity.class);

        long ttt = jedisHelper.increate("hash", "incrate", 2);
        long ttttt = jedisHelper.increate("hash", "incrate", -1);

        return commonRS;
    }

}
