package com.owen.controller;

import com.owen.model.Person;
import com.owen.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by huang_b on 2017/9/25.
 */
@RestController
@RequestMapping("hello")
public class HelloController {
    @Autowired
    HelloService helloService;


    @RequestMapping(value = "/getperson")
    public String getPerson() {
        String str = helloService.getPerson("Bob");
        return str;
    }

    @RequestMapping(value = "/saveperson")
    public String savePerson() {
        Person person = new Person();
        person.setAge(22);
        person.setName("lily ");
        person.setBirthday(new Date());
        return helloService.savePerson(person);
    }
}
