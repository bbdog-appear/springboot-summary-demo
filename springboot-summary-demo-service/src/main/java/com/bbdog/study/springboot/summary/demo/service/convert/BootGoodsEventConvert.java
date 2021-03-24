package com.bbdog.study.springboot.summary.demo.service.convert;
import com.bbdog.study.springboot.summary.demo.api.models.BootGoodsStockDTO;
import com.bbdog.study.springboot.summary.demo.manager.models.BootGoodsStockBO;

import com.bbdog.study.springboot.summary.demo.api.models.BootCommonConfigResDTO;
import com.bbdog.study.springboot.summary.demo.api.models.BootGoodsEventReqDTO;
import com.bbdog.study.springboot.summary.demo.manager.models.BootCommonConfigBO;
import com.bbdog.study.springboot.summary.demo.manager.models.BootGoodsEventReqBO;

/**
 * <p>
 *      boot商品事件转换类
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootGoodsEventConvert.java Date：2021/3/22 19:49 Version：1.0
 */
public class BootGoodsEventConvert {

    /**
     * BootGoodsEventReqDTO --> BootGoodsEventReqBO
     *
     * @param bootGoodsEventReqDTO BootGoodsEventReqDTO
     * @return BootGoodsEventReqBO
     */
    public static BootGoodsEventReqBO bootGoodsEventReqDtoToBo(BootGoodsEventReqDTO bootGoodsEventReqDTO){
        if (bootGoodsEventReqDTO == null) {
            return null;
        }
        BootGoodsEventReqBO bootGoodsEventReqBO = new BootGoodsEventReqBO();
        bootGoodsEventReqBO.setCommonKey(bootGoodsEventReqDTO.getCommonKey());
        BootGoodsStockDTO bootGoodsStockDTO = bootGoodsEventReqDTO.getBootGoodsStockDTO();
        if (bootGoodsStockDTO != null) {
            BootGoodsStockBO bootGoodsStockBO = new BootGoodsStockBO();
            bootGoodsStockBO.setGoodsCode(bootGoodsStockDTO.getGoodsCode());
            bootGoodsStockBO.setGoodsName(bootGoodsStockDTO.getGoodsName());
            bootGoodsStockBO.setGoodsPrice(bootGoodsStockDTO.getGoodsPrice());
            bootGoodsStockBO.setGoodsTotalNum(bootGoodsStockDTO.getGoodsTotalNum());
            bootGoodsStockBO.setGoodsRemainNum(bootGoodsStockDTO.getGoodsRemainNum());
            bootGoodsEventReqBO.setBootGoodsStockBO(bootGoodsStockBO);
        }
        return bootGoodsEventReqBO;
    }

}
