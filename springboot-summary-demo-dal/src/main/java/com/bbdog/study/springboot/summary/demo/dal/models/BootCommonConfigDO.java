package com.bbdog.study.springboot.summary.demo.dal.models;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 *      BootCommonConfigDO，对应boot_common_config表
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCommonConfigDO.java Date：2021/3/17 9:52 Version：1.0
 */
@Data
@ToString
public class BootCommonConfigDO {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 通用类型
     */
    private String commonType;

    /**
     * 通用key
     */
    private String commonKey;

    /**
     * 通用value
     */
    private String commonValue;

}
