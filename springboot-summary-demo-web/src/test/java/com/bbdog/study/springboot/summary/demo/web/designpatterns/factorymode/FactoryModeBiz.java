package com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode;

import org.springframework.stereotype.Component;

/**
 * <p>
 *      工厂模式Biz类(其实不是真正的工厂模式，因为没有定义工厂类，而是又枚举的方式代替的，原理差不多)
 *      1、这里方法入参拿到的就是真正的业务bean，调用相应的方法。虽然通过spring每次获取的都是同一个业务bean，但是调用createData方法时，意思
 *      是具体做什么事，而这里做的事是每次都是new一个新的对象。如果是该业务bean中的成员变量，则每次都是同一个成员变量。
 *      2、如果这里不用接口去规范每个奖励类型，则需要写三个if else，并且每个if里需要一大串业务代码。
 *      3、工厂模式的好处就相当于一个房子，厨房和卧室放它应该放的东西，这里就不应该把三种业务类型的逻辑写在一个类(房间)中，需要分开写。
 * </p>
 *
 * @author cheng.wang
 * @version Id：FactoryModeBiz.java Date：2021/4/26 18:49 Version：1.0
 */
@Component
public class FactoryModeBiz<T, D> {

    public void sendReward(BootInterface<T, D> bootInterface){
        T data = bootInterface.createData();
        D message = bootInterface.createMessage();
        bootInterface.sendReward(data, message);
    }

}
