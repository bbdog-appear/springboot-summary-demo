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
     * 其中ON DUPLICATE KEY UPDATE的作用是当表结构中有主键或者唯一索引时，当有相同的键存入时，就会触发该语句
     * 即根据主键或者唯一索引更新某些字段，更新成功返回2
     *
     * @param bootGoodsStockDO 商品库存DO
     */
    void insert(BootGoodsStockDO bootGoodsStockDO);

}
