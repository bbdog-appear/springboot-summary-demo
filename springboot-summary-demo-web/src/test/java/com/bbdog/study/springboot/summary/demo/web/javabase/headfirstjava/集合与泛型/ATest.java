package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.集合与泛型;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：ATest.java Date：2022/11/22 17:53 Version：1.0
 */
public class ATest {

    public static void main(String[] args) {
        TestMyComparable t1 = new TestMyComparable();
        TestMyComparable t2 = new TestMyComparable();
        System.out.println(t1.hashCode() + "，" + t2.hashCode());
    }

}
