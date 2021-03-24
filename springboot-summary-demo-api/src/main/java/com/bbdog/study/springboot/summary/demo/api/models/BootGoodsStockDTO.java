package com.bbdog.study.springboot.summary.demo.api.models;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *      商品库存请求DTO
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGoodsStockDTO.java Date：2021/3/22 19:36 Version：1.0
 */
@Data
@ToString
public class BootGoodsStockDTO implements Serializable {

    private static final long serialVersionUID = 2561534185162747154L;

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
