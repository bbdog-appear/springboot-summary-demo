package com.bbdog.study.springboot.summary.demo.core;

import com.bbdog.study.springboot.summary.demo.common.constants.RedisConstant;
import com.bbdog.study.springboot.summary.demo.common.util.RedisUtil;
import com.bbdog.study.springboot.summary.demo.manager.BootCommonConfigManager;
import com.bbdog.study.springboot.summary.demo.manager.models.BootCommonConfigBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *      boot通用配置core
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCommonConfigCore.java Date：2021/3/17 13:48 Version：1.0
 */
@Component
@Slf4j
public class BootCommonConfigCore {

    @Autowired
    private BootCommonConfigManager bootCommonConfigManager;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 同步数据库和redis数据
     *
     * @param list 列表
     * @return 结果
     */
    public void synchronousData(List<BootCommonConfigBO> list){
        // 批量插入通用配置信息
        bootCommonConfigManager.batchAdd(list);

        // 存入redis中
        list.forEach(bo -> redisUtil.set(
                RedisConstant.BOOT_SUMMARY_COMMON_CONFIG_KEY + bo.getCommonKey(), bo, RedisConstant.EXPIRE_TIME));
    }

    /**
     * 根据commonKey查询通用配置信息
     *
     * @param commonKey 通用key
     * @return 通用配置信息BO
     */
    public BootCommonConfigBO queryByCommonKey(String commonKey){
        return bootCommonConfigManager.queryByCommonKey(commonKey);
    }

}
