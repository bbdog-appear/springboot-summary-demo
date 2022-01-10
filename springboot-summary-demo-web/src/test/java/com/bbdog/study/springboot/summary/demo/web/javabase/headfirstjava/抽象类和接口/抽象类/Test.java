package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.抽象类和接口.抽象类;

/**
 * <p>
 *      测试继承中变量和方法的执行情况--即多态的特征：是同一个行为具有多种不同表现形态，即动作，也就是方法。所以方法是执行子类重写的
 *      变量不能覆盖，因此父类引用时，则使用的是父类的变量值。
 *      方法能覆盖，因此肯定执行的是子类方法。
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：Test.java Date：2022/1/6 17:27 Version：1.0
 */
public class Test {

    public static void main(String[] args) {
        Animal wolf = new Wolf();
        String name = wolf.name;
        System.out.println(name);
        wolf.run();
        String code = wolf.getCode();
        System.out.println(code);
    }

}
