package com.bbdog.study.springboot.summary.demo.common.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *      redis操作公共类
 * </p>
 *
 * @author cheng.wang
 * @version Id：RedisUtil.java Date：2021/3/17 14:52 Version：1.0
 */
@Slf4j
@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private RedissonClient redissonClient;

    /**
     * redis插入，并设置key的存活时间，单位为秒
     * (如果是相同的key，则覆盖内容，返回true)
     *
     * @param key key
     * @param object value
     * @param timeOut key存活时间(秒)
     **/
    public void set(String key, Object object, long timeOut){
        log.error("set request：key={}，value={}", key, object);
        String value = JSONObject.toJSONString(object);
        redisTemplate.execute((RedisConnection redisConnection) -> {
            byte[] redisKey = redisTemplate.getStringSerializer().serialize(key);
            byte[] redisValue = redisTemplate.getStringSerializer().serialize(value);
            redisConnection.set(redisKey, redisValue);
            if (timeOut > 0) {
                redisTemplate.expire(key, timeOut, TimeUnit.SECONDS);
            }
            return true;
        });
    }

    /**
     * 根据key获得指定类型的value
     *
     * @param key key
     * @param clazz 类型的Class对象
     * @return T
     **/
    public <T> T getObjByKey(String key, Class<T> clazz){
        log.error("getObjByKey request：key={}，clazz={}", key, clazz);

        //根据key获取value
        String value = get(key);
        //将字符串转为指定类型的对象
        T result = JSONObject.parseObject(value, clazz);

        log.error("getObjByKey request：key={}，clazz={}", key, clazz);
        return result;
    }

    /**
     * redisTemplate的get操作
     *
     * @param key redisKey
     * @return java.lang.String
     **/
    public String get(String key){
        log.error("get request：key={}", key);
        String result = (String) redisTemplate.execute((RedisConnection redisConnection) -> {
            byte[] redisKey = redisTemplate.getStringSerializer().serialize(key);
            byte[] bytes = redisConnection.get(redisKey);
            return redisTemplate.getStringSerializer().deserialize(bytes);
        });
        log.error("get response：{}", result);
        return result;
    }

    public void tryLock(String key) throws InterruptedException {
        RLock lock = redissonClient.getLock(key);
        if (lock.tryLock(5, -1, TimeUnit.SECONDS)) {
            try {
                log.info("获取锁成功");
            } finally {
                lock.unlock();
            }
        } else {
            log.info("获取锁失败");
        }
    }

}
