package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.继承和多态.练习1;

/**
 * <p>
 *      测试继承和多态
 * </p>
 *
 * @author cheng.wang
 * @version Id：Mixed2.java Date：2022/1/7 14:06 Version：1.0
 */
public class Mixed2 {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        A a2 = new C();
        // 输出：B`s m1, A`s m2, A`s m3,
        b.m1();
        c.m2();
        a.m3();
        // 输出：B`s m1, A`s m2, C`s m3, 13
        c.m1();
        c.m2();
        c.m3();
        // 输出：A`s m1, A`s m2, C`s m3, 13
        a.m1();
        b.m2();
        c.m3();
        // 输出：B`s m1, A`s m2, C`s m3, 13
        a2.m1();
        a2.m2();
        a2.m3();
    }

}
