package com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode.models;

import lombok.Data;

/**
 * <p>
 *      优惠券
 * </p>
 *
 * @author cheng.wang
 * @version Id：CouponModel.java Date：2021/4/26 17:37 Version：1.0
 */
@Data
public class CouponModel {

    /**
     * 用户id
     */
    private String uId;
    /**
     * 券号
     */
    private String couponNumber;
    /**
     * 防重
     */
    private String uuid;

}
