package com.bbdog.study.springboot.summary.demo.web.javabase.尚硅谷.spring5.spring事务;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TxA {
    @Autowired
    private TxB txB;

    @Transactional
    public void a() {
        // 更新一条数据，使得这条数据的状态变成1

        // 调用B类的b方法，b方法也有个事务
        txB.b();

        // 更新另一条数据，使得这条数据的状态变成0
    }


}
