package com.bbdog.study.springboot.summary.demo.manager.converter;

import com.bbdog.study.springboot.summary.demo.dal.models.BootGoodsStockDO;
import com.bbdog.study.springboot.summary.demo.manager.models.BootGoodsStockBO;

/**
 * <p>
 *      boot商品库存转换类
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGoodsStockConverter.java Date：2021/3/23 17:47 Version：1.0
 */
public class BootGoodsStockConverter {

    /**
     * BootGoodsStockBO --> BootGoodsStockDO
     *
     * @param bootGoodsStockBO BootGoodsStockBO
     * @return BootGoodsStockDO
     */
    public static BootGoodsStockDO bootGoodsStockBoToDo(BootGoodsStockBO bootGoodsStockBO){
        if (bootGoodsStockBO == null) {
            return null;
        }
        BootGoodsStockDO bootGoodsStockDO = new BootGoodsStockDO();
        bootGoodsStockDO.setGoodsCode(bootGoodsStockBO.getGoodsCode());
        bootGoodsStockDO.setGoodsName(bootGoodsStockBO.getGoodsName());
        bootGoodsStockDO.setGoodsPrice(bootGoodsStockBO.getGoodsPrice());
        bootGoodsStockDO.setGoodsTotalNum(bootGoodsStockBO.getGoodsTotalNum());
        bootGoodsStockDO.setGoodsRemainNum(bootGoodsStockBO.getGoodsRemainNum());
        return bootGoodsStockDO;
    }

}
