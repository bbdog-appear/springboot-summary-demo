package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.构造器与垃圾回收.创建对象;

/**
 * <p>
 *      其中new Duck();看起来像是在调用Duck()方法。其实并不是，是在调用Duck的构造函数。
 *      1、构造函数会在初始一个对象的时候执行。
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestCreateObject.java Date：2022/1/12 19:16 Version：1.0
 */
public class TestCreateObject {

    public static void main(String[] args) {
        Duck d = new Duck();
    }

}
