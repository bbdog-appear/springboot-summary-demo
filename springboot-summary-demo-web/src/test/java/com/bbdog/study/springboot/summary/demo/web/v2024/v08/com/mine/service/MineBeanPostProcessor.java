package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.mine.service;

import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.BeanPostProcessor;
import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.Component;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

@Slf4j
@Component("mineBeanPostProcessor")
public class MineBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        log.info("初始化前");
        if ("userService".equals(beanName)) {
            ((UserService) bean).setRemark("淘宝用户");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        log.info("初始化后");
        // springAop把这块做成了切面，详见BootLogAspect类；即并不是像这里写死了是payService类，而是可以通过自定义注解拦截了目标类的方法，然后执行了切面中的业务逻辑
        if ("payService".equals(beanName)) {
            // 1.使用jdk的动态代理类生成动态代理对象，可见jdk的动态代理是通过实现目标类的接口，然后通过反射机制调用目标类的方法；而cglib的动态代理是通过继承目标类，然后通过反射机制调用目标类的方法
            // 2.生成payService代理对象并放入容器中，此时还未执行代理方法，当程序执行该代理类方法时，调用代理方法；即只要aop切了某些方法或切的是注解，原来的目标bean就已经不是它本身了，就是变成代理对象放入容器中
            // 3.此时生成的代理bean，属于是在bean初始化后做的操作，此时还未放入单例池中。放入单例池后，后续程序代码中获取接口并执行该方法时，就会执行代理方法。
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) -> {
                // 执行前置
                log.info("aop切面，执行前置处理,入参信息:{}", args);
                // 执行目标方法，获取目标方法的返回值
                return method.invoke(bean, args);
            });
        }
        return bean;
    }

}
