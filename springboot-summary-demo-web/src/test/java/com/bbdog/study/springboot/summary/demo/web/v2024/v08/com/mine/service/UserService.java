package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.mine.service;

import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.Autowired;
import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.BeanNameAware;
import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.Component;

@Component("userService")
public class UserService implements BeanNameAware {

    @Autowired
    private OrderService orderService;
    private String beanName;

    public OrderService userOrderCreate() {
        System.out.println("UserService.userOrderCreate,orderService:" + orderService + ",beanName:" + beanName);
        return orderService;
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

}
