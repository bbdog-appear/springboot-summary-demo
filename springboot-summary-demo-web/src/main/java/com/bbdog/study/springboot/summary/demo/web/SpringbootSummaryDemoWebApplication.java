package com.bbdog.study.springboot.summary.demo.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *      web层启动项
 * </p>
 *
 * @author cheng.wang
 * @version Id：SpringbootSummaryDemoWebApplication.java Date：2021/3/12 17:00 Version：1.0
 */
@SpringBootApplication
@MapperScan("com.bbdog.study.springboot.summary.demo.dal.mapper")
public class SpringbootSummaryDemoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSummaryDemoWebApplication.class, args);
    }

}
