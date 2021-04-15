package com.bbdog.study.springboot.summary.demo.web.javatooltest.easyexcel;

import lombok.Data;

/**
 * <p>
 *      读取Excel中的数据进这个对象
 *      注意：如果这里不用@ExcelProperty注解去指定Excel中的哪个列名，则会默认按照Excel表头字段的顺序，
 *      跟该对象的字段一一对应,将Excel中对应顺序的值赋值给该类的对应的变量。
 *      1、如果该类中比Excel中少一个字段，那么Excel中多的那个字段的值，不会在该类中映射出来，也不会报错。
 *      2、如果该类中比Excel中多一个字段，那么Excel中少的那个字段，不会在该类的这个字段映射值，为空，也不会报错。
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootDataRead.java Date：2021/4/14 16:22 Version：1.0
 */
@Data
public class BootDataRead {

    private String agentCode;

    private String agentName;

    private String teamName;

    private String merchantCode;

    private Integer monthOfYear;

    private String remarks;

    /**
     * 比Excel中多的字段
     */
    private String redundant;

}
