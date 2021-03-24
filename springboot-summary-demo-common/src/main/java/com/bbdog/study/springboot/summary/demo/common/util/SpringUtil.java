package com.bbdog.study.springboot.summary.demo.common.util;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * <p>
 *      spring公共类
 * </p>
 *
 * @author cheng.wang
 * @version Id：SpringUtil.java Date：2021/3/23 10:12 Version：1.0
 */
@Component
@Slf4j
@Getter
public class SpringUtil implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 发布事件
     *
     * @param applicationEvent 事件
     */
    public void publishEvent(ApplicationEvent applicationEvent){
        applicationContext.publishEvent(applicationEvent);
    }

}
