package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.数字与静态;

/**
 * <p>
 *      测试类加载
 *      1、猜测：main方法为入口，当程序运行时，会进行类加载，因为TestStaticLoad继承StaticSuper，所以先加载StaticSuper的静态代码块，再
 *        加载TestStaticLoad的静态代码块，然后执行main方法。然后执行new TestStaticLoad操作，初始化时会先初始化父类的构造方法，再初始化
 *        自己的构造方法。
 *      2、执行后的顺序：
 *          super static block
 *          static block 3
 *          in main
 *          super constructor
 *          constructor
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestStaticLoad.java Date：2022/2/11 16:37 Version：1.0
 */
public class TestStaticLoad extends StaticSuper{

    static int rand;

    // ②
    static {
        rand = (int) (Math.random() * 6);
        System.out.println("static block " + rand);
    }

    // ⑤
    public TestStaticLoad() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        // ③
        System.out.println("in main");
        TestStaticLoad ts = new TestStaticLoad();
    }

}

class StaticSuper{

    // ①
    static {
        System.out.println("super static block");
    }

    // ④
    public StaticSuper() {
        System.out.println("super constructor");
    }

}
