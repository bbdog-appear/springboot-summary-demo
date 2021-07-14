package com.bbdog.study.springboot.summary.demo.web.jvm.proxy.dynamicProxy;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：Car.java Date：2021/7/13 15:56 Version：1.0
 */
@Slf4j
public class Car implements IVehicle {

    @Override
    public void run() {
        log.info("小车在跑");
    }

}
