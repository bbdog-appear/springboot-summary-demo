package com.bbdog.study.springboot.summary.demo.web.jvm.objectHead;

import lombok.Data;

/**
 * <p>
 *      类2
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootClassTwo.java Date：2021/4/13 10:36 Version：1.0
 */
@Data
public class BootClassTwo {

    private String attributeOne;
    private BootClassThree bootClassThree;

    public void classTwoMethod(){
        // 事情1
        attributeOne = "你好,classTwoMethod";
        System.out.println(attributeOne);

        // 事情2
        bootClassThree = new BootClassThree();
        bootClassThree.classThreeMethod();
    }

}
