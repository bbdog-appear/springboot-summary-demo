package com.bbdog.study.springboot.summary.demo.web.javabase.尚硅谷.spring5.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class TestGetBean {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 这里是从工厂里获取对象，不是通过new的方式，其中肯定运用反射机制。看下源码
        User user = context.getBean("user", User.class);

    }

}
