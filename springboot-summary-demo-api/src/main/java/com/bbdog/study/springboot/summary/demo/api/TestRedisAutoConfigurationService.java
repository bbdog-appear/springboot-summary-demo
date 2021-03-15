package com.bbdog.study.springboot.summary.demo.api;

import com.bbdog.study.springboot.summary.demo.api.models.RedisAutoConfigResDTO;
import com.bbdog.study.springboot.summary.demo.common.Result;

/**
 * <p>
 *      测试redis自动配置service
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestRedisAutoConfigurationService.java Date：2021/3/15 20:03 Version：1.0
 */
public interface TestRedisAutoConfigurationService {

    /**
     * 测试redis自动配置接口
     *
     * @return 结果
     */
    Result<RedisAutoConfigResDTO> testRedisAutoConfiguration();

}
