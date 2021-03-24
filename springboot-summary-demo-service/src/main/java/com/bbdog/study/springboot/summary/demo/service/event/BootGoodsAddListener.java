package com.bbdog.study.springboot.summary.demo.service.event;

import com.bbdog.study.springboot.summary.demo.biz.BootGoodsStockBiz;
import com.bbdog.study.springboot.summary.demo.common.exceptions.BizException;
import com.bbdog.study.springboot.summary.demo.manager.event.BootGoodsAddEvent;
import com.bbdog.study.springboot.summary.demo.manager.models.BootGoodsStockBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

/**
 * <p>
 *      商品添加监听，监听BootGoodsAddEvent消息
 *      还可以使用注解的方式实现监听，另外写一下线程池的注解方式
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGoodsAddListener.java Date：2021/3/23 16:10 Version：1.0
 */
@Slf4j
public class BootGoodsAddListener implements ApplicationListener<BootGoodsAddEvent> {

    @Autowired
    private BootGoodsStockBiz bootGoodsStockBiz;

    @Override
    public void onApplicationEvent(BootGoodsAddEvent event) {
        try {
            log.info("商品监听开始，参数：{}", event);

            BootGoodsStockBO bootGoodsStockBO = (BootGoodsStockBO) event.getSource();
            // 主逻辑
            bootGoodsStockBiz.addBootGoodsStock(bootGoodsStockBO);

            log.info("商品监听结束");
        } catch (BizException e) {
            log.error("商品监听业务异常", e);
        } catch (Exception e) {
            log.error("商品监听系统异常", e);
        }
    }

}
