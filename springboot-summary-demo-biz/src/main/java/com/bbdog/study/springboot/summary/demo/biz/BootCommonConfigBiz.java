package com.bbdog.study.springboot.summary.demo.biz;

import com.bbdog.study.springboot.summary.demo.common.constants.RedisConstant;
import com.bbdog.study.springboot.summary.demo.common.enums.BizExceptionEnum;
import com.bbdog.study.springboot.summary.demo.common.exceptions.BizException;
import com.bbdog.study.springboot.summary.demo.common.util.RedisUtil;
import com.bbdog.study.springboot.summary.demo.core.BootCommonConfigCore;
import com.bbdog.study.springboot.summary.demo.manager.models.BootCommonConfigBO;
import com.bbdog.study.springboot.summary.demo.manager.models.BootCommonConfigReqBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *      boot通用配置Biz
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCommonConfigBiz.java Date：2021/3/17 15:57 Version：1.0
 */
@Component
@Slf4j
public class BootCommonConfigBiz {

    @Autowired
    private BootCommonConfigCore bootCommonConfigCore;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 同步和查询通用配置数据
     *
     * @param bootCommonConfigReqBO 请求BO
     * @return 通用配置信息
     */
    public BootCommonConfigBO synchronousDataAndQuery(BootCommonConfigReqBO bootCommonConfigReqBO){
        if (bootCommonConfigReqBO == null) {
            throw new BizException(BizExceptionEnum.COMMON_CONFIG_PARTICIPATE_EMPTY);
        }
        log.info("同步数据和查询数据开始");
        // 同步数据库和redis数据
        bootCommonConfigCore.synchronousData(bootCommonConfigReqBO.getBootCommonConfigBOList());

        // 根据commonKey查询配置信息
        return redisUtil.getObjByKey(RedisConstant.BOOT_SUMMARY_COMMON_CONFIG_KEY +
                bootCommonConfigReqBO.getCommonKey(), BootCommonConfigBO.class);
    }

}
