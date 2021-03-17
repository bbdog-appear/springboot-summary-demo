package com.bbdog.study.springboot.summary.demo.manager;

import com.bbdog.study.springboot.summary.demo.dal.mapper.BootCommonConfigMapper;
import com.bbdog.study.springboot.summary.demo.dal.models.BootCommonConfigDO;
import com.bbdog.study.springboot.summary.demo.manager.converter.BootCommonConfigConverter;
import com.bbdog.study.springboot.summary.demo.manager.models.BootCommonConfigBO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *      boot通用配置Manager
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCommonConfigManager.java Date：2021/3/17 13:32 Version：1.0
 */
@Component
@Slf4j
public class BootCommonConfigManager {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 批量插入通用配置信息
     *
     * @param list 列表
     */
    public void batchAdd(List<BootCommonConfigBO> list){
        List<BootCommonConfigDO> bootCommonConfigDoS = BootCommonConfigConverter.bootCommonConfigBoListToDoList(list);
        try (SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false)) {
            BootCommonConfigMapper mapper = session.getMapper(BootCommonConfigMapper.class);
            bootCommonConfigDoS.forEach(mapper::insert);
            session.commit();
        }
    }

}
