package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.spring5;

import org.springframework.context.ApplicationEvent;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：MyUserEvnet.java date：2023/2/19/0190:07 Version：1.0
 */
public class MyUserEvent extends ApplicationEvent {


    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyUserEvent(Object source) {
        super(source);
        System.out.println("进入自己的事件类");
    }
}
