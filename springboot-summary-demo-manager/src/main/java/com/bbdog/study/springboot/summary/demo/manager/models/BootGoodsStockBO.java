package com.bbdog.study.springboot.summary.demo.manager.models;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 *      商品库存请求BO
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGoodsStockBO.java Date：2021/3/22 19:52 Version：1.0
 */
@Data
@ToString
public class BootGoodsStockBO {

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
