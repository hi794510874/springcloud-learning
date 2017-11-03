package com.owen.controller;

import com.owen.mapper.BlogMapper;
import com.owen.model.BlogEntity;
import com.owen.model.CommonRS;
import com.owen.model.Head;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by huang_b on 2017/9/25.
 *//*
@RequestMapping("blog")*/
@RestController
public class BlogController {

    @Autowired
    private BlogMapper blogMapper;

    /*@GetMapping(value = "getblogbyid")*/
    @RequestMapping(value = "/getblogbyid/{id}", method = RequestMethod.GET)
    public CommonRS<BlogEntity> getBlogById(@PathVariable String id) {
        BlogEntity blogEntity = blogMapper.getOne(id);
        CommonRS<BlogEntity> blogEntityCommonRS = new CommonRS<>();
        Head head = new Head();
        head.setCode(200);
        head.setMsg("ok");
        blogEntityCommonRS.setData(blogEntity);
        blogEntityCommonRS.setHead(head);
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
}
