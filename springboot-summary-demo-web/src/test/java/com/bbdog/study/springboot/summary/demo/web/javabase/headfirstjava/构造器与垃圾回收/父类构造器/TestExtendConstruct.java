package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.构造器与垃圾回收.父类构造器;

/**
 * <p>
 *      1、子类继承父类，父类是抽象类时，抽象类虽然有构造函数，但不可以new出来。
 *      2、当new子类时，会调用子类的构造函数，子类构造函数里会默认调用父类的无惨构造函数。也就是说虽然抽象类不能new出来，但是它的构造函数可以被调用。
 *      3、当抽象类中自定义有参构造函数时，子类的构造函数里必须调父类的有参构造函数，否则会编译报错。
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestExtendConstruct.java Date：2022/1/13 10:08 Version：1.0
 */
public class TestExtendConstruct {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.run();
//        Animal animal = new Animal();
    }

}
