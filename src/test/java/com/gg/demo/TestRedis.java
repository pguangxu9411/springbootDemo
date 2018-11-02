package com.gg.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("aaa", "111");
        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
        List li=new ArrayList();
        li.add("p1");
        li.add("p2");
        li.add("p3");

        ValueOperations<String, List> operations=redisTemplate.opsForValue();
        operations.set("com.neox", li);
        operations.set("com.neo.f", li,10, TimeUnit.SECONDS);
        Thread.sleep(1000);
        System.out.println(redisTemplate.hasKey("mykey"));
        //redisTemplate.delete("com.neo.f");
        boolean exists=redisTemplate.hasKey("com.neo.f");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
    }
    @Autowired
    private com.gg.mail.MailService MailService;

    @Test
    public void testSimpleMail() throws Exception {
        MailService.sendSimpleMail("405551007@qq.com","test simple mail"," hello this is simple mail");
    }


}
