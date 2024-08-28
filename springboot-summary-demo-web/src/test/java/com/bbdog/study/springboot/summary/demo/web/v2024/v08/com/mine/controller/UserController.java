package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.mine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/test")
    public String test() {
        return "mineTest";
    }

}
