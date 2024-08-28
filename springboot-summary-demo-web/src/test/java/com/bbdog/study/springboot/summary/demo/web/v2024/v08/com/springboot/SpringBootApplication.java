package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.springboot;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ComponentScan
public @interface SpringBootApplication {
}
