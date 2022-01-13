package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.构造器与垃圾回收.父类构造器;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：Animal.java Date：2022/1/13 10:06 Version：1.0
 */
public abstract class Animal {

    public Animal(String str) {
        System.out.println("父类构造函数~~");
    }

    public abstract void run();

}
