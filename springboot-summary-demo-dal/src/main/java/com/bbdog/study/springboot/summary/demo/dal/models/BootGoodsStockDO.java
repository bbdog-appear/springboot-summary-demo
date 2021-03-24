package com.bbdog.study.springboot.summary.demo.dal.models;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 *      boot商品库存DO
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGoodsStockDO.java Date：2021/3/23 17:46 Version：1.0
 */
@Data
@ToString
public class BootGoodsStockDO {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 商品码
     */
    private String goodsCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品单价
     */
    private Integer goodsPrice;

    /**
     * 商品总量
     */
    private Integer goodsTotalNum;

    /**
     * 商品余量
     */
    private Integer goodsRemainNum;

}
