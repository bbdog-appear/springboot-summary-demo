package com.bbdog.study.springboot.summary.demo.biz;

import com.bbdog.study.springboot.summary.demo.common.util.SpringUtil;
import com.bbdog.study.springboot.summary.demo.core.BootCommonConfigCore;
import com.bbdog.study.springboot.summary.demo.manager.event.BootGoodsAddEvent;
import com.bbdog.study.springboot.summary.demo.manager.models.BootCommonConfigBO;
import com.bbdog.study.springboot.summary.demo.manager.models.BootGoodsEventReqBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 *      查询通用配置信息并发布商品库存信息Biz
 * </p>
 *
 * @author cheng.wang
 * @version Id：QueryCommonPublishGoodsBiz.java Date：2021/3/22 20:00 Version：1.0
 */
@Component
@Slf4j
public class QueryCommonPublishGoodsBiz {

    @Autowired
    private BootCommonConfigCore bootCommonConfigCore;

    @Autowired
    private SpringUtil springUtil;

    /**
     * 查询通用配置信息并发布商品库存信息
     *
     * @param bootGoodsEventReqBO 请求BO
     * @return 响应BO
     */
    public BootCommonConfigBO queryCommonPublishGoods(BootGoodsEventReqBO bootGoodsEventReqBO){
        // 根据commonKey查询通用配置信息
        BootCommonConfigBO bootCommonConfigBO = bootCommonConfigCore.queryByCommonKey(bootGoodsEventReqBO.getCommonKey());

        // 发布一个事件(异步操作，和队列比较相似，将数据发出去，另外一个监听去接收信息，处理业务逻辑)
        BootGoodsAddEvent bootGoodsAddEvent = new BootGoodsAddEvent(bootGoodsEventReqBO.getBootGoodsStockBO());
        springUtil.publishEvent(bootGoodsAddEvent);

        // 模拟下一个业务
        BootCommonConfigBO bootCommonConfigBo2 = bootCommonConfigCore.queryByCommonKey(bootGoodsEventReqBO.getCommonKey());
        log.info("查询到的通用配置信息为：{}", bootCommonConfigBo2);
        return bootCommonConfigBO;
    }

}
