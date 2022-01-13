package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.构造器与垃圾回收.父类构造器;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：Dog.java Date：2022/1/13 10:06 Version：1.0
 */
public class Dog extends Animal{

    public Dog() {
//        super();
        this("二哈");
        System.out.println("狗的无参构造函数");
    }

    public Dog(String name) {
//        super(name);
        System.out.println("狗的有参构造函数");
    }

    @Override
    public void run() {
        System.out.println("狗跑~~");
    }

}
