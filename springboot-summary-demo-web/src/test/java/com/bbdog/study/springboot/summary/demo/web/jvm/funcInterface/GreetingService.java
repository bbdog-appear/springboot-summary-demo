package com.bbdog.study.springboot.summary.demo.web.jvm.funcInterface;

/**
 * <p>
 *      函数式接口
 * </p>
 *
 * @author cheng.wang
 * @version Id：GreetingService.java Date：2021/7/14 19:23 Version：1.0
 */
@FunctionalInterface
public interface GreetingService {

    void sayMessage(String message);

}
