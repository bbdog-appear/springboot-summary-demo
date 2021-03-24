package com.bbdog.study.springboot.summary.demo.service;

import com.bbdog.study.springboot.summary.demo.api.BootGoodsEventService;
import com.bbdog.study.springboot.summary.demo.api.models.BootCommonConfigResDTO;
import com.bbdog.study.springboot.summary.demo.api.models.BootGoodsEventReqDTO;
import com.bbdog.study.springboot.summary.demo.api.result.Result;
import com.bbdog.study.springboot.summary.demo.biz.QueryCommonPublishGoodsBiz;
import com.bbdog.study.springboot.summary.demo.common.constants.LogTraceConstant;
import com.bbdog.study.springboot.summary.demo.common.exceptions.BizException;
import com.bbdog.study.springboot.summary.demo.manager.models.BootCommonConfigBO;
import com.bbdog.study.springboot.summary.demo.manager.models.BootCommonConfigReqBO;
import com.bbdog.study.springboot.summary.demo.manager.models.BootGoodsEventReqBO;
import com.bbdog.study.springboot.summary.demo.service.convert.BootCommonConfigConvert;
import com.bbdog.study.springboot.summary.demo.service.convert.BootGoodsEventConvert;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *      boot商品事件ServiceImpl
 *      todo 2021年3月22日19:47:17 这里可以使用aop的方式添加公共的日志和抓异常的代码
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGoodsEventServiceImpl.java Date：2021/3/22 19:44 Version：1.0
 */
@Service
@Slf4j
public class BootGoodsEventServiceImpl implements BootGoodsEventService {

    @Autowired
    private QueryCommonPublishGoodsBiz queryCommonPublishGoodsBiz;

    @Override
    public Result<BootCommonConfigResDTO> queryCommonPublishGoods(String traceLogId, BootGoodsEventReqDTO bootGoodsEventReqDTO) {
        try {
            ThreadContext.put(LogTraceConstant.TRACE_LOG_ID, traceLogId);
            log.info("查询通用配置信息并发布商品库存信息接口开始，类名：{}，方法名：queryCommonPublishGoods，参数：{}", log.getName(), bootGoodsEventReqDTO);

            // 参数转换
            BootGoodsEventReqBO bootGoodsEventReqBO = BootGoodsEventConvert.bootGoodsEventReqDtoToBo(bootGoodsEventReqDTO);

            // 主逻辑
            BootCommonConfigBO bootCommonConfigBO = queryCommonPublishGoodsBiz.queryCommonPublishGoods(bootGoodsEventReqBO);

            log.info("查询通用配置信息并发布商品库存信息接口结束，类名：{}，方法名：queryCommonPublishGoods，结果：{}", log.getName(), bootCommonConfigBO);
            // 封装结果
            return Result.buildSuccess(BootCommonConfigConvert.bootCommonConfigResBoToDO(bootCommonConfigBO));
        } catch (BizException e) {
            log.error("查询通用配置信息并发布商品库存信息业务异常", e);
            return Result.buildFail(e.getCode(), e.getMessage());
        } catch (Exception e) {
            log.error("查询通用配置信息并发布商品库存信息系统异常", e);
            return Result.buildFail(e.getMessage(), "系统繁忙，请稍后再试");
        }
    }

}
