package com.bbdog.study.springboot.summary.demo.web.controller;

import com.bbdog.study.springboot.summary.demo.api.BootCommonConfigService;
import com.bbdog.study.springboot.summary.demo.common.annotation.BootLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @BootLog("健康检查页面")
    @GetMapping("/monitorWeb")
    public String bootMonitorWeb(HttpServletRequest request){
        return "WEB_OK";
    }

}
