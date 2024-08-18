package com.bbdog.study.springboot.summary.demo.web.v2024.v08;

import com.bbdog.study.springboot.summary.demo.web.SpringbootSummaryDemoWebApplication;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class 限流_令牌桶 extends SpringbootSummaryDemoWebApplication {

    /**
     * 以恒定速率往桶中放入令牌
     */
    private RateLimiter rateLimiter = RateLimiter.create(5);

    @Test
    public void testRateLimiter() throws Exception {
        // 突发流量进来后，获取桶中的令牌，获取到执行业务逻辑，获取不到返回限流信息
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            boolean acquire = rateLimiter.tryAcquire();
            if (acquire) {
                log.info("拿到了令牌");
            } else {
                log.info("没拿到令牌，返回错误信息");
            }
        }
        log.info("处理成功");
    }

}
