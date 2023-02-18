package com.bbdog.study.springboot.summary.demo.web.javabase.尚硅谷.spring5.ioc;

import java.util.Date;

public class Emp {

    private Dept dept;
    private Date entryDate;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}
