package com.bbdog.study.springboot.summary.demo.web;

import com.bbdog.study.springboot.summary.demo.api.BootGoodsEventService;
import com.bbdog.study.springboot.summary.demo.api.models.BootCommonConfigResDTO;
import com.bbdog.study.springboot.summary.demo.api.models.BootGoodsEventReqDTO;
import com.bbdog.study.springboot.summary.demo.api.models.BootGoodsStockDTO;
import com.bbdog.study.springboot.summary.demo.api.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * <p>
 *      boot商品事件测试类
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestBootCommonPublishGoods.java Date：2021/3/23 18:12 Version：1.0
 */
@Slf4j
public class TestBootCommonPublishGoods extends SpringbootSummaryDemoWebApplicationTests{

    private static final String traceLogId = UUID.randomUUID().toString();

    @Autowired
    private BootGoodsEventService bootGoodsEventService;

    /**
     * 用Junit测试spring监听器：先启动项目，然后再Junit测试，触发发布事件，但是监听那里并没有执行。
     * 所以Junit不能测试spring监听器，需要启动项目，用controller层去测试，再试试。
     */
    @Test
    public void testRedisAutoConfiguration() {
        BootGoodsEventReqDTO bootGoodsEventReqDTO = new BootGoodsEventReqDTO();
        bootGoodsEventReqDTO.setCommonKey("10003");
        BootGoodsStockDTO bootGoodsStockDTO = new BootGoodsStockDTO();
        bootGoodsStockDTO.setGoodsCode("10003");
        bootGoodsStockDTO.setGoodsName("果粒橙");
        bootGoodsStockDTO.setGoodsPrice(3);
        bootGoodsStockDTO.setGoodsTotalNum(100);
        bootGoodsStockDTO.setGoodsRemainNum(75);
        bootGoodsEventReqDTO.setBootGoodsStockDTO(bootGoodsStockDTO);
        Result<BootCommonConfigResDTO> result = bootGoodsEventService.queryCommonPublishGoods(traceLogId, bootGoodsEventReqDTO);
        log.info("=======结果是：{}", result);
    }

}
