package com.owen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huang_b on 2017/9/25.
 */
@RequestMapping("blog")
public class BlogController {
    @GetMapping("getblogbyid")
    public String getBlogById(@PathVariable int id) {
        return "";
    }
}
