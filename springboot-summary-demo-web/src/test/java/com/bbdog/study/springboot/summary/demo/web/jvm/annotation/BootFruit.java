package com.bbdog.study.springboot.summary.demo.web.jvm.annotation;

import java.lang.annotation.*;

/**
 * <p>
 *      自定义注解
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootFruit.java Date：2021/4/30 9:25 Version：1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BootFruit {

    String value() default "";

}
