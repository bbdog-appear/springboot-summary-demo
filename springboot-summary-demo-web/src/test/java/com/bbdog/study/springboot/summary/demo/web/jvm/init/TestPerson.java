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

    /**
     * 第一次new TestPerson()，会加载这个对象。第二次new TestPerson()，就不会再加载一次了，因为是static修饰，只会加载一次。
     */
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
