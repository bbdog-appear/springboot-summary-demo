package com.bbdog.study.springboot.summary.demo.core;

import com.bbdog.study.springboot.summary.demo.manager.BootGoodsStockManager;
import com.bbdog.study.springboot.summary.demo.manager.models.BootGoodsStockBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 *      boot商品库存Core
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGoodsStockCore.java Date：2021/3/23 17:41 Version：1.0
 */
@Component
@Slf4j
public class BootGoodsStockCore {

    @Autowired
    private BootGoodsStockManager bootGoodsStockManager;

    /**
     * 新增boot商品库存信息
     *
     * @param bootGoodsStockBO 商品库存信息
     */
    public void addBootGoodsStock(BootGoodsStockBO bootGoodsStockBO){
        bootGoodsStockManager.addBootGoodsStock(bootGoodsStockBO);
    }

}
