package com.bbdog.study.springboot.summary.demo.api.models;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *      通用配置信息DTO
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCommonConfigDTO.java Date：2021/3/17 16:13 Version：1.0
 */
@Data
@ToString
public class BootCommonConfigDTO implements Serializable {

    private static final long serialVersionUID = 2898804087387340312L;

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
