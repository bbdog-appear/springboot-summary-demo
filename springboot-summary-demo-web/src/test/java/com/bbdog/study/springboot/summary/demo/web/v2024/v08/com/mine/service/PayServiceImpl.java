package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.mine.service;

import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.Component;
import lombok.extern.slf4j.Slf4j;

@Component("payService")
@Slf4j
public class PayServiceImpl implements PayService {

    @Override
    public String testPay(String payNo) {
        log.info("处理支付收单消息,payNo:{}", payNo);
        return "success";
    }

}
