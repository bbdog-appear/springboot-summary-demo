package com.bbdog.study.springboot.summary.demo.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>
 *      web层启动项
 *      注意：除了@SpringBootApplication，需要另外加的注解
 *      1、需要在主Application中加入@ComponentScan扫包注解，因为该项目是多module的，所以需要另外指定一下需要扫描的包路径。
 *      2、@MapperScan注解的作用是mybatis执行jdbc时扫的mapper类，执行sql语句，该注解不加也不会报错，原因暂时未知。会不会和
 *      ComponentScan扫描有关系
 * </p>
 *
 * @author cheng.wang
 * @version Id：SpringbootSummaryDemoWebApplication.java Date：2021/3/12 17:00 Version：1.0
 */
@MapperScan("com.bbdog.study.springboot.summary.demo.dal.mapper")
@ComponentScan("com.bbdog.study.springboot.summary.demo")
@SpringBootApplication
public class SpringbootSummaryDemoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSummaryDemoWebApplication.class, args);
    }

}
