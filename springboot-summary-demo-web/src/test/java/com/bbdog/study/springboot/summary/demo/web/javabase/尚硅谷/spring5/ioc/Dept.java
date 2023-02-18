package com.bbdog.study.springboot.summary.demo.web.javabase.尚硅谷.spring5.ioc;

import java.util.Date;

public class Dept {

    private Emp emp;
    private Date createDate;

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
