package com.owen.restTemplateUtil;

import com.owen.jsonUtil.JacksonUtils;
import com.owen.model.CommonRQ;
import com.owen.model.CommonRS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by huang_b on 2017/11/3.
 */
@Component
public class RestTempLateUtil<T> {
    @Autowired
    RestTemplate restTemplate;

    public CommonRS<T> Get(HashMap<String,?> args, Class<T> claszz) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        //todo 这里参数和url还要进一步 封装  可以参考.Net现有的 url 生成变量直接调用
        ResponseEntity<String> result = restTemplate.exchange("http://service-provider/getblogbyid/{id}", HttpMethod.GET, entity, String.class, args);
//        ResponseEntity<String> result = restTemplate.exchange("http://service-provider/getAllBlog", HttpMethod.GET, entity, String.class, args);

        String response = result.getBody();

        CommonRS<T> rs = JacksonUtils.toGenericBean(response, CommonRS.class, claszz);

        return rs;
    }


    public CommonRS<T> Post(T t, Class<T> clszz) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/json; charset=UTF-8");
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        CommonRQ<T> reqEntity = new CommonRQ<>();
        reqEntity.data = t;
        HttpEntity<CommonRQ<T>> requestEntity = new HttpEntity<>(reqEntity, requestHeaders);
        ResponseEntity<String> result = restTemplate.exchange("http://service-provider/saveperson?", HttpMethod.POST, requestEntity, String.class);

        String response = result.getBody();

        CommonRS<T> rs = JacksonUtils.toGenericBean(response, CommonRS.class, clszz);
        return rs;
    }
}
