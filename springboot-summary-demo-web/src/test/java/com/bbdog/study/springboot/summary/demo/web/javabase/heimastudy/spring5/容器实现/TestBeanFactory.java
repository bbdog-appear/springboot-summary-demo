package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.spring5.容器实现;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.expression.BeanFactoryAccessor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestBeanFactory.java date：2023/2/19/0190:56 Version：1.0
 */
public class TestBeanFactory {

    /**
     * 这个代码其实就在模拟BeanFactory如何初始化的，这个代码可能在spring里已经实现好了，我们现在就是简单的重复一下他的流程，也就是说将bean放入BeanFactory里
     *
     * @param args 入参
     */
    public static void main(String[] args) {
        // 测试BeanFactory的实现，最主要的类就是这个DefaultListableBeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // bean的定义(class，scope，初始化，销毁)，定义了bean的描述信息，那么BeanFactory就知道这个bean有哪些特点了

        // 这一步的意思将来是把Config这个类交给BeanFactory管理，那么这时候BeanFactory里就加载了这个配置类，然后实例化里面的配置bean放入
        // 容器中，还可以设置这个单例还是多例等等，最后获取bean定义对象，即已经把bean定义对象创建好了，其实这一步就类似我们xml中，去读取xml文件
        // 然后使用BeanFactory去加载配置文件，即把xml里的bean都装到bean工厂里
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Config.class).
                setScope(BeanDefinition.SCOPE_SINGLETON).getBeanDefinition();
        // 使用bean工厂注册一个bean定义对象，那么bean工厂里就有个Config的bean，它是单例的。
        beanFactory.registerBeanDefinition("config", beanDefinition);

        // bean工厂已经注册了bean定义对象后，就可以从这个容器(工厂)中获取bean了
        // 获取所有定义bean的名字，目前就一个config，因为这时候BeanFactory现在还没解析@Configuration注解和@Bean注解，我们知道，
        // 要想解析，必须要扫描注解。但是BeanFactory不具备解析注解的能力
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("=============================================================");

        // 给BeanFactory里添加一些常用的后置处理器，处理器的作用是对BeanFactory功能的一个扩展，也就是说后置处理器就可以解析
        // configuration、bean注解，即我们现在看的是原理，比如之前为什么配置@ComponentScan就可以扫描这些注解，因为有个类的封装
        // 方法里做了这个功能，那么这个类就是下面这行代码，可以点进去看看，到底做了什么才会解析注解。
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);

        // 加完后置处理器后才看BeanFactory的bean，就变多了，但这时还是没有Bean1的对象，只是多了一些spring内置的后处理器。也就是说
        // 上面的步骤就是给BeanFactory里注册了四个后处理器，每个后处理器都会有不同的功能。
        /*
        *   org.springframework.context.annotation.internalConfigurationAnnotationProcessor
            org.springframework.context.annotation.internalAutowiredAnnotationProcessor
            org.springframework.context.annotation.internalCommonAnnotationProcessor
            org.springframework.context.event.internalEventListenerProcessor
            org.springframework.context.event.internalEventListenerFactory
        * */
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        // internalConfigurationAnnotationProcessor第一个后处理器，就是去处理@Configuration注解的，以及解析里面的@Bean注解的，
        // 通俗的说就是internalConfigurationAnnotationProcessor后处理器里面就是封装了怎么解析注解的代码，比如拿到这些bean对应的
        // 类和方法，然后将方法中的对象放入容器中等等，还是跟之前一样，注解只是一种配置值的形式也可以认为是一种标识，真正实现功能的代码是在
        // 比如这里的后处理器里完成的，其中肯定有读取注解，然后把这些bean信息补充到bean工厂里，我们可以进入这些处理器看源代码
        // 虽然将bean工厂的后处理器加入了BeanFactory，但是这些处理器还没工作，即还没调用方法呢。这里获取了所有bean工厂的后处理器，
        // 根据接口类型获得多个bean工厂后处理器(BeanFactoryPostProcessor)的实现类。拿到bean的对象就要获取value
        Collection<BeanFactoryPostProcessor> values = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values();
        // 拿到每一个bean工厂后处理器，执行bean工厂的处理器，当执行到internalConfigurationAnnotationProcessor时，就会把下面的Bean2解析了
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : values) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
        System.out.println("=============================================================");
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

    }

    @Configuration
    static class Config {

        @Bean
        public Bean1 bean1() {
            return new Bean1();
        }

        @Bean
        public Bean2 bean2() {
            return new Bean2();
        }

    }

    static class Bean1 {

        @Autowired
        private Bean2 bean2;

        public Bean1() {
            System.out.println("bean1的构造方法");
        }

        public Bean2 getBean2() {
            return bean2;
        }
    }

    static class Bean2 {

        public Bean2() {
            System.out.println("bean2的构造方法");
        }

    }

}
