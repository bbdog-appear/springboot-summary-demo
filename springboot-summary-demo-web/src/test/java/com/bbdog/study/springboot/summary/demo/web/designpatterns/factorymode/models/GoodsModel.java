package com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode.models;

import lombok.Data;

/**
 * <p>
 *      实物商品
 * </p>
 *
 * @author cheng.wang
 * @version Id：GoodsModel.java Date：2021/4/26 17:37 Version：1.0
 */
@Data
public class GoodsModel {

    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户手机
     */
    private String userPhone;
    /**
     * 商品SKU
     */
    private String sku;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 收货人姓名
     */
    private String consigneeUserName;
    /**
     * 收货人手机
     */
    private String consigneeUserPhone;
    /**
     * 收获人地址
     */
    private String consigneeUserAddress;

}
