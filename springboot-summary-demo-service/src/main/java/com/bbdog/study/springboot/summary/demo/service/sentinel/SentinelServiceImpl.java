package com.bbdog.study.springboot.summary.demo.service.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * 描述
 *
 * @author cheng.wang
 * @version Date：2025/5/20
 */
@Service
public class SentinelServiceImpl {

    @SentinelResource(value = "testSentinel", blockHandler = "handleException", blockHandlerClass = ExceptionUtil.class)
    public String testSentinel() {
        return "testSentinel";
    }

    @SentinelResource(value = "hello", fallback = "helloFallback")
    public String hello(long s) {
        if (s < 0) {
            throw new IllegalArgumentException("invalid arg");
        }
        return String.format("Hello at %d", s);
    }

    @SentinelResource(value = "helloAnother", defaultFallback = "defaultFallback",
            exceptionsToIgnore = {IllegalStateException.class})
    public String helloAnother(String name) {
        if (name == null || "bad".equals(name)) {
            throw new IllegalArgumentException("oops");
        }
        if ("foo".equals(name)) {
            throw new IllegalStateException("oops");
        }
        return "Hello, " + name;
    }

    public String helloFallback(long s, Throwable ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + s;
    }

    public String defaultFallback() {
        System.out.println("Go to default fallback");
        return "default_fallback";
    }

}
