package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.抽象类和接口.抽象类;

/**
 * <p>
 *      动物类
 * </p>
 *
 * @author cheng.wang
 * @version Id：Animal.java Date：2022/1/6 17:25 Version：1.0
 */
public abstract class Animal {

    public String name = "父类";
    private String code = "私有父类";

    public void run() {
        System.out.println("父类跑");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
