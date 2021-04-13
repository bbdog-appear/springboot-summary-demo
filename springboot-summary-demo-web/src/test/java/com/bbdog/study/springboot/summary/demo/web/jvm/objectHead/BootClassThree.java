package com.bbdog.study.springboot.summary.demo.web.jvm.objectHead;

import lombok.Data;

/**
 * <p>
 *      类3
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootClassThree.java Date：2021/4/13 10:36 Version：1.0
 */
@Data
public class BootClassThree {

    private String attributeOne;

    public void classThreeMethod(){
        // 事情1
        attributeOne = "你好,classThreeMethod";
        System.out.println(attributeOne);
    }

}
