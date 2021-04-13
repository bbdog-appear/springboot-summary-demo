package com.bbdog.study.springboot.summary.demo.web.jvm.init;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestPerson.java Date：2021/4/8 9:22 Version：1.0
 */
public class TestPerson {

    static {
        System.out.println("测试静态代码块");
    }

    private static TestHair testHair = new TestHair();

    private TestNose testNose = new TestNose();

    public TestPerson(){
        System.out.println("测试人类的构造函数");
    }

    public static void testStatic(){
        System.out.println("测试静态方法");
    }

    public static TestHair getTestHair(){
        testHair = new TestHair();
        return testHair;
    }

}
