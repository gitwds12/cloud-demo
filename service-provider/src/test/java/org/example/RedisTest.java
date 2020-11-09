package org.example;

import org.example.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisService redisService;

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作key-value都是字符串，最常用


    @Test
    public void t() {
        String value = redisService.get("k1");
        System.out.println( stringRedisTemplate.opsForValue().get("K1"));
        System.out.println("value:"+value);

    }

}
