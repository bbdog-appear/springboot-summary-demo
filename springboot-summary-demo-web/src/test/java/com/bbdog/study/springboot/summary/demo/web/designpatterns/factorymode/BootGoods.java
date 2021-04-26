package com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode;

import com.alibaba.fastjson.JSON;
import com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode.models.GoodsModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>
 *      实物商品
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGoods.java Date：2021/4/26 17:34 Version：1.0
 */
@Slf4j
@Component
public class BootGoods implements BootInterface<GoodsModel, String>{

    @Override
    public void sendReward(GoodsModel data, String message) {
        String orderId = data.getOrderId();
        log.info("模拟发放一个实物商品,订单号：{},数据GoodsModel：{},日志号为：{}", orderId, JSON.toJSONString(data), message);
    }

    @Override
    public GoodsModel createData() {
        return new GoodsModel();
    }

    @Override
    public String createMessage() {
        return "实物商品发放日志号";
    }

    @Override
    public Class<GoodsModel> getClassObject() {
        return GoodsModel.class;
    }

}
