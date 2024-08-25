package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring;

/**
 * 模拟spring提供的扩展接口
 */
public interface BeanPostProcessor {

    /**
     * 1.初始化之前做的事
     * 2.spring创建任何一个bean时都会调用这个方法
     * 3.跟AOP差不多，前置做什么，后置做什么
     *
     * @param bean bean实例对象
     * @param beanName bean名称
     * @return bean实例对象
     */
    Object postProcessBeforeInitialization(Object bean, String beanName);


    /**
     * 1.初始化之后做的事
     * 2.spring创建任何一个bean时都会调用这个方法
     *
     * @param bean bean实例对象
     * @param beanName bean名称
     * @return bean实例对象
     */
    Object postProcessAfterInitialization(Object bean, String beanName);

}
