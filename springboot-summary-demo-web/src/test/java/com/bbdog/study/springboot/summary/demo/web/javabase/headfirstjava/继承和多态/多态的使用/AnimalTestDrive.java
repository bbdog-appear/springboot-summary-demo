package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.继承和多态.多态的使用;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *      测试多态的优缺点
 * </p>
 *
 * @author cheng.wang
 * @version Id：AnimalTestDrive.java Date：2022/1/10 14:32 Version：1.0
 */
public class AnimalTestDrive {

    public static void main(String[] args) {
        MyAnimalList list = new MyAnimalList();
        Dog a = new Dog();
        Cat c = new Cat();
        list.add(a);
        list.add(c);
    }

    /**
     * 测试List中泛型的作用：为了做类型的限制。
     * 多态的劣势：
     * 如果类型是父类，则可以传入子类对象。比如泛型中定义为Object，那么可以存入任何对象。但是get时会编译不通过，
     * 因为编译器无法确认它是Dog还是Cat，只有自己知道，或者用instanceof判断一下。所以需要转义一下。
     * 1、使用Object类型或父类的缺点(需要付出代价)：会让对象看起来失去了真正的本质。
     */
    private static void test() {
        List<Animal> list = new ArrayList<>();
        Dog a = new Dog();
        Cat c = new Cat();
        list.add(a);
        list.add(c);
        Cat cat = (Cat) list.get(1);
        System.out.println(cat);
    }

}
