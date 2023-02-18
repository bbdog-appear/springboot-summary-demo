package com.bbdog.study.springboot.summary.demo.web.javabase.尚硅谷.spring5.spring事务;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TxB {

    @Transactional
    public void b() {
        // 更新一条数据，使得这条数据的状态变成1

        // 更新另一条数据，使得这条数据的状态变成0
    }

}
