package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.抽象类和接口.java8接口;

/**
 * <p>
 *      java8及之后接口新增的方法
 * </p>
 *
 * @author cheng.wang
 * @version Id：IJava8New.java Date：2022/1/6 16:26 Version：1.0
 */
public interface IJava8New {

    default void run() {
        System.out.println("接口中默认的跑~~");
    }

    default void run2() {
        System.out.println("接口中默认的跑2~~");
    }

    static void barking() {
        System.out.println("小狗在叫~~");
    }

}
