package com.bbdog.study.springboot.summary.demo.biz;

import com.bbdog.study.springboot.summary.demo.core.BootGoodsStockCore;
import com.bbdog.study.springboot.summary.demo.manager.models.BootGoodsStockBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 *      boot商品库存Biz
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGoodsStockBiz.java Date：2021/3/23 17:29 Version：1.0
 */
@Component
@Slf4j
public class BootGoodsStockBiz {

    @Autowired
    private BootGoodsStockCore bootGoodsStockCore;

    /**
     * 新增boot商品库存信息
     *
     * @param bootGoodsStockBO 商品库存信息
     */
    public void addBootGoodsStock(BootGoodsStockBO bootGoodsStockBO){
        bootGoodsStockCore.addBootGoodsStock(bootGoodsStockBO);
    }

}
