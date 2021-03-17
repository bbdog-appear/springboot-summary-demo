package com.bbdog.study.springboot.summary.demo.api.models;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *      同步和查询通用配置信息请求DTO
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCommonConfigReqDTO.java Date：2021/3/17 16:11 Version：1.0
 */
@Data
@ToString
public class BootCommonConfigReqDTO implements Serializable {

    private static final long serialVersionUID = -3207258719746388441L;

    /**
     * 通用key
     */
    private String commonKey;

    /**
     * 通用配置信息列表
     */
    private List<BootCommonConfigDTO> bootCommonConfigDTOList;

}
