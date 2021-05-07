package com.bbdog.study.springboot.summary.demo.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 *      日志注解
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootLog.java Date：2021/5/6 19:57 Version：1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BootLog {

    String value() default "";

}
