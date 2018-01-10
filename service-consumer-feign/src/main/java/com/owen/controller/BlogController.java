package com.owen.controller;

import com.owen.model.BlogEntity;
import com.owen.model.CommonRS;
import com.owen.services.BlogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by huang_b on 2018/1/5.
 */
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @ApiOperation(value = "获取博客列表")
    @RequestMapping(value = "/getAllBlog", method = RequestMethod.GET)
    public CommonRS<List<BlogEntity>> getAllBlog() {
        CommonRS<List<BlogEntity>> listBlogEntityCommonRS = blogService.getAllBlog();
        return listBlogEntityCommonRS;
    }
}
