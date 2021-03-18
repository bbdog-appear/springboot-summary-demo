package com.bbdog.study.springboot.summary.demo.web;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;

/**
 * <p>
 *      redis相关测试
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestRedisAutoConfiguration.java Date：2021/3/12 19:48 Version：1.0
 */
public class TestRedisAutoConfiguration extends SpringbootSummaryDemoWebApplicationTests{

    /**
     * 1、这里如果RedisTemplate指定泛型，则需要用@Resource注解，如果不指定泛型，则可以用@Autowired注解，具体原因：
     * https://blog.51cto.com/qiangmzsx/1359952
     * 2、springboot2.0后，RedisTemplate自动注入到spring容器中，所以这里直接可以引用，不用配置RedisConnection
     * 或者RedisTemplate，只需要在application.properties中配置redis数据源即可，且前缀要保证正确。
     */
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testRedisAutoConfiguration() {
        String key = "dogKey";
        String value = "dogValue";
        redisTemplate.execute((RedisCallback<Boolean>) connection -> {
            connection.set(key.getBytes(), value.getBytes());
            return true;
        });
    }

}
