package com.bbdog.study.springboot.summary.demo.web.jvm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * <p>
 *      自定义注解
 *      ElementType.TYPE:可以用于注解类、接口(包括注解类型)或enum声明
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootTable.java Date：2021/4/29 16:09 Version：1.0
 */
@Target(ElementType.TYPE)
public @interface BootTable {

    /**
     * 数据表名称注解，默认值为类名称
     * @return 表名称
     */
    String tableName() default "className";

}
