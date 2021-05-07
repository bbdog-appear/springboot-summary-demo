package com.bbdog.study.springboot.summary.demo.web.jvm.annotation;

import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.*;

/**
 * <p>
 *      自定义注解
 *      ElementType.FIELD:仅可用于注解类的成员变量
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootNoDbColumn.java Date：2021/4/29 16:13 Version：1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface BootNoDbColumn {

    String name() default "fieldName";

    String setFuncName() default "setField";

    String getFuncName() default "getField";

    boolean defaultDbValue() default false;

    enum FontColor{
        BLUE,
        RED,
        GREEN
    }

    FontColor fontColor() default FontColor.GREEN;

    int length();

}
