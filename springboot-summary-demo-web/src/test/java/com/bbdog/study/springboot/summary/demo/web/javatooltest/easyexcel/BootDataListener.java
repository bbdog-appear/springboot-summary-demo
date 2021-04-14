package com.bbdog.study.springboot.summary.demo.web.javatooltest.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *      有个很重要的点 BootDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootDataListener.java Date：2021/4/14 16:18 Version：1.0
 */
@Slf4j
public class BootDataListener extends AnalysisEventListener<BootDataRead> {

    @Override
    public void invoke(BootDataRead bootData, AnalysisContext analysisContext) {
        log.info("解析到excel数据：{}", bootData);
        log.info("analysisContext信息：{}", analysisContext);
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param analysisContext AnalysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("这里也要进行操作一次，确保最后遗留的数据也不丢失");
    }

}
