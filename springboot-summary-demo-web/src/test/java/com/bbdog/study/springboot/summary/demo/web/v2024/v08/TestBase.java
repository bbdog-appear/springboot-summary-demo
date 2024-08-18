package com.bbdog.study.springboot.summary.demo.web.v2024.v08;

import com.bbdog.study.springboot.summary.demo.web.SpringbootSummaryDemoWebApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.DelayQueue;

@Slf4j
public class TestBase extends SpringbootSummaryDemoWebApplication {

    @Test
    public void testRedisAutoConfiguration() {
        DelayQueue<Order> queue = new DelayQueue<Order>();
        log.info("=======结果是：{}", queue);
    }

}
