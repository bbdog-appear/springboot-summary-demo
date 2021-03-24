package com.bbdog.study.springboot.summary.demo.manager;

import com.bbdog.study.springboot.summary.demo.dal.mapper.BootGoodsStockMapper;
import com.bbdog.study.springboot.summary.demo.dal.models.BootGoodsStockDO;
import com.bbdog.study.springboot.summary.demo.manager.converter.BootGoodsStockConverter;
import com.bbdog.study.springboot.summary.demo.manager.models.BootGoodsStockBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 *      boot商品库存Manager
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGoodsStockManager.java Date：2021/3/23 17:43 Version：1.0
 */
@Component
@Slf4j
public class BootGoodsStockManager {

    @Autowired
    private BootGoodsStockMapper bootGoodsStockMapper;

    /**
     * 新增boot商品库存信息
     *
     * @param bootGoodsStockBO 商品库存信息
     */
    public void addBootGoodsStock(BootGoodsStockBO bootGoodsStockBO){
        BootGoodsStockDO bootGoodsStockDO = BootGoodsStockConverter.bootGoodsStockBoToDo(bootGoodsStockBO);
        bootGoodsStockMapper.insert(bootGoodsStockDO);
    }

}
