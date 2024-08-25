package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.mine.service;

import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.Component;
import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.Scope;

@Component("userService")
@Scope("prototype")
public class UserService {

    public void register() {
        System.out.println("UserService.register");
    }

}
