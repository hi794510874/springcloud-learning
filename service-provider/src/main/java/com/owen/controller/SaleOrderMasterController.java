package com.owen.controller;

import com.owen.jsonUtil.JacksonUtils;
import com.owen.mapper.PkgSalesOrderMasterEntityMapper;
import com.owen.model.*;
import com.owen.rabbitmqUtil.RmqHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by huang_b on 2018/4/3.
 */

@RestController("/order")
public class SaleOrderMasterController {
    @Autowired
    private PkgSalesOrderMasterEntityMapper salesOrderMasterEntityMapper;

/*    @Autowired
    private PkgOrderMasterANDPkgSalesOrderMasterMapper pkgOrderMasterANDPkgSalesOrderMasterMapper;*/


    @Autowired
    private RmqHelper rmqHelper;
    @Autowired
    private Tracer tracer;

    @RequestMapping(value = "/getsalesordermasterbyorderno/{orderno}", method = RequestMethod.GET)
    public CommonRS<PkgSalesOrderMasterEntity> getSaleOrderMasterByOrderNo(@PathVariable int orderno) {
        PkgSalesOrderMasterEntity result = salesOrderMasterEntityMapper.selectByPrimaryKey(orderno);

        CommonRS<PkgSalesOrderMasterEntity> commonRS = new CommonRS<>();
        commonRS.setData(result);
        Head head = new Head();
        head.setMsg("ok");
        head.setCode(200);
        commonRS.setHead(head);
        return commonRS;
    }

/*    @RequestMapping(value = "/getsaleordermasterandpkgordermaster/{pkgorderno}", method = RequestMethod.GET)
    public CommonRS<PkgOrderMasterANDPkgSalesOrderMaster> getSaleOrderMasterByOrderNo(@PathVariable String pkgorderno) {
        PkgOrderMasterANDPkgSalesOrderMaster result = pkgOrderMasterANDPkgSalesOrderMasterMapper.selectSalesOrderMasterANDPkgOrderMasterByPkgOrderNo(pkgorderno);

        CommonRS<PkgOrderMasterANDPkgSalesOrderMaster> commonRS = new CommonRS<>();
        commonRS.setData(result);
        Head head = new Head();
        head.setMsg("ok");
        head.setCode(200);
        commonRS.setHead(head);

        this.tracer.addTag("request", JacksonUtils.toJson(pkgorderno));
        this.tracer.addTag("response", JacksonUtils.toJson(commonRS));

        return commonRS;
    }*/

    private static final String EXCHANGE_NAME = "logs";

    @RequestMapping(value = "/sendrmqmessage/{id}", method = RequestMethod.POST)
    public CommonRS<Boolean> sendRmqMessage(@RequestBody CommonRQ<BlogEntity> request) throws IOException, TimeoutException {

        CommonRS<Boolean> result = new CommonRS<Boolean>();
        rmqHelper.initAmq();
        rmqHelper.send(JacksonUtils.toJson(request));
        result.setData(true);
        return result;
    }
}
