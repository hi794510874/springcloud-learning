package com.owen.controller;

import com.owen.jsonUtil.JacksonUtils;
import com.owen.model.BlogEntity;
import com.owen.model.CommonRQ;
import com.owen.model.CommonRS;
import com.owen.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by huang_b on 2018/1/5.
 */
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private Tracer tracer;

    @RequestMapping(value = "/getallblog", method = RequestMethod.GET)
    public CommonRS<List<BlogEntity>> getAllBlog() {
        CommonRS<List<BlogEntity>> listBlogEntityCommonRS = blogService.getAllBlog();
        return listBlogEntityCommonRS;
    }

    @RequestMapping(value = "/addblog/{id}", method = RequestMethod.POST)
    public CommonRS<Boolean> addBlog(@RequestBody CommonRQ<BlogEntity> request, @PathVariable String id) {
        CommonRS<Boolean> result = blogService.addBlogOneByOne(request, id);
        return result;
    }

    @RequestMapping(value = "/getblogbyId/{id}", method = RequestMethod.GET)
    public CommonRS<BlogEntity> getBlogById(@PathVariable String id) {
        CommonRS<BlogEntity> blogEntityCommonRS = blogService.getBlogById(id);

        this.tracer.addTag("request", JacksonUtils.toJson(id));
        this.tracer.addTag("Response", JacksonUtils.toJson(blogEntityCommonRS));

        return blogEntityCommonRS;
    }
}
