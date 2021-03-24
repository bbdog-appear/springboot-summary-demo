package com.bbdog.study.springboot.summary.demo.service.event;

import com.bbdog.study.springboot.summary.demo.biz.BootGoodsStockBiz;
import com.bbdog.study.springboot.summary.demo.common.exceptions.BizException;
import com.bbdog.study.springboot.summary.demo.manager.event.BootGoodsAddEvent;
import com.bbdog.study.springboot.summary.demo.manager.models.BootGoodsStockBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

/**
 * <p>
 *      注解的方式进行监听
 * </p>
 *
 * @author cheng.wang
 * @version Id：GoodsAnnotationListener.java Date：2021/3/24 9:19 Version：1.0
 */
@Slf4j
public class GoodsAnnotationListener {

    @Autowired
    private BootGoodsStockBiz bootGoodsStockBiz;

    @EventListener
    public void onApplicationEvent(BootGoodsAddEvent event){
        try {
            log.info("商品注解方式监听开始，参数：{}", event);

            BootGoodsStockBO bootGoodsStockBO = (BootGoodsStockBO) event.getSource();
            // 主逻辑
            bootGoodsStockBiz.addBootGoodsStock(bootGoodsStockBO);

            log.info("商品注解方式监听结束");
        } catch (BizException e) {
            log.error("商品注解方式监听业务异常", e);
        } catch (Exception e) {
            log.error("商品注解方式监听系统异常", e);
        }
    }

}
