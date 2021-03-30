package com.bbdog.study.springboot.summary.demo.web.controller;

import com.bbdog.study.springboot.summary.demo.api.BootGoodsEventService;
import com.bbdog.study.springboot.summary.demo.api.models.BootCommonConfigResDTO;
import com.bbdog.study.springboot.summary.demo.api.models.BootGoodsEventReqDTO;
import com.bbdog.study.springboot.summary.demo.api.models.BootGoodsStockDTO;
import com.bbdog.study.springboot.summary.demo.api.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootPublishGoodsController.java Date：2021/3/23 19:27 Version：1.0
 */
@Slf4j
@RestController
@RequestMapping("/publishGoods")
public class BootPublishGoodsController {

    private static final String TRACE_LOG_ID = UUID.randomUUID().toString();

    @Autowired
    private BootGoodsEventService bootGoodsEventService;

    /**
     * 查询通用信息并发布商品事件
     *
     * @return 返回结果
     */
    @GetMapping("/queryCommonPublishGoods")
    public Object queryCommonPublishGoods(){
        BootGoodsEventReqDTO bootGoodsEventReqDTO = new BootGoodsEventReqDTO();
        bootGoodsEventReqDTO.setCommonKey("10003");
        BootGoodsStockDTO bootGoodsStockDTO = new BootGoodsStockDTO();
        bootGoodsStockDTO.setGoodsCode("10003");
        bootGoodsStockDTO.setGoodsName("果粒橙");
        bootGoodsStockDTO.setGoodsPrice(3);
        bootGoodsStockDTO.setGoodsTotalNum(100);
        bootGoodsStockDTO.setGoodsRemainNum(75);
        bootGoodsEventReqDTO.setBootGoodsStockDTO(bootGoodsStockDTO);
        Result<BootCommonConfigResDTO> result = bootGoodsEventService.queryCommonPublishGoods(TRACE_LOG_ID, bootGoodsEventReqDTO);
        return result.getData();
    }

}
