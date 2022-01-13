package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.构造器与垃圾回收.栈的情境;

/**
 * <p>
 *      栈引用:栈上的对象引用
 *      barf()会声明并创建出对Duck的引用变量d(方法中的局部变量)。对象Duck在堆中
 * </p>
 *
 * @author cheng.wang
 * @version Id：StackRef.java Date：2022/1/12 18:16 Version：1.0
 */
public class StackRef {

    public void fooF() {
        barf();
    }

    public void barf() {
        Duck d = new Duck(24);
    }

}
