package com.bbdog.study.springboot.summary.demo.web.jvm.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * <p>
 *      测试jdk动态代理
 *      1、调用Proxy.newProxyInstance会生成给定接口的动态代理类和对象，即:iVehicle对象
 *      2、当代理类调用其方法时，即iVehicle.run()，则会调用invocationHandler中的invoke方法。其中invoke方法的Proxy对象
 *      就是动态代理对象iVehicle。
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestDynamicProxy.java Date：2021/7/13 16:09 Version：1.0
 */
public class TestDynamicProxy {

    public static void main(String[] args) {
        IVehicle car = new Car();
        IVehicle iVehicle = (IVehicle) Proxy.newProxyInstance(car.getClass().getClassLoader(),
                Car.class.getInterfaces(), new BootInvocationHandler(car));
        // iVehicle是代理car对象，调用run方法时，自动执行invocationHandler中的invoke方法
        iVehicle.run();
        // 打印出来是代理对象 com.sun.proxy.$Proxy0
        System.out.println(iVehicle.getClass());
    }

}
