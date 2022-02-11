package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.数字与静态;

/**
 * <p>
 *      测试自动装箱与自动拆箱
 *      1、go方法中可以编译通过。但是运行报错：空指针异常。因为i默认值是null，所以自动拆箱时可能会报空指针问题。
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestBox.java Date：2022/2/9 16:42 Version：1.0
 */
public class TestBox {

    private Integer i;
    private int j;

    public static void main(String[] args) {
        TestBox t = new TestBox();
        t.go();
    }

    public void go() {
        j = i;
        System.out.println(j);
        System.out.println(i);
    }

}
