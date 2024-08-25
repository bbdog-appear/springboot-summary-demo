package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.mine.service;

import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.BeanPostProcessor;
import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("mineBeanPostProcessor")
public class MineBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        log.info("初始化前");
        if ("userService".equals(beanName)) {
            ((UserService) bean).setRemark("淘宝用户");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        log.info("初始化后");
        return bean;
    }

}
