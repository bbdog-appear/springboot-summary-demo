package com.bbdog.study.springboot.summary.demo.api.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 *      结果类
 * </p>
 *
 * @author cheng.wang
 * @version Id：Result.java Date：2021/3/15 19:44 Version：1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 7599874416915008210L;

    private Boolean status;
    private String resultCode;
    private String resultDesc;
    private T data;

    public static <E> Result<E> buildSuccess(E data){
        return new Result<>(true, "success", "成功", data);
    }

    public static <E> Result<E> buildFail(String resultCode, String resultDesc){
        return new Result<>(false, resultCode, resultDesc, null);
    }

}
