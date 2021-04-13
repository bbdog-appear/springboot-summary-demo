package com.bbdog.study.springboot.summary.demo.web.sourceTest.generic;

/**
 * <p>
 *      泛型测试
 * </p>
 *
 * @author cheng.wang
 * @version Id：GenericTest.java Date：2021/3/31 16:03 Version：1.0
 */
public class GenericTest {

    /**
     * 不指定类型
     */
    public void noSpecifyType(){
        BootGeneric bootGeneric = new BootGeneric();
        GenericVO genericVO = new GenericVO();
        bootGeneric.setData(genericVO);
        // 需要强制类型转换
        GenericVO data = (GenericVO) bootGeneric.getData();
    }

    /**
     * 指定类型
     */
    public void specifyType(){
        BootGeneric<GenericVO> bootGeneric = new BootGeneric<>();
        GenericVO genericVO = new GenericVO();
        bootGeneric.setData(genericVO);
        // 不需要强制类型转换
        GenericVO data = bootGeneric.getData();
    }

}
