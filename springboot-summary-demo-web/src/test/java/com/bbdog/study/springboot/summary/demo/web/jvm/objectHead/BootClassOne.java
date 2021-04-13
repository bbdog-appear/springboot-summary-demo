package com.bbdog.study.springboot.summary.demo.web.jvm.objectHead;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *      类1
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootClassOne.java Date：2021/4/13 10:35 Version：1.0
 */
@Data
public class BootClassOne {

    private String attributeOne;
    private BootClassTwo bootClassTwo = new BootClassTwo();

    public void classOneMethod(){
        // 事情1
        attributeOne = "你好,classOneMethod";
        System.out.println(attributeOne);

        // 事情2
        bootClassTwo = new BootClassTwo();
        bootClassTwo.classTwoMethod();

        // 事情3
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);
    }

}
