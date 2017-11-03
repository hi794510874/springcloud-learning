package com.owen.controller;

import com.owen.mapper.BlogMapper;
import com.owen.model.BlogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by huang_b on 2017/9/25.
 *//*
@RequestMapping("blog")*/
@RestController
public class BlogController {

    @Autowired
    private BlogMapper blogMapper;

    /*@GetMapping(value = "getblogbyid")*/
    @RequestMapping(value = "getblogbyid",method = RequestMethod.GET)
    public BlogEntity getBlogById(@RequestParam String id) {
        BlogEntity blogEntity= blogMapper.getOne(id);

        return blogEntity;
    }


}
