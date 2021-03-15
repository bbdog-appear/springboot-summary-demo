package com.bbdog.study.springboot.summary.demo.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 *      redis相关测试
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestRedisAutoConfiguration.java Date：2021/3/12 19:48 Version：1.0
 */
public class TestRedisAutoConfiguration extends SpringbootSummaryDemoWebApplicationTests{

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Resource
    private RedisTemplate<String, ?> redisTemplate;

    @Test
    void testRedisAutoConfiguration() {
        String key = "dogKey";
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(key.getBytes(), key.getBytes());
                return null;
            }
        });
    }

}
