package com.bbdog.study.springboot.summary.demo.common.enums;

import lombok.Getter;

/**
 * <p>
 *      业务异常枚举类
 * </p>
 *
 * @author cheng.wang
 * @version Id：BizExceptionEnum.java Date：2021/3/17 16:08 Version：1.0
 */
@Getter
public enum BizExceptionEnum {

    /**
     * 查询通用配置信息为空
     */
    COMMON_CONFIG_QUERY_EMPTY("COMMON_CONFIG_QUERY_EMPTY", "查询通用配置信息为空"),

    COMMON_CONFIG_PARTICIPATE_EMPTY("COMMON_CONFIG_PARTICIPATE_EMPTY", "同步和查询通用配置接口请求参数为空"),

    ;

    private final String code;
    private final String desc;

    BizExceptionEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

}
