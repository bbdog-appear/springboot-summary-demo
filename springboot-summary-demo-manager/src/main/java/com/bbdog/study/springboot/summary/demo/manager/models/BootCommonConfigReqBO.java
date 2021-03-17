package com.bbdog.study.springboot.summary.demo.manager.models;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * <p>
 *      同步和查询通用配置信息请求BO
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCommonConfigReqBO.java Date：2021/3/17 19:25 Version：1.0
 */
@Data
@ToString
public class BootCommonConfigReqBO {

    /**
     * 通用key
     */
    private String commonKey;

    /**
     * 通用配置信息列表
     */
    private List<BootCommonConfigBO> bootCommonConfigBOList;

}
