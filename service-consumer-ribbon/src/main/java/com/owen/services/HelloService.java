package com.owen.services;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.owen.model.CommonRQ;
import com.owen.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by huang_b on 2017/9/12.
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getPersonFaile")
    public String getPerson(String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        try {
            ResponseEntity<String> result = restTemplate.exchange("http://service-provider/getperson?name={name}", HttpMethod.GET, entity, String.class, name);
            return result.getBody();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getPersonFaile(String name) {
        return "get person faile";
    }


    public String savePerson(Person person) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/json; charset=UTF-8");
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        CommonRQ<Person> reqEntity = new CommonRQ<>();
        reqEntity.data = person;
        HttpEntity<CommonRQ<Person>> requestEntity = new HttpEntity<>(reqEntity, requestHeaders);
        try {
            ResponseEntity<String> resp = restTemplate.exchange("http://service-provider/saveperson?", HttpMethod.POST, requestEntity, String.class);
            return resp.getBody();
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }
}
