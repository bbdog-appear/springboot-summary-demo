package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.构造器与垃圾回收.创建对象;

/**
 * <p>
 *      构造函数public Duck()
 *      1、它会在对象能够被赋值给引用之前就执行。即在任何人取的对象的遥控器前，对象有机会对构造过程给予借助。在构造函数中，虽然没有做出
 *        有意义的事情，但还是有展示出事件的顺序。构造函数让你可以再构造过程的步骤中参一脚。
 * </p>
 *
 * @author cheng.wang
 * @version Id：Duck.java Date：2022/1/12 19:07 Version：1.0
 */
public class Duck {

    public Duck() {
        System.out.println("Quack");
    }

}
