package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.代理相关;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：目标类.java Date：2023/2/13 16:34 Version：1.0
 */
public class Target implements ITarget {

    @Override
    public void f1() {
        System.out.println("目标类的方法");
    }

}
