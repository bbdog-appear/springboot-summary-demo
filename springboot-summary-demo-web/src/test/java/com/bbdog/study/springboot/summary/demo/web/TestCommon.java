package com.bbdog.study.springboot.summary.demo.web;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.bbdog.study.springboot.summary.demo.api.BootCommonConfigService;
import com.bbdog.study.springboot.summary.demo.service.BootCommonConfigServiceImpl;
import com.bbdog.study.springboot.summary.demo.web.javatooltest.easyexcel.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *      通用测试
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestCommon.java Date：2021/4/14 10:32 Version：1.0
 */
@Slf4j
public class TestCommon extends SpringbootSummaryDemoWebApplicationTests{

    @Autowired
    private ApplicationContext context;

    /**
     * 测试Spring上下文获取同一类型的bean，实例是否一样。结论：都是相同的对象
     * 其中用接口作为class也可以获取实现类的bean。
     */
    @Test
    public void testSpringSource(){
        BootCommonConfigService bean = context.getBean(BootCommonConfigService.class);
        BootCommonConfigService bean2 = context.getBean(BootCommonConfigService.class);
        BootCommonConfigServiceImpl bean3 = context.getBean(BootCommonConfigServiceImpl.class);
        System.out.println(bean + "\n" +bean2 + "\n" +bean3);
    }

    /**
     * 测试阿里的EasyExcel读取,会调用BootDataListener的invoke方法，逐行读取Excel中的内容，其中BootData中不需要指定列号或字段名，
     * 直接可以忽略第一行的表头，直接读取数据。
     */
    @Test
    public void testEasyExcelRead(){
        // 前提：在本机的D盘中放一个333abc.xlsx文件
        String fileName = "D:\\333abc.xlsx";

        // 构建ExcelReader，指定读取的文件，装载数据的类型，回调对象
        ExcelReader reader = EasyExcel.read(fileName, BootDataRead.class, new BootDataListener()).build();

        // 当执行这个方法，就会循环触发回调对象中的invoke方法。
        reader.read(new ReadSheet(0));
        System.out.println(reader);
    }

    /**
     * 测试阿里的EasyExcel写出
     */
    @Test
    public void testEasyExcelWrite(){
        // 不需要提前准备文件,会自动生成
        String fileName = "D:\\副本333abc.xlsx";
        // 指定Excel文件的表头字段，即@ExcelProperty(value = "代理商号", index = 2)指定的名字
        ExcelWriter writer = EasyExcel.write(fileName, BootDataWrite.class).build();
        // 将数据写在名为模板sheet1的sheet中。
        WriteSheet writeSheet = EasyExcel.writerSheet("模板sheet1").build();
        // 将List里的数据写入Excel中，如果成员变量中执行Excel位置，那么数据就会写在那个位置。
        writer.write(getBootDataWrites(), writeSheet);
        // 这里一定要finish关闭流，不然数据写不到Excel中
        writer.finish();
        System.out.println("写出Excel");
    }

    private List<BootDataWrite> getBootDataWrites() {
        List<BootDataWrite> bootDataWriteList = new ArrayList<>();
        BootDataWrite bootDataWrite1 = new BootDataWrite();
        bootDataWrite1.setAgentCode("121696282650083328");
        bootDataWrite1.setAgentName("山西海景航空商旅股份有限公司");
        bootDataWrite1.setMerchantCode("6666000110051785");
        bootDataWrite1.setMonthOfYear(202010);
        BootDataWrite bootDataWrite2 = new BootDataWrite();
        bootDataWrite2.setAgentCode("155406554426245120");
        bootDataWrite2.setAgentName("平度市城关镇兰典饭店");
        bootDataWrite2.setMerchantCode("6666000110019754");
        bootDataWrite2.setMonthOfYear(202010);
        bootDataWriteList.add(bootDataWrite1);
        bootDataWriteList.add(bootDataWrite2);
        return bootDataWriteList;
    }

    /**
     * 测试阿里的EasyExcel读取,此种是未知Excel中表头的字段名称的。因此Model中字段就不知道什么含义了，随便定义10个字段，
     * 然后直接读取Excel的值。这种情况是需要知道关键字段的位置的。所以将关键字段约定好放在Excel的前几行，那么Model中就可以
     * 定义前几个字段，对其进行校验。
     * 但是到时候写出的时候，由于其他字段的名字未知，所以在读的时候，需要获取文件表头字段，然后一一对应下来。
     */
    @Test
    public void testEasyExcelReadUKnownField(){
        // 前提：在本机的D盘中放一个333abc.xlsx文件
        String fileName = "D:\\333abc.xlsx";

        // 构建ExcelReader，指定读取的文件，装载数据的类型，回调对象
        BootDataUKnownListener listener = new BootDataUKnownListener();
        ExcelReader reader = EasyExcel.read(fileName, BootDataReadUKnown.class, listener).build();

        // 当执行这个方法，就会循环触发回调对象中的invoke方法。
        reader.read(new ReadSheet(0));
        reader.finish();

        Integer total = listener.getHandleResultCount().getTotal();
        Integer success = listener.getHandleResultCount().getSuccess();
        log.info("总条数：{}，成功条数：{}", total, success);
    }

}
