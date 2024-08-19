package com.bbdog.study.springboot.summary.demo.web.v2024;

import com.bbdog.study.springboot.summary.demo.web.SpringbootSummaryDemoWebApplication;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.cache.caffeine.CaffeineCacheManager;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
public class 测试汇总类 extends SpringbootSummaryDemoWebApplication {

    /**
     * 测试guava本地缓存
     */
    @Test
    public void testEhcacheGuava() {
        // 突发流量进来后，获取桶中的令牌，获取到执行业务逻辑，获取不到返回限流信息
        LoadingCache<String, String> cache = CacheBuilder.newBuilder().
                // 设置5秒后刷新 更新缓存
                refreshAfterWrite(5, java.util.concurrent.TimeUnit.SECONDS).
                // 写入10分钟后失效 设置合适的过期策略
                expireAfterWrite(10, java.util.concurrent.TimeUnit.SECONDS).
                maximumSize(100).
                // 监听移除通知
                removalListener(removalNotification -> log.info("removed: " + removalNotification.getKey())).
                build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        // 定义缓存加载的方式，比如如果缓存不存在，则从数据库中获取数据fetchData
                        return "模拟从数据库中加载数据,结果: " + key;
                    }
                });
        String result = cache.getUnchecked("guava");
        log.info("结果:{}", result);
    }

    /**
     * 测试本地缓存Caffeine
     */
    @Test
    public void testEhcacheCaffeine() {
        // 突发流量进来后，获取桶中的令牌，获取到执行业务逻辑，获取不到返回限流信息
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                // 设置最后一次写入或访问后经过固定时间过期
                .expireAfterWrite(1, TimeUnit.HOURS)
                // 初始的缓存空间大小
                .initialCapacity(100)
                // 缓存的最大条数
                .maximumSize(2000));
        Objects.requireNonNull(cacheManager.getCache("caffeine")).get("caffeine");
        log.info("结果:{}", cacheManager);
    }

}
