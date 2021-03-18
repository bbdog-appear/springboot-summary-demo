package com.bbdog.study.springboot.summary.demo.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 *      启动测试类
 *      注意：除了@SpringBootTest注解，还需要加@RunWith注解，下面第2点做说明。
 *      1、其中需要在主Application类中加扫包注解，在这里加扫包注解无效，即@ComponentScan("com.bbdog.study.springboot.summary.demo")
 *      点一下这个包，会定位到web模块中test包下的com.bbdog.study.springboot.summary.demo路径，不会扫所有module中的这个路径。
 *      2、@RunWith(SpringRunner.class)注解在测试的时候，是需要加的，作用：将@Service类似注解的类实例化到spring容器中，自动注入
 *      Autowired才能获取到bean，如果没有这个注解，则容器中没有该bean，获取的就为null。
 * </p>
 *
 * @author cheng.wang
 * @version Id：SpringbootSummaryDemoWebApplicationTests.java Date：2021/3/12 17:00 Version：1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootSummaryDemoWebApplicationTests {

    @Test
    public void contextLoads() {
    }

}
