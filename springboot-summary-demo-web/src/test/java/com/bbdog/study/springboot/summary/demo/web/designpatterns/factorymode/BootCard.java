package com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode;

import com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode.models.CardModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>
 *      爱奇艺兑换卡
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCard.java Date：2021/4/26 17:34 Version：1.0
 */
@Slf4j
@Component
public class BootCard implements BootInterface<CardModel, String>{

    @Override
    public void sendReward(CardModel data, String message) {
        log.info("模拟爱奇艺兑换卡发放,数据CardModel：{},日志号：{}", data, message);
    }

    @Override
    public CardModel createData() {
        return new CardModel();
    }

    @Override
    public String createMessage() {
        return "爱奇艺兑换卡发放日志号";
    }

    @Override
    public Class<CardModel> getClassObject() {
        return CardModel.class;
    }

}
