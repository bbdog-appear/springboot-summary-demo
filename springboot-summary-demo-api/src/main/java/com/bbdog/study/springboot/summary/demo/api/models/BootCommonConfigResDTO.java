package com.bbdog.study.springboot.summary.demo.api.models;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *      同步和查询通用配置信息响应DTO
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCommonConfigResDTO.java Date：2021/3/17 16:17 Version：1.0
 */
@Data
@ToString
public class BootCommonConfigResDTO implements Serializable {

    private static final long serialVersionUID = 637263168906219501L;

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
