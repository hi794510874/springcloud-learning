package com.owen.controller;

import com.owen.jsonUtil.JacksonUtils;
import com.owen.model.BlogEntity;
import com.owen.model.CommonRQ;
import com.owen.model.CommonRS;
import com.owen.restTemplateUtil.RestTempLateUtil;
import com.owen.services.BlogService;
import com.owen.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.FormParam;
import java.io.IOException;
import java.util.List;

/**
 * Created by huang_b on 2017/11/3.
 */
@RestController
public class BlogController {
    @Autowired
    private Tracer tracer;

    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/getBlogById/{id}", method = RequestMethod.GET)
    public CommonRS<BlogEntity> getBlogById(@PathVariable String id) throws IOException {
        CommonRS<BlogEntity> blogEntityCommonRS = blogService.getBlogById(id);
        this.tracer.addTag("request", JacksonUtils.toJson(id));
        this.tracer.addTag("Response", JacksonUtils.toJson(blogEntityCommonRS));
        return blogEntityCommonRS;
    }

    @RequestMapping(value = "/getAllBlog", method = RequestMethod.GET)
    public CommonRS<List<BlogEntity>> getAllBlog() throws IOException {
        CommonRS<List<BlogEntity>> listBlogEntityCommonRS = blogService.getAllBlog();
        return listBlogEntityCommonRS;
    }

    @RequestMapping(value = "/addBlog/{id}", method = RequestMethod.POST)
    public CommonRS<Boolean> addBlog(@RequestBody CommonRQ<BlogEntity> request, @PathVariable String id) throws IOException {
        CommonRS<Boolean> rs = blogService.addBlog(request, id);
        return rs;
    }
}
