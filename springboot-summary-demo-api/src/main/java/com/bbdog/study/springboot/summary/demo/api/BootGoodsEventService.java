package com.bbdog.study.springboot.summary.demo.api;

import com.bbdog.study.springboot.summary.demo.api.models.BootCommonConfigResDTO;
import com.bbdog.study.springboot.summary.demo.api.models.BootGoodsEventReqDTO;
import com.bbdog.study.springboot.summary.demo.api.result.Result;

/**
 * <p>
 *      boot商品事件Service
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGoodsEventService.java Date：2021/3/22 19:24 Version：1.0
 */
public interface BootGoodsEventService {

    /**
     * 查询通用配置信息并发布商品库存信息
     *
     * @param traceLogId 日志id
     * @param bootGoodsEventReqDTO 请求DTO
     * @return 响应DTO
     */
    Result<BootCommonConfigResDTO> queryCommonPublishGoods(String traceLogId, BootGoodsEventReqDTO bootGoodsEventReqDTO);

}
