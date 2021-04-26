package com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode.models;

import lombok.Data;

/**
 * <p>
 *      爱奇艺会员卡
 * </p>
 *
 * @author cheng.wang
 * @version Id：CardModel.java Date：2021/4/26 17:37 Version：1.0
 */
@Data
public class CardModel {

    /**
     * 绑定的手机号
     */
    private String bindMobileNumber;
    /**
     * 卡号
     */
    private String cardId;

}
