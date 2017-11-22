package com.owen.restTemplateUtil;

import com.fasterxml.jackson.core.type.TypeReference;
import com.owen.jsonUtil.JacksonUtils;
import com.owen.model.BlogEntity;
import com.owen.model.CommonRQ;
import com.owen.model.CommonRS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by huang_b on 2017/11/3.
 */
@Component
public class RestTempLateUtil<T> {
    @Autowired
    RestTemplate restTemplate;

    public CommonRS<T> Get(HashMap<String, ?> args, TypeReference<?> typeReference, String url) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        //todo 这里参数和url还要进一步 封装  可以参考.Net现有的 url 生成变量直接调用
//        ResponseEntity<String> result = restTemplate.exchange(, HttpMethod.GET, entity, String.class, args);

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, args);

        String response = result.getBody();

        CommonRS<T> rs = JacksonUtils.toCommonrsListData(response, typeReference);


        return rs;
    }


    public CommonRS<T> Post(HashMap<String, ?> args, String url,  TypeReference<?> typeReference,T t) throws IOException {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/json; charset=UTF-8");
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));

        HttpEntity<T> requestEntity = new HttpEntity<>(t, requestHeaders);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class, args);

        String response = result.getBody();

        CommonRS<T> rs = JacksonUtils.toCommonrsListData(response, typeReference);
        return rs;
    }
}
