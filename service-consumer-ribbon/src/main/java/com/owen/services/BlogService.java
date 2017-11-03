package com.owen.services;

import com.owen.model.BlogEntity;
import com.owen.model.CommonRS;
import com.owen.restTemplateUtil.RestTempLateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huang_b on 2017/11/3.
 */
@Service
public class BlogService {
    @Autowired
    RestTempLateUtil restTempLateUtil;

    public CommonRS<BlogEntity> getBlogById(String id) {
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("id",id);
        CommonRS<BlogEntity> blogEntityCommonRS = restTempLateUtil.Get(hashMap, BlogEntity.class);
        return blogEntityCommonRS;
    }

    public  CommonRS<List<BlogEntity>> getAllBlog(){
        HashMap<String,Object> hashMap=new HashMap<>();
        CommonRS<BlogEntity> blogEntityCommonRS = restTempLateUtil.Get(hashMap, List.class);
        CommonRS<List<BlogEntity>> listBlogEntityCommonRS=new CommonRS<>();

        return listBlogEntityCommonRS;
    }
}
