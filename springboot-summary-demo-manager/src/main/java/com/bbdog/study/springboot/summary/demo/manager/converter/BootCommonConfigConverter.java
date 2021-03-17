package com.bbdog.study.springboot.summary.demo.manager.converter;

import com.bbdog.study.springboot.summary.demo.dal.models.BootCommonConfigDO;
import com.bbdog.study.springboot.summary.demo.manager.models.BootCommonConfigBO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *      boot通用配置转换类
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCommonConfigConverter.java Date：2021/3/17 13:55 Version：1.0
 */
public class BootCommonConfigConverter {

    /**
     * BootCommonConfigBO --> BootCommonConfigDO
     *
     * @param bootCommonConfigBO BootCommonConfigBO
     * @return BootCommonConfigDO
     */
    public static BootCommonConfigDO bootCommonConfigBoToDo(BootCommonConfigBO bootCommonConfigBO){
        if (bootCommonConfigBO == null) {
            return null;
        }
        BootCommonConfigDO bootCommonConfigDO = new BootCommonConfigDO();
        bootCommonConfigDO.setId(bootCommonConfigBO.getId());
        bootCommonConfigDO.setCommonType(bootCommonConfigBO.getCommonType());
        bootCommonConfigDO.setCommonKey(bootCommonConfigBO.getCommonKey());
        bootCommonConfigDO.setCommonValue(bootCommonConfigBO.getCommonValue());
        return bootCommonConfigDO;
    }

    /**
     * List<BootCommonConfigBO> --> List<BootCommonConfigDO>
     *
     * @param list List<BootCommonConfigBO>
     * @return List<BootCommonConfigDO>
     */
    public static List<BootCommonConfigDO> bootCommonConfigBoListToDoList(List<BootCommonConfigBO> list){
        List<BootCommonConfigDO> bootCommonConfigDoS = new ArrayList<>();
        if (CollectionUtils.isEmpty(list)) {
            return bootCommonConfigDoS;
        }
        for (BootCommonConfigBO bootCommonConfigBO : list) {
            BootCommonConfigDO bootCommonConfigDO = bootCommonConfigBoToDo(bootCommonConfigBO);
            bootCommonConfigDoS.add(bootCommonConfigDO);
        }
        return bootCommonConfigDoS;
    }

}
