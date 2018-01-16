package com.owen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Map;

/**
 * Created by huang_b on 2018/1/16.
 */

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        AntPathMatcher matcher = new AntPathMatcher();
//        url 不区分大小写
        matcher.setCaseSensitive(false);
        configurer.setPathMatcher(matcher);
    }
}


