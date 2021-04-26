package com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode.enums;

import com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode.BootCard;
import com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode.BootCoupon;
import com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode.BootGoods;

/**
 * <p>
 *      奖励类型枚举
 *      1、定义奖励类型枚举类，目的是根据类型获取业务类的class对象，其中成员变量awardTypeClass由于不知道哪种类型，所以可以用?表示
 *      2、当具体的获取哪个类型，那么这个?就是该类型
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootRewardTypeEnum.java Date：2021/4/26 18:35 Version：1.0
 */
public enum BootRewardTypeEnum {

    /**
     * 优惠券类型
     */
    COUPON_TYPE("coupon", BootCoupon.class),
    /**
     * 实物商品类型
     */
    GOODS_TYPE("goods", BootGoods.class),
    /**
     * 爱奇艺兑换券类型
     */
    CARD_TYPE("card", BootCard.class),
    ;

    private final String code;
    private final Class<?> rewardTypeClass;

    BootRewardTypeEnum(String code, Class<?> rewardTypeClass){
        this.code = code;
        this.rewardTypeClass = rewardTypeClass;
    }

    public static Class<?> getRewardTypeClass(String code){
        for (BootRewardTypeEnum item : BootRewardTypeEnum.values()) {
            if (item.code.equals(code)) {
                return item.rewardTypeClass;
            }
        }
        return null;
    }

}
