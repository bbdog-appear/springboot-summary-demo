package com.bbdog.study.springboot.summary.demo.web.javatooltest.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * <p>
 *      将这个对象里的数据写到Excel中
 *      1、如果不用@ExcelProperty注解去指定表头字段名，则写出的Excel表头字段就是成员变量字段，例如：agentCode|agentName|teamName..。
 *      2、使用@ExcelProperty("代理商号")指定name后，表头字段会按照该类中的字段顺序平铺在Excel表头中。
 *      3、如果@ExcelProperty中指定index的位置，如代理商号指定在excel的第3个位置，然后后面的字段顺着往前排：服务商名称-->团队名称-->代理商号-->商户客户号-->代理商号-->月份-->备注
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootDataWrite.java Date：2021/4/14 17:27 Version：1.0
 */
@Data
public class BootDataWrite {

    @ExcelProperty(value = "代理商号", index = 2)
    private String agentCode;

    @ExcelProperty("服务商名称")
    private String agentName;

    @ExcelProperty("团队名称")
    private String teamName;

    @ExcelProperty("商户客户号")
    private String merchantCode;

    @ExcelProperty("月份")
    private Integer monthOfYear;

    @ExcelProperty("备注")
    private String remarks;

}
