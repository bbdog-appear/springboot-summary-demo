package com.bbdog.study.springboot.summary.demo.web.jvm.init;

/**
 * <p>
 *      测试类加载顺序
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestMain.java Date：2021/4/8 9:39 Version：1.0
 */
public class TestMain {

    public static void main(String[] args) {
        // 当获取类的class对象时，该类中无论静态变量、静态代码块等都不会被加载
        Class<TestPerson> classInfo = TestPerson.class;
        System.out.println("测试class对象" + classInfo);

        /* 类的初始化过程：摘自：https://zhuanlan.zhihu.com/p/111491656
            一个类要创建实例需要先加载并初始化该类 -- main方法所在的类需要先加载和初始化
            一个子类要初始化需要先初始化父类
            一个类的初始化就是执行()方法 -- ()方法是自动生成的在字节码中可以找到，
           是由静态类变量显示赋值代码和静态代码块组成，这两个是谁在上面先执行谁，并且只执行一次 */
        // 当该类通过类名.静态方法时，该类加载顺序：静态成员变量==静态代码块(谁写在前面就先加载谁)-->静态方法。注意只会加载静态的属性或方法
//        TestPerson.testStatic();

        /* 实例的初始化过程：摘自：https://zhuanlan.zhihu.com/p/111491656
            就是执行()方法 -- () 方法可能有多个重载，有几个构造方法就有几个() --
            () 方法包括非静态类实例变量显示赋值代码，非静态代码块和对应构造器代码组成，前两个是谁在上面先执行谁，构造器代码最后执行 --
            每次创建实例都要调用对应的()方法，有因为子类的构造器的首行是super()；所以每次都会调用父类的()方法 */
        // 当该类通过new的方式初始化的时候，该类中加载顺序：静态成员变量==静态代码块(谁写在前面就先加载谁)-->非静态成员变量-->构造函数。
        TestPerson testPerson = new TestPerson();
        System.out.println(testPerson);

        // 当该类再new一次获取另一个实例时，该类中加载顺序：非静态成员变量-->构造函数。！！注意一个类的静态的属性或代码块只会被加载一次。
        TestPerson testPerson2 = new TestPerson();
        System.out.println(testPerson2);

        // 静态成员变量在该类中可以改变对象
        TestHair testHair = TestPerson.getTestHair();
        TestHair testHair1 = TestPerson.getTestHair();
        System.out.println(testHair + "\n和" + testHair1);

    }

}
