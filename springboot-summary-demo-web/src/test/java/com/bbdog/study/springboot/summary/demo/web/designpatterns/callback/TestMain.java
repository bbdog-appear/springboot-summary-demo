package com.bbdog.study.springboot.summary.demo.web.designpatterns.callback;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestMain.java Date：2021/4/19 9:48 Version：1.0
 */
@Slf4j
public class TestMain {

    public void testMain(){
        BootClassA bootClassA = new BootClassA();
        bootClassA.setMessage("类A中成员变量的值");
        bootClassA.methodA(new BootInterfaceB() {
            @Override
            public void methodB(String message) {
                log.info("接口B的实现类，开始执行B方法，获取到的消息为：{}", message);
            }
        });
    }

}
