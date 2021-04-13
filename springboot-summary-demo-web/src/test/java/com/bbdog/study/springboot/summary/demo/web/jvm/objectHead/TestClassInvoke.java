package com.bbdog.study.springboot.summary.demo.web.jvm.objectHead;

/**
 * <p>
 *      测试类中方法调用，以及内存的分配
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestClassInvoke.java Date：2021/4/13 10:35 Version：1.0
 */
public class TestClassInvoke {

    public static void main(String[] args) {
        BootClassOne bootClassOne = new BootClassOne();
        bootClassOne.classOneMethod();
    }

}
