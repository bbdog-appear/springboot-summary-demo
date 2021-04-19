package com.bbdog.study.springboot.summary.demo.web.designpatterns.callback;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootClassA.java Date：2021/4/19 9:47 Version：1.0
 */
@Slf4j
public class BootClassA {
    private String message;

    public void setMessage(String message){
        this.message = message;
    }

    public void methodA(BootInterfaceB bootInterfaceB){
        log.info("方法A开始执行");
        bootInterfaceB.methodB(message);
        log.info("方法A结束执行");
    }

}
