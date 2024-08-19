package com.bbdog.study.springboot.summary.demo.web.v2024;

import com.bbdog.study.springboot.summary.demo.web.SpringbootSummaryDemoWebApplication;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class 测试汇总类 extends SpringbootSummaryDemoWebApplication {

    /**
     * 测试guava本地缓存
     */
    @Test
    public void testEhcacheGuava() {
        // 突发流量进来后，获取桶中的令牌，获取到执行业务逻辑，获取不到返回限流信息
        LoadingCache<String, String> cache = CacheBuilder.newBuilder().
                maximumSize(100).build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                // 定义缓存加载的方式，比如如果缓存不存在，则从数据库中获取数据
                return "hello " + key;
            }
        });
        String result = cache.getUnchecked("guava");
        log.info("结果:{}", result);
    }

}
