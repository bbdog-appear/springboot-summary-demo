package com.bbdog.study.springboot.summary.demo.web.javatooltest.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *      读取Excel，回调操作
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootDataUKnownListener.java Date：2021/4/14 20:05 Version：1.0
 */
@Slf4j
public class BootDataUKnownListener extends AnalysisEventListener<BootDataReadUKnown> {

    private Map<Integer, String> headMap;
    private final List<BootDataReadUKnown> bootDataReadUKnownList = new ArrayList<>();
    private final WriteSheet writeSheet = new WriteSheet();
    private ExcelWriter writer;
    private Boolean consoleFileFlag = true;
    private final HandleResultCount handleResultCount = new HandleResultCount();
    private final List<BootDataReadUKnown> groupList = new ArrayList<>();

    /**
     * 读取文件头字段
     *
     * @param headMap 文件头字段名称
     * @param context AnalysisContext
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        this.headMap = headMap;
        log.info("文件头信息：{}", headMap);
        log.info("头部AnalysisContext为：{}", context);
    }

    /**
     * 读取文件内容
     *
     * @param data 每一行的数据
     * @param context AnalysisContext
     */
    @Override
    public void invoke(BootDataReadUKnown data, AnalysisContext context) {
        handleResultCount.setTotal(handleResultCount.getTotal() + 1);
        // 1、创建文件头
        if (consoleFileFlag) {
            // 整张表的表头
            List<List<String>> wrapperList = new ArrayList<>();
            for (Map.Entry<Integer, String> entry : headMap.entrySet()){
                List<String> list = new ArrayList<>();
                list.add(entry.getValue());
                wrapperList.add(list);
            }
            writer = EasyExcel.write("D:\\副本444cba.xlsx").needHead(true).head(wrapperList).excelType(ExcelTypeEnum.XLSX).build();
            consoleFileFlag = false;
        }

        // 2、拿到数据校验一下，拿到校验失败的原因
        String agentCode = data.getAgentCode();
        String field4 = data.getField4();
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isEmpty(agentCode)) {
            builder.append("代理商号不能为空");
        }
        if (StringUtils.isEmpty(field4)) {
            builder.append("商户客户号不能为空");
        }
        String errorMsg = builder.toString();

        // 3、查询数据库获取团队名称信息
        String teamName = "顶牛团队";

        // 4、将这两个字段的值赋值给data,其中团队信息由于是固定位置的，所以直接赋值。备注因为在表头的最后一列，所以要根据表头的长度最后一位去赋值
        int size = headMap.size();
        // 使用bean包装类，将目标对象中指定字段名赋值
        BeanWrapper wrapper = new BeanWrapperImpl(data);
        wrapper.setPropertyValue("field" + size, errorMsg);
        // 赋值团队名称
        data.setField3(teamName);

        if (StringUtils.isEmpty(errorMsg)) {
            handleResultCount.setSuccess(handleResultCount.getSuccess() + 1);

            // 校验成功的这一行数据存入将要分组的列表中
            groupList.add(data);
        }

        // 5、将这个数据写出到另一个Excel中，每1000条写出一次
        bootDataReadUKnownList.add(data);
        // 每1000条写出一次
        if (bootDataReadUKnownList.size() >= 1000) {
            write();
        }

    }

    /**
     * 如果上面的Excel条数没有1000条，就不会走到write()方法
     * 那么读取完Excel后再执行这个write()操作
     *
     * @param context AnalysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        write();
        writer.finish();

        // 拆分表的逻辑
        // 根据(代理商号-月份)分组
        Map<String, List<BootDataReadUKnown>> agentMonthMap = groupList.stream().collect(
                Collectors.groupingBy(item -> item.getAgentCode() + "-" + item.getField5()));
        int i = 0;
        for (Map.Entry<String, List<BootDataReadUKnown>> entry : agentMonthMap.entrySet()) {
            i++;
            // 整张表的表头
            List<List<String>> wrapperList = new ArrayList<>();
            for (Map.Entry<Integer, String> entry2 : headMap.entrySet()){
                List<String> list = new ArrayList<>();
                list.add(entry2.getValue());
                wrapperList.add(list);
            }
            // 移除最后一个元素，即把备注这个表头字段去掉
            wrapperList.remove(headMap.size() - 1);
            // 循环创建切分的Excel表头
            ExcelWriter writer = EasyExcel.write("D:\\副本444cba"+i+".xlsx").needHead(true).head(wrapperList).excelType(ExcelTypeEnum.XLSX).build();
            writer.write(entry.getValue(), new WriteSheet());
            writer.finish();
        }

    }

    private void write(){
        writer.write(bootDataReadUKnownList, writeSheet);
        bootDataReadUKnownList.clear();
    }

    public HandleResultCount getHandleResultCount() {
        return this.handleResultCount;
    }


}
