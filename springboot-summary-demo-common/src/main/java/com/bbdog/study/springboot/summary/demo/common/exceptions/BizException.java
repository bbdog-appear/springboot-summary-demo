package com.bbdog.study.springboot.summary.demo.common.exceptions;

import com.bbdog.study.springboot.summary.demo.common.enums.BizExceptionEnum;
import lombok.Getter;

/**
 * <p>
 *      业务异常
 * </p>
 *
 * @author cheng.wang
 * @version Id：BizException.java Date：2021/3/17 17:00 Version：1.0
 */
@Getter
public class BizException extends RuntimeException{

    private static final long serialVersionUID = 7025523915979318634L;

    private final String code;
    private final String message;

    public BizException(BizExceptionEnum bizExceptionEnum){
        this.code = bizExceptionEnum.getCode();
        this.message = bizExceptionEnum.getDesc();
    }

    public BizException(String code, String message){
        this.code = code;
        this.message = message;
    }

}
