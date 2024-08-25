package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.mine.service;

import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.Autowired;
import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.BeanNameAware;
import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.Component;
import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.InitializingBean;
import lombok.extern.slf4j.Slf4j;

@Component("userService")
@Slf4j
public class UserService implements BeanNameAware, InitializingBean {

    @Autowired
    private OrderService orderService;
    private String beanName;
    private String remark;

    public OrderService userOrderCreate() {
        log.info("UserService.userOrderCreate,orderService:{},beanName:{},remark:{}", orderService, beanName, remark);
        return orderService;
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 给某个属性赋值，即可以覆盖属性的引用的对象
        log.info("初始化：UserService.afterPropertiesSet");
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
