package com.owen.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by huang_b on 2017/9/25.
 *//*
@RequestMapping("blog")*/
@RestController
public class BlogController {
    /*@GetMapping(value = "getblogbyid")*/
    @RequestMapping(value = "getblogbyid",method = RequestMethod.GET)
    public String getBlogById(@RequestParam int id) {
        return "等待集成 mybatis";
    }
}
