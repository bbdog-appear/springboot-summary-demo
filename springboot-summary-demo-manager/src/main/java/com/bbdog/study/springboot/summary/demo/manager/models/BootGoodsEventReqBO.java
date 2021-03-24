package com.bbdog.study.springboot.summary.demo.manager.models;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 *      查询通用配置并发布商品事件请求BO
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGoodsEventReqBO.java Date：2021/3/22 19:52 Version：1.0
 */
@Data
@ToString
public class BootGoodsEventReqBO {

    /**
     * 通用key
     */
    private String commonKey;

    /**
     * 商品库存信息
     */
    private BootGoodsStockBO bootGoodsStockBO;

}
