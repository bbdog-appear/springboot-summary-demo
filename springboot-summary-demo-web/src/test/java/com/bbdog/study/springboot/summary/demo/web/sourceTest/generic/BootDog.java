package com.bbdog.study.springboot.summary.demo.web.sourceTest.generic;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootDog.java Date：2021/3/31 18:08 Version：1.0
 */
public class BootDog extends BootAnimal{
    private final Integer legs = 4;

    public Integer countLegs(){
        return legs;
    }

}
