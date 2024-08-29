package com.bbdog.study.springboot.summary.demo.web.v2024.v08.规则引擎.QLExpress;

import org.springframework.stereotype.Component;

@Component
public class BizOrderDAO {

    Result query(OrderQuery query) {
        Result result = new Result();
        result.setId(111);
        return result;
    }

}
