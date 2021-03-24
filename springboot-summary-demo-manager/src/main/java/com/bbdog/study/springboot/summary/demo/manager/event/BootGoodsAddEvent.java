package com.bbdog.study.springboot.summary.demo.manager.event;

import com.bbdog.study.springboot.summary.demo.manager.models.BootGoodsStockBO;
import org.springframework.context.ApplicationEvent;

/**
 * <p>
 *      boot商品添加事件模型
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGoodsAddEvent.java Date：2021/3/23 11:16 Version：1.0
 */
public class BootGoodsAddEvent extends ApplicationEvent {

    private static final long serialVersionUID = -1300850396972383326L;

    /**
     * Create a new ApplicationEvent.
     *
     * @param bootGoodsStockBO the object on which the event initially occurred (never {@code null})
     */
    public BootGoodsAddEvent(BootGoodsStockBO bootGoodsStockBO) {
        super(bootGoodsStockBO);
    }

}
