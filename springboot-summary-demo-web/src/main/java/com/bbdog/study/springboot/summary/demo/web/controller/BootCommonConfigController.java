package com.bbdog.study.springboot.summary.demo.web.controller;

import com.bbdog.study.springboot.summary.demo.api.BootCommonConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *      boot通用配置Controller
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCommonConfigController.java Date：2021/3/18 16:02 Version：1.0
 */
@Slf4j
@RestController
@RequestMapping("/commonConfig")
public class BootCommonConfigController {

    @Autowired
    private BootCommonConfigService bootCommonConfigService;

    @RequestMapping(value = "/synchronousDataAndQuery", method = RequestMethod.GET)
    public String synchronousDataAndQuery(){
        log.info("controller开始");
        bootCommonConfigService.synchronousDataAndQuery(null, null);
        return "controller success";
    }

}
