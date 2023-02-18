package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.spring5;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.Resource;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
public class Application01 {

    /**
     * 测试spring容器，一些获取bean的操作
     *
     * @param args 参数
     */
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Application01.class, args);
        // 这里实际上是调用BeanFactory实现类的方法
        User user = context.getBean("user", User.class);
        System.out.println(user);

        // 获取专门管理单例对象的工厂或者说容器
        // 先通过反射获取该类的class对象，然后再获取属性对象，通过暴力反射拿到属性值
        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        // 这里是获取SpringBoot里的所有单例对象，即获取DefaultSingletonBeanRegistry的属性singletonObjects，它是一个map，
        // 里面放的都是单例对象，当服务启动时，spring会自动加载所有内置bean，将这些bean都加载到容器中
        // 通过遍历的结果来看，刚才配置的user，已经在容器中存在，这时候可以直接根据名字user从map中get到user对象。
        // 这里是通过属性对象点对象的方式获取对象里的属性值，即是从bean工厂对象里获取属性singletonObjects的值，获取到是一个hashMap
        // 而这个hashMap就是容器，spring启动的时候会加载所有bean并放入在这里。
        Map<String, Object> map = (Map<String, Object>) singletonObjects.get(beanFactory);
        map.forEach((key, value) -> {
//            System.out.println(key + ":" + value);
        });

//        System.out.println(context.getMessage("hi", null, Locale.CHINA));
//        System.out.println(context.getMessage("hi", null, Locale.ENGLISH));
//        System.out.println(context.getMessage("hi", null, Locale.JAPAN));

        Resource resource = context.getResource("classpath:pom.xml");
        System.out.println(resource);

        // 获取环境变量
        String java_home = context.getEnvironment().getProperty("java_home");
        System.out.println(java_home);

        // 发布事件源，是context发布这个事件。然后随便一个类的方法上加上@EventListener注解，然后就能拿到发布的事件对象消息，比如User类中的方法
        context.publishEvent(new MyUserEvent(context));

    }

}
