package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.spring5;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @EventListener
    public void eventMonitor(MyUserEvent event) {
        System.out.println("监听到事件" + JSON.toJSONString(event));
    }

}
