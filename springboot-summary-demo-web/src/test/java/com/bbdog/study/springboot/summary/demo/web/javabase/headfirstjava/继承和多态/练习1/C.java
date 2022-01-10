package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.继承和多态.练习1;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：C.java Date：2022/1/7 14:05 Version：1.0
 */
public class C extends B{
    @Override
    void m3() {
        System.out.println(" C`s m3, " + (iVar + 6));
    }
}
