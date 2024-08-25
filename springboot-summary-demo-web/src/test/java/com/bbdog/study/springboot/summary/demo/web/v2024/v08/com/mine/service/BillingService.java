package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.mine.service;

import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.Component;
import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.Scope;

@Component("billingService")
@Scope("prototype")
public class BillingService {

    public void charging() {
        System.out.println("计算费用");
    }

}
