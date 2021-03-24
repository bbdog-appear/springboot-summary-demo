package com.bbdog.study.springboot.summary.demo.dal.mapper;

import com.bbdog.study.springboot.summary.demo.dal.models.BootCommonConfigDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *      boot通用配置增删改查Mapper
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCommonConfigMapper.java Date：2021/3/17 18:49 Version：1.0
 */
public interface BootCommonConfigMapper {

    /**
     * 新增通用配置信息
     *
     * @param bootCommonConfigDO 通用配置信息DO
     */
    void insert(BootCommonConfigDO bootCommonConfigDO);

    /**
     * 根据commonKey查询
     *
     * @param commonKey key
     * @return 结果
     */
    List<BootCommonConfigDO> selectByCommonKey(@Param("commonKey") String commonKey);

}
