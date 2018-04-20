package com.owen.controller;

import com.owen.model.CommonRS;
import com.owen.model.PkgOrderMasterANDSalesOrderMasterEntity;
import com.owen.model.PkgSalesOrderMasterEntity;
import com.owen.services.BlogService;
import com.owen.services.SaleOrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by huang_b on 2018/4/17.
 */
@RequestMapping("/order")
@RestController
public class SaleOrderMasterController {
    @Autowired
    private SaleOrderMasterService saleOrderMasterService;
    @Autowired
    private Tracer tracer;

    @RequestMapping(value = "/getsalesordermasterbyorderno/{salesOrderNo}", method = RequestMethod.GET)
    public CommonRS<PkgSalesOrderMasterEntity> getSaleOrderMasterByOrderNo(@PathVariable int salesOrderNo) {
        CommonRS<PkgSalesOrderMasterEntity> commonRS = saleOrderMasterService.getSaleOrderMasterByOrderNo(salesOrderNo);
        return commonRS;
    }

    @RequestMapping(value = "/getsaleordermasterandpkgordermaster/{pkgorderno}", method = RequestMethod.GET)
    public CommonRS<List<PkgOrderMasterANDSalesOrderMasterEntity>> getSaleOrderMasterByOrderNo(@PathVariable String pkgorderno) {
        CommonRS<List<PkgOrderMasterANDSalesOrderMasterEntity>> commonRS = saleOrderMasterService.getSaleOrderMasterByOrderNo(pkgorderno);
        return commonRS;
    }


}
