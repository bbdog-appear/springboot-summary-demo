package com.bbdog.study.springboot.summary.demo.web.v2024;

import com.bbdog.study.springboot.summary.demo.web.SpringbootSummaryDemoWebApplication;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.cache.caffeine.CaffeineCacheManager;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
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

    /**
     * CompletableFuture-Java 8新特性，支持链式操作
     */
    @Test
    public void testCompletableFuture() throws Exception{
        // 丢入Supplier的实现类，执行实现类中的方法
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 32;
        });

        // 非阻塞式链式操作
        // thenApply 方法：接收一个函数作为参数，该函数会应用于future的计算结果。在这个例子中，函数接收result作为输入参数，并返回result + 1作为新的结果
        // thenAccept 方法：接收一个消费者作为参数，该消费者会接收上一步骤（thenApply）的结果，并执行相应的操作。在这个例子中，消费者接收result作为参数，并打印日志信息
        CompletableFuture<Void> resultFuture = future.thenApply(result -> result + 1).thenAccept(result -> log.info("结果是:{}", result));
        // 等待所有步骤完成
        resultFuture.get();
    }

    /**
     * 测试JVM参数配置
     *
     * @param args 入参
     */
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            byte[] bytes = new byte[1024 * 100];
            list.add(bytes);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
