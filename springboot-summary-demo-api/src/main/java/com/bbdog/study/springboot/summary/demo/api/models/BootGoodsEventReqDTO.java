package com.bbdog.study.springboot.summary.demo.api.models;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *      查询通用配置并发布商品事件请求DTO
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGoodsEventReqDTO.java Date：2021/3/22 19:32 Version：1.0
 */
@Data
@ToString
public class BootGoodsEventReqDTO implements Serializable {

    private static final long serialVersionUID = 8504158953919423531L;

    /**
     * 通用key
     */
    private String commonKey;

    /**
     * 商品库存信息
     */
    private BootGoodsStockDTO bootGoodsStockDTO;

}
