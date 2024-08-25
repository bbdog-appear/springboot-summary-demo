package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring;

/**
 * 表示的是bean的一些属性：例如UserService这个类，的类型、是否单例
 * 比如bean是单例还是原型的
 */
public class BeanDefinition {

    /**
     * 当前bean的类型
     */
    private Class<?> clazz;
    /**
     * 当前bean的作用域
     */
    private String scope;

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
