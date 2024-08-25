package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.mine;

import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.mine.service.BillingService;
import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.mine.service.OrderService;
import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.mine.service.UserService;
import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.MineApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        // 获取上下文容器
        MineApplicationContext context = new MineApplicationContext(AppConfig.class);

        // 1.测试获取bean对象
//        testGetBean(context);

        // 2.测试自动注入
        testAutowired(context);
    }

    private static void testGetBean(MineApplicationContext context) {
        // 从容器中获取bean
        UserService userService1 = (UserService) context.getBean("userService");
        UserService userService2 = (UserService) context.getBean("userService");
        BillingService billingService1 = (BillingService) context.getBean("billingService");
        BillingService billingService2 = (BillingService) context.getBean("billingService");
        System.out.println(userService1);
        System.out.println(userService2);
        System.out.println(billingService1);
        System.out.println(billingService2);
    }

    private static void testAutowired(MineApplicationContext context) {
        // 从容器中获取bean，此时UserService中的OrderService属性引用已经注入对象
        UserService userService = (UserService) context.getBean("userService");
        OrderService orderService = userService.userOrderCreate();
        System.out.println(orderService);
    }

}
