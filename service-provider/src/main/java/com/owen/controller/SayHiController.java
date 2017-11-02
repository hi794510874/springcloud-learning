package com.owen.controller;

import com.owen.model.CommonRQ;
import com.owen.model.CommonRS;
import com.owen.model.Head;
import com.owen.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by huang_b on 2017/9/25.
 */
@RestController
public class SayHiController {
    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public CommonRS<String> home(@RequestParam String name) {
        String str = "hi " + name + ",i am from port:" + port;
        CommonRS<String> rs = new CommonRS<>();
        rs.setData(str);
        Head head = new Head();
        head.setCode(200);
        head.setMsg("ok");
        rs.setHead(head);
        return rs;
    }

    @RequestMapping(value = "/getperson",method = RequestMethod.GET)
    public CommonRS<Person> getperson(@RequestParam String name) throws InterruptedException {
        Thread.sleep(5000);
        Person person = new Person();
        person.setAge(22);
        person.setName(name + " from port:" + port);
        person.setBirthday(new Date());
        CommonRS<Person> rs = new CommonRS<>();
        rs.setData(person);
        Head head = new Head();
        head.setCode(200);
        head.setMsg("ok");
        rs.setHead(head);

        return rs;
    }

    @RequestMapping(value = "/saveperson", method = RequestMethod.POST)
    public CommonRS<Person> savePerson(@RequestBody CommonRQ<Person> request) {
        Person person = request.data;
        Person p = new Person();
        p.setBirthday(person.getBirthday());
        p.setName(person.getName() + "  from port:" + port);
        p.setAge(person.getAge());

        CommonRS<Person> rs = new CommonRS<>();
        rs.setData(p);
        Head head = new Head();
        head.setCode(200);
        head.setMsg("ok");
        rs.setHead(head);

        return rs;
    }
}
