package com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode;

import com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode.models.CouponModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>
 *      优惠券
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCoupon.java Date：2021/4/26 17:34 Version：1.0
 */
@Slf4j
@Component
public class BootCoupon implements BootInterface<CouponModel, String>{

    @Override
    public void sendReward(CouponModel data, String message) {
        log.info("模拟优惠券发放，数据CouponModel：{},日志号为：{}", data, message);
    }

    @Override
    public CouponModel createData() {
        return new CouponModel();
    }

    @Override
    public String createMessage() {
        return "优惠券发放日志号";
    }

    @Override
    public Class<CouponModel> getClassObject() {
        return CouponModel.class;
    }

}
