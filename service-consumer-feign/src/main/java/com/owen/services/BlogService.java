package com.owen.services;

import com.owen.model.BlogEntity;
import com.owen.model.CommonRS;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;

/**
 * Created by huang_b on 2018/1/5.
 */

@FeignClient(name = "service-provider")
public interface BlogService {
    @RequestMapping(value = "/getAllBlog", method = RequestMethod.GET)
    CommonRS<List<BlogEntity>> getAllBlog();
}
