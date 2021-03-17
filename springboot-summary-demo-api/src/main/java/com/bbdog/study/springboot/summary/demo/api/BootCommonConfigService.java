package com.bbdog.study.springboot.summary.demo.api;

import com.bbdog.study.springboot.summary.demo.api.models.BootCommonConfigReqDTO;
import com.bbdog.study.springboot.summary.demo.api.models.BootCommonConfigResDTO;
import com.bbdog.study.springboot.summary.demo.api.result.Result;

/**
 * <p>
 *      boot通用配置Service
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCommonConfigService.java Date：2021/3/17 16:09 Version：1.0
 */
public interface BootCommonConfigService {

    /**
     * 同步和查询通用配置信息
     *
     * @param traceLogId 请求日志id
     * @param bootCommonConfigReqDTO 请求
     * @return 结果
     */
    Result<BootCommonConfigResDTO> synchronousDataAndQuery(String traceLogId, BootCommonConfigReqDTO bootCommonConfigReqDTO);

}
