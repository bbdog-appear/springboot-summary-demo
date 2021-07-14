package com.bbdog.study.springboot.summary.demo.web.jvm.proxy.dynamicProxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>
 *      处理类的实现
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootInvocationHandler.java Date：2021/7/13 15:48 Version：1.0
 */
@Slf4j
public class BootInvocationHandler implements InvocationHandler {

    private final IVehicle iVehicle;

    public BootInvocationHandler(IVehicle iVehicle){
        this.iVehicle = iVehicle;
    }

    /**
     * 实现处理类的方法
     *
     * @param proxy 就是代理对象，Proxy.newProxyInstance方法的返回对象
     * @param method 调用的方法
     * @param args 方法中的参数
     * @return 调用方法的结果
     * @throws Throwable 抛出异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("==============method invoke before");
        Object invoke = method.invoke(iVehicle, args);
        log.info("==============method invoke after");
        return invoke;
    }

}
