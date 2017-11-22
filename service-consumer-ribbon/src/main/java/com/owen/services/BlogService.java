package com.owen.services;

import com.owen.model.BlogEntity;
import com.owen.model.CommonRQ;
import com.owen.model.CommonRS;
import com.owen.restTemplateUtil.RestTempLateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.web.client.HttpServerErrorException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by huang_b on 2017/11/3.
 */
@Service
public class BlogService {
    @Autowired
    RestTempLateUtil restTempLateUtil;

    @Retryable(value = Exception.class, maxAttempts = 2, backoff = @Backoff(delay = 2000))
    public CommonRS<BlogEntity> getBlogById(String id) throws IOException {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", id);
        TypeReference<CommonRS<BlogEntity>> typeReference = new TypeReference<CommonRS<BlogEntity>>() {
        };
        try {
            CommonRS<BlogEntity> blogEntityCommonRS = restTempLateUtil.Get(hashMap, typeReference, "http://service-provider/getblogbyid/{id}");
            return blogEntityCommonRS;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public CommonRS<List<BlogEntity>> getAllBlog() throws IOException {
        HashMap<String, Object> hashMap = new HashMap<>();
        TypeReference<CommonRS<List<BlogEntity>>> typeReference = new TypeReference<CommonRS<List<BlogEntity>>>() {
        };
        CommonRS<List<BlogEntity>> listBlogEntityCommonRS = restTempLateUtil.Get(hashMap, typeReference, "http://service-provider/getAllBlog");

        return listBlogEntityCommonRS;
    }

    public CommonRS<Boolean> addBlog(CommonRQ<BlogEntity> request, String id) throws IOException {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", id);
        TypeReference<CommonRS<Boolean>> typeReference = new TypeReference<CommonRS<Boolean>>() {
        };
        CommonRS<Boolean> rs = restTempLateUtil.Post(hashMap, "http://service-provider/addBlog/{id}", typeReference, request);
        return rs;
    }
}
