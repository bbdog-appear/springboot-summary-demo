package com.bbdog.study.springboot.summary.demo.web.javabase;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestJavaBase.java Date：2021/12/9 15:35 Version：1.0
 */
public class TestJavaBase {

    public static void main(String[] args) {
        goRun1();
    }

    public static void goRun() {
        int x = 24;
//        byte b = x;
        byte b = 24;
        int c = b;
//        boolean boo = x;
        Dog[] dogs = new Dog[5];
        dogs[0] = new Dog();
        int len = dogs.length;
        System.out.println(dogs);
    }

    private static void goRun3(){
        int i = 42;
        int i1 = goRun4(i);
        System.out.println(i1);
    }

    private static int goRun4(int arg){
        arg = arg * 2;
        return arg;
    }

    private static void goRun1(){
        List<Dog> list = new ArrayList<>();
        Dog dog = new Dog();
        dog.setName("小狗1");
        list.add(dog);
        String str = "方法前";
        goRun2(dog, list, str);
        System.out.println(dog + "\n" + list + "\n" + str);
    }

    /**
     * 注意：java是通过值传递，不是引用传递！
     * 比如该方法入参dog，这其实是局部变量，即在方法体内声明Dog dog一样，所以当这个入参的dog = new Dog()时，其实是
     * 新的引用指向新的对象，并不会改变调用方的引用的指向，原来的引用还是指向原来的对象。
     *
     * @param dog 入参1
     * @param list 入参2
     */
    private static void goRun2(Dog dog, List<Dog> list, String str){
        dog = new Dog();
        dog.setName("小狗2");
        list = new ArrayList<>();
        list.add(dog);
        str = "方法里";
        System.out.println(dog + "\n" + list + "\n" + str);
    }

}
