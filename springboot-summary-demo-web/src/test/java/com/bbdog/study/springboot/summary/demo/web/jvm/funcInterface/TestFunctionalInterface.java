package com.bbdog.study.springboot.summary.demo.web.jvm.funcInterface;

/**
 * <p>
 *      测试函数式接口
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestFunctionalInterface.java Date：2021/7/14 19:26 Version：1.0
 */
public class TestFunctionalInterface {

    public static void main(String[] args) {
        GreetingService greetingService = message -> System.out.println("Hello " + message);
        greetingService.sayMessage("王");
    }

}
