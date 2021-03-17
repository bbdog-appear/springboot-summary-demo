package com.bbdog.study.springboot.summary.demo.manager.models;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 *      boot公共配置BO
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCommonConfigBO.java Date：2021/3/17 13:30 Version：1.0
 */
@Data
@ToString
public class BootCommonConfigBO {

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
