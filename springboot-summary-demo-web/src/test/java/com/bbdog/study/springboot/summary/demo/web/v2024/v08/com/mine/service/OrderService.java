package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.mine.service;

import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.Component;
import lombok.extern.slf4j.Slf4j;

@Component("orderService")
@Slf4j
public class OrderService {

    public void createOrder() {
        log.info("创建订单");
    }

}
