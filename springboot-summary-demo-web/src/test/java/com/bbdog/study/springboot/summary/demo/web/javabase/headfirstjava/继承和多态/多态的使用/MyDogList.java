package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.继承和多态.多态的使用;

/**
 * <p>
 *      自己创建的Dog专用List(最差劲的一个程序)
 *      如果还要创建一个Cat用的List，那么又要单独创建MyCatList类来处理，这不好。接下来改进-->MyAnimalList。
 * </p>
 *
 * @author cheng.wang
 * @version Id：MyDogList.java Date：2022/1/10 14:17 Version：1.0
 */
public class MyDogList {

    /**
     * 实际上使用的是数组
     */
    private Dog[] dogs = new Dog[5];
    /**
     * 增加新的dog就加1
     */
    private int nextIndex = 0;

    /**
     * 如果没有超出上限就把Dog加进去并列出信息
     *
     * @param d dog对象
     */
    public void add(Dog d) {
        if (nextIndex < dogs.length) {
            dogs[nextIndex] = d;
            System.out.println("Dog added at " + nextIndex);
            nextIndex++;
        }
    }

}
