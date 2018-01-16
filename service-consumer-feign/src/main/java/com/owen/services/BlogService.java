package com.owen.services;

import com.owen.model.BlogEntity;
import com.owen.model.CommonRQ;
import com.owen.model.CommonRS;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by huang_b on 2018/1/5.
 */

@FeignClient(name = "service-provider")
public interface BlogService {
    @RequestMapping(value = "/getAllBlog", method = RequestMethod.GET)
    CommonRS<List<BlogEntity>> getAllBlog();

    @RequestMapping(value = "/addBlog/{id}", method = RequestMethod.POST)
    CommonRS<Boolean> addBlogOneByOne(@RequestBody CommonRQ<BlogEntity> request, @PathVariable("id") String id);

    @RequestMapping(value = "/getblogbyid/{id}", method = RequestMethod.GET)
    CommonRS<BlogEntity> getBlogById(@PathVariable("id") String id);

}


