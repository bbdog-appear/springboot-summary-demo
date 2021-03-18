package com.bbdog.study.springboot.summary.demo.web;

import com.bbdog.study.springboot.summary.demo.api.BootCommonConfigService;
import com.bbdog.study.springboot.summary.demo.api.models.BootCommonConfigDTO;
import com.bbdog.study.springboot.summary.demo.api.models.BootCommonConfigReqDTO;
import com.bbdog.study.springboot.summary.demo.api.models.BootCommonConfigResDTO;
import com.bbdog.study.springboot.summary.demo.api.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *      测试boot通用配置数据同步和查询
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestBootCommonConfig.java Date：2021/3/18 10:27 Version：1.0
 */
@Slf4j
public class TestBootCommonConfig extends SpringbootSummaryDemoWebApplicationTests{
    private static final String traceLogId = UUID.randomUUID().toString();

    @Autowired
    private BootCommonConfigService bootCommonConfigService;

    @Test
    public void testRedisAutoConfiguration() {
        BootCommonConfigReqDTO bootCommonConfigReqDTO = new BootCommonConfigReqDTO();
        bootCommonConfigReqDTO.setCommonKey("30001");
        List<BootCommonConfigDTO> bootCommonConfigDTOList = new ArrayList<>();
        BootCommonConfigDTO bootCommonConfigDTO1 = new BootCommonConfigDTO();
        bootCommonConfigDTO1.setCommonType("furniture");
        bootCommonConfigDTO1.setCommonKey("30003");
        bootCommonConfigDTO1.setCommonValue("椅子");
        bootCommonConfigDTOList.add(bootCommonConfigDTO1);
        BootCommonConfigDTO bootCommonConfigDTO2 = new BootCommonConfigDTO();
        bootCommonConfigDTO2.setCommonType("furniture");
        bootCommonConfigDTO2.setCommonKey("30004");
        bootCommonConfigDTO2.setCommonValue("床");
        bootCommonConfigDTOList.add(bootCommonConfigDTO2);
        bootCommonConfigReqDTO.setBootCommonConfigDTOList(bootCommonConfigDTOList);
        Result<BootCommonConfigResDTO> result = bootCommonConfigService.synchronousDataAndQuery(traceLogId, bootCommonConfigReqDTO);
        log.info("=======结果是：{}", result);
        System.out.println("====输出结果是：" + result);
    }

}
