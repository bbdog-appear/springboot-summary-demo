package com.bbdog.study.springboot.summary.demo.service.convert;

import com.bbdog.study.springboot.summary.demo.api.models.BootCommonConfigDTO;
import com.bbdog.study.springboot.summary.demo.api.models.BootCommonConfigReqDTO;
import com.bbdog.study.springboot.summary.demo.api.models.BootCommonConfigResDTO;
import com.bbdog.study.springboot.summary.demo.manager.models.BootCommonConfigBO;
import com.bbdog.study.springboot.summary.demo.manager.models.BootCommonConfigReqBO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *      boot通用配置转换类
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootCommonConfigConvert.java Date：2021/3/17 19:21 Version：1.0
 */
public class BootCommonConfigConvert {

    /**
     * BootCommonConfigReqDTO --> BootCommonConfigReqBO
     *
     * @param bootCommonConfigReqDTO BootCommonConfigReqDTO
     * @return BootCommonConfigReqBO
     */
    public static BootCommonConfigReqBO bootCommonConfigReqDtoToBO(BootCommonConfigReqDTO bootCommonConfigReqDTO){
        if (bootCommonConfigReqDTO == null) {
            return null;
        }
        BootCommonConfigReqBO bootCommonConfigReqBO = new BootCommonConfigReqBO();
        bootCommonConfigReqBO.setCommonKey(bootCommonConfigReqDTO.getCommonKey());
        List<BootCommonConfigDTO> bootCommonConfigDTOList = bootCommonConfigReqDTO.getBootCommonConfigDTOList();
        List<BootCommonConfigBO> bootCommonConfigBOList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(bootCommonConfigDTOList)) {
            bootCommonConfigDTOList.forEach(dto -> {
                BootCommonConfigBO bootCommonConfigBO = new BootCommonConfigBO();
                bootCommonConfigBO.setCommonType(dto.getCommonType());
                bootCommonConfigBO.setCommonKey(dto.getCommonKey());
                bootCommonConfigBO.setCommonValue(dto.getCommonValue());
                bootCommonConfigBOList.add(bootCommonConfigBO);
            });
        }
        bootCommonConfigReqBO.setBootCommonConfigBOList(bootCommonConfigBOList);
        return bootCommonConfigReqBO;
    }

    /**
     * BootCommonConfigBO --> BootCommonConfigResDTO
     *
     * @param bootCommonConfigBO BootCommonConfigBO
     * @return BootCommonConfigResDTO
     */
    public static BootCommonConfigResDTO bootCommonConfigResBoToDO(BootCommonConfigBO bootCommonConfigBO){
        if (bootCommonConfigBO == null) {
            return null;
        }
        BootCommonConfigResDTO bootCommonConfigResDTO = new BootCommonConfigResDTO();
        bootCommonConfigResDTO.setId(bootCommonConfigBO.getId());
        bootCommonConfigResDTO.setCommonType(bootCommonConfigBO.getCommonType());
        bootCommonConfigResDTO.setCommonKey(bootCommonConfigBO.getCommonKey());
        bootCommonConfigResDTO.setCommonValue(bootCommonConfigBO.getCommonValue());
        return bootCommonConfigResDTO;
    }

}
