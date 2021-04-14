package com.bbdog.study.springboot.summary.demo.web.javatooltest.easyexcel;

import lombok.Data;

/**
 * <p>
 *      读取Excel中的数据进这个对象
 *      注意：如果这里不用@ExcelProperty注解去指定Excel中的哪个列名，则会默认按照Excel表头字段的顺序，跟该对象的字段一一对应。
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

}
