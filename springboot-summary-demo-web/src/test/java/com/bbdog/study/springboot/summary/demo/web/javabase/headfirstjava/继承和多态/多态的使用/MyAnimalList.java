package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.继承和多态.多态的使用;

/**
 * <p>
 *      多态的使用：
 *      创建一个不同的AnimalList类让他处理Animal所有的子类。
 * </p>
 *
 * @author cheng.wang
 * @version Id：MyAnimalList.java Date：2022/1/10 14:24 Version：1.0
 */
public class MyAnimalList {

    /**
     * 这不是在创建Animal对象，只是保存Animal的数组对象
     */
    private Animal[] animals = new Animal[5];
    private int nextIndex = 0;

    public void add(Animal a) {
        if (nextIndex < animals.length) {
            animals[nextIndex] = a;
            System.out.println("Animal added at " + nextIndex);
            nextIndex++;
        }
    }

}
