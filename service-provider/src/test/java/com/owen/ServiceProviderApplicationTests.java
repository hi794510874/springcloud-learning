package com.owen;

import com.owen.compress.SnappyHelper;
import com.owen.jsonUtil.JacksonUtils;
import com.owen.model.BlogEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceProviderApplicationTests {

    @Test
    public void contextLoads() throws IOException, ClassNotFoundException {
       /* BlogEntity blogEntity = new BlogEntity();
        blogEntity.setId("345345345");
        blogEntity.setContent("dfsgdgfgdf");
        blogEntity.setTitle("dfgfdgdf");
        byte[] bytes = SnappyHelper.snappyCompress(blogEntity);
        blogEntity = SnappyHelper.snappyDeCompress(bytes);
        System.out.println(JacksonUtils.toJson(blogEntity));*/


    }

}
