package com.bbdog.study.springboot.summary.demo.web.sourceTest.generic;

import lombok.Data;

/**
 * <p>
 *      源码的相关测试
 *      1、测试java泛型
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGeneric.java Date：2021/3/31 15:56 Version：1.0
 */
@Data
public class BootGeneric<T> {

    private T data;

}
