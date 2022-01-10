package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.抽象类和接口.java8接口;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：IJava8New2.java Date：2022/1/6 16:30 Version：1.0
 */
public interface IJava8New2 {

    default void run() {
        System.out.println("接口中默认的跑~~");
    }

    static void barking() {
        System.out.println("小狗在叫~~");
    }

}
