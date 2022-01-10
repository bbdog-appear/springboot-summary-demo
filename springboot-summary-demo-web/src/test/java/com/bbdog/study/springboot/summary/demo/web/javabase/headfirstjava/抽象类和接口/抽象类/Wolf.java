package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.抽象类和接口.抽象类;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：Wolf.java Date：2022/1/6 17:27 Version：1.0
 */
public class Wolf extends Animal{

    public String name = "狼";
    private String code = "私有狼";

    @Override
    public void run() {
        System.out.println("狼跑");
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }
}
