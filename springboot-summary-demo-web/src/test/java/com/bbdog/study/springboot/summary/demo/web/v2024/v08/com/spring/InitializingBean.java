package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring;

public interface InitializingBean {

    /**
     * 属性注入后，执行该方法
     *
     * @throws Exception 异常
     */
    void afterPropertiesSet() throws Exception;

}
