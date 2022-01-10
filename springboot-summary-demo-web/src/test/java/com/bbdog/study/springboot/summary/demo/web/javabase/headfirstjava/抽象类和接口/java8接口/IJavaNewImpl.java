package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.抽象类和接口.java8接口;

/**
 * <p>
 *      当实现类实现两个接口中都有相同的default方法时，必须要重写该方法。否则实现类无法知道使用哪个接口的方法
 * </p>
 *
 * @author cheng.wang
 * @version Id：IJavaNewImpl.java Date：2022/1/6 16:30 Version：1.0
 */
public class IJavaNewImpl implements IJava8New, IJava8New2 {

    @Override
    public void run() {
        System.out.println("实现类必须重写两个接口相同的default方法");
    }

    public static void main(String[] args) {
        IJavaNewImpl iJavaNew = new IJavaNewImpl();
        // 调用该实现类本身重写的方法
        iJavaNew.run();
        // 调用接口1中默认的方法
        iJavaNew.run2();
        // 实现类不能直接访问接口中的static方法，因为如果两个接口相同方法，那虚拟机不知道调用哪个接口的方法了
//        IJavaNewImpl.barking();
        // 接口中的static方法只能用接口本身调用。
        IJava8New.barking();
        IJava8New2.barking();
    }

}
