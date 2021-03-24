package com.bbdog.study.springboot.summary.demo.dal.mapper;

import com.bbdog.study.springboot.summary.demo.dal.models.BootGoodsStockDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *      boot商品库存Mapper
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGoodsStockMapper.java Date：2021/3/23 17:51 Version：1.0
 */
public interface BootGoodsStockMapper {

    /**
     * 新增通用配置信息
     *
     * @param bootGoodsStockDO 商品库存DO
     */
    void insert(BootGoodsStockDO bootGoodsStockDO);

}
