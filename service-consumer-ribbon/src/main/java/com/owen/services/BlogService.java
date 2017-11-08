package com.owen.services;

import com.owen.model.BlogEntity;
import com.owen.model.CommonRS;
import com.owen.restTemplateUtil.RestTempLateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
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

    public CommonRS<BlogEntity> getBlogById(String id) throws IOException {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", id);
        TypeReference<CommonRS<BlogEntity>> typeReference = new TypeReference<CommonRS<BlogEntity>>() {
        };
        CommonRS<BlogEntity> blogEntityCommonRS = restTempLateUtil.Get(hashMap, typeReference,"http://service-provider/getblogbyid/{id}");
        return blogEntityCommonRS;
    }

    public CommonRS<List<BlogEntity>> getAllBlog() throws IOException {
        HashMap<String, Object> hashMap = new HashMap<>();
        TypeReference<CommonRS<List<BlogEntity>>> typeReference = new TypeReference<CommonRS<List<BlogEntity>>>() {
        };
        CommonRS<List<BlogEntity>> listBlogEntityCommonRS = restTempLateUtil.Get(hashMap, typeReference,"http://service-provider/getAllBlog");

        return listBlogEntityCommonRS;
    }
}
