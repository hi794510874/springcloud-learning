package com.owen.services;

import com.owen.jsonUtil.JacksonUtils;
import com.owen.model.CommonRS;
import com.owen.model.Head;
import com.owen.model.PkgOrderMasterANDSalesOrderMasterEntity;
import com.owen.model.PkgSalesOrderMasterEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by huang_b on 2018/4/17.
 */
@FeignClient(name = "service-provider")
public interface SaleOrderMasterService {
//PathVariable 里面必须制定 参数名 比较奇怪
    @RequestMapping(value = "/order/getsalesordermasterbyorderno/{salesOrderNo}", method = RequestMethod.GET)
    CommonRS<PkgSalesOrderMasterEntity> getSaleOrderMasterByOrderNo(@PathVariable("salesOrderNo") int salesOrderNo);


    @RequestMapping(value = "/order/getsaleordermasterandpkgordermaster/{pkgorderno}", method = RequestMethod.GET)
    CommonRS<List<PkgOrderMasterANDSalesOrderMasterEntity>> getSaleOrderMasterByOrderNo(@PathVariable("pkgorderno") String pkgorderno);
}
