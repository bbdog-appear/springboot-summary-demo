package com.bbdog.study.springboot.summary.demo.service;

import com.bbdog.study.springboot.summary.demo.api.BootCommonConfigService;
import com.bbdog.study.springboot.summary.demo.api.models.BootCommonConfigReqDTO;
import com.bbdog.study.springboot.summary.demo.api.models.BootCommonConfigResDTO;
import com.bbdog.study.springboot.summary.demo.api.result.Result;
import com.bbdog.study.springboot.summary.demo.biz.BootCommonConfigBiz;
import com.bbdog.study.springboot.summary.demo.common.constants.LogTraceConstant;
import com.bbdog.study.springboot.summary.demo.common.exceptions.BizException;
import com.bbdog.study.springboot.summary.demo.manager.models.BootCommonConfigBO;
import com.bbdog.study.springboot.summary.demo.manager.models.BootCommonConfigReqBO;
import com.bbdog.study.springboot.summary.demo.service.convert.BootCommonConfigConvert;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *      boot通用配置ServiceImpl
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCommonConfigServiceImpl.java Date：2021/3/17 16:08 Version：1.0
 */
@Slf4j
@Service
public class BootCommonConfigServiceImpl implements BootCommonConfigService {

    @Autowired
    private BootCommonConfigBiz bootCommonConfigBiz;

    @Override
    public Result<BootCommonConfigResDTO> synchronousDataAndQuery(String traceLogId,
                                                                  BootCommonConfigReqDTO bootCommonConfigReqDTO) {
        try {
            ThreadContext.put(LogTraceConstant.TRACE_LOG_ID, traceLogId);
            log.info("同步和查询通用配置接口开始，类名：{}，方法名：synchronousDataAndQuery，参数：{}", log.getName(), bootCommonConfigReqDTO);

            // 参数转换
            BootCommonConfigReqBO bootCommonConfigReqBO = BootCommonConfigConvert.bootCommonConfigReqDtoToBO(bootCommonConfigReqDTO);

            // 主逻辑
            BootCommonConfigBO bootCommonConfigBO = bootCommonConfigBiz.synchronousDataAndQuery(bootCommonConfigReqBO);

            log.info("同步和查询通用配置接口结束，类名：{}，方法名：synchronousDataAndQuery，结果：{}", log.getName(), bootCommonConfigBO);
            // 封装结果
            return Result.buildSuccess(BootCommonConfigConvert.bootCommonConfigResBoToDO(bootCommonConfigBO));
        } catch (BizException e) {
            log.error("同步和查询通用配置信息业务异常", e);
            return Result.buildFail(e.getCode(), e.getMessage());
        } catch (Exception e) {
            log.error("同步和查询通用配置信息系统异常", e);
            return Result.buildFail(e.getMessage(), "系统繁忙，请稍后再试");
        }
    }

}
