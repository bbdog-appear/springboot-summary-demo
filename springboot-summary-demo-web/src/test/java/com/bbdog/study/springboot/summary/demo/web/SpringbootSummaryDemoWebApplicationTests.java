package com.bbdog.study.springboot.summary.demo.web;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.bbdog.study.springboot.summary.demo.*")
class SpringbootSummaryDemoWebApplicationTests {

    @Test
    void contextLoads() {
    }

}
