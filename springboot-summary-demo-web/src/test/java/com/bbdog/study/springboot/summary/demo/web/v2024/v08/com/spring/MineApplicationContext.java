package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 容器类
 * 1.注解：ComponentScan、Component、Scope
 * 2.BeanPostProcessor接口：初始化之前、初始化之后、销毁之前、销毁之后
 * 3.容器中会缓存beanDefinition对象、beanPostProcessor对象、单例池对象
 */
public class MineApplicationContext {

    private Class<?> configClass;
    /**
     * 单例池
     */
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    /**
     * 将beanDefinition对象缓存起来
     */
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    /**
     * 将beanPostProcessor对象缓存起来
     */
    private List<BeanPostProcessor> beanPostProcessors = new CopyOnWriteArrayList<>();


    public MineApplicationContext(Class<?> configClass) {
        this.configClass = configClass;
        // 1.ComponentScan注解扫描路径-->获取所有类型的类-->创建beanDefinition对象并放入map缓存(此时bean定义map中存了所有bean定义信息)
        scan(configClass);

        // 2.spring容器启动时需要将所有的单例bean对象创建出来
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            if ("singleton".equals(beanDefinition.getScope())) {
                // 创建bean对象
                singletonObjects.put(beanName, createBean(beanName, beanDefinition));
            }

        }

    }

    /**
     * 简单的创建bean过程(此时属性还未注入)
     * spring中的创建bean过程还有其他内容，后面再说
     *
     * @param beanDefinition bean定义对象
     * @param beanName bean名称
     * @return bean对象
     */
    public Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class<?> clazz = beanDefinition.getClazz();
        try {
            // 这里只是创建对象，属性还未注入
            Object instance = clazz.getDeclaredConstructor().newInstance();

            // 依赖注入
            for (Field declaredField : clazz.getDeclaredFields()) {
                // 判断当前属性是否被Autowired注解
                if (declaredField.isAnnotationPresent(Autowired.class)) {
                    // 给当前对象的属性赋值
                    declaredField.setAccessible(true);
                    // TODO: 2024/8/25/025 这里get该对象中属性对应的bean对象实例，可能存在先后顺序问题，这里会获取不到，spring中会有处理，即等待单例池singletonObjects全部创建完，再进行依赖注入，即单例池每次只实例化对象的一半，即只实例化这个对象，属性等后面再注入
                    declaredField.set(instance, getBean(declaredField.getName()));
                }
            }

            // Aware回调：如果实现了BeanNameAware接口，则调用setBeanName方法
            if (instance instanceof BeanNameAware) {
                ((BeanNameAware) instance).setBeanName(beanName);
            }

            // 初始化前
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                // 传入的bean实例对象和返回的对象不一定是同一个对象
                instance = beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
            }

            // 初始化InitializingBean
            if (instance instanceof InitializingBean) {
                ((InitializingBean) instance).afterPropertiesSet();
            }

            // 初始化后
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                instance = beanPostProcessor.postProcessAfterInitialization(instance, beanName);
            }


            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 1.扫描
     * 2.获取beanDefinition对象并放入map缓存中
     *
     * @param configClass 配置类class对象
     */
    private void scan(Class<?> configClass) {
        // 1. 扫描配置类
        ComponentScan componentScan = configClass.getDeclaredAnnotation(ComponentScan.class);
        String path = componentScan.value().replace(".", "/");

        // 拿到AppClassLoader应用类加载器，获取classpath路径 (Bootstrap-->jre/lib; Ext-->jre/ext/lib; App-->classpath)
        ClassLoader classLoader = MineApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(path);
        File directory = new File(Objects.requireNonNull(resource).getFile());

        if (directory.isDirectory()) {

            // 遍历扫描路径下所有类
            for (File file : Objects.requireNonNull(directory.listFiles())) {

                String fileName = file.getAbsolutePath();
                if (fileName.endsWith(".class")) {
                    // 截取全类名
                    String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class")).replace("\\", ".");

                    try {
                        // 类加载器加载类，得到类的class对象，如UserService类的class对象
                        Class<?> clazz = classLoader.loadClass(className);

                        if (clazz.isAnnotationPresent(Component.class)) {

                            // 判断是BeanPostProcessor接口类型(此时还未生成bean对象，不能用instanceof)，使用isAssignableFrom当前的类class是否实现了该接口判断
                            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                // TODO: 2024/8/25/025 这里不严谨，应该用spring的getBean获取bean对象，但是在这里还没有实例化bean
                                BeanPostProcessor beanPostProcessor = (BeanPostProcessor) clazz.getDeclaredConstructor().newInstance();
                                // 将beanPostProcessor对象放入缓存
                                beanPostProcessors.add(beanPostProcessor);
                            }


                            // 获取bean的name或者说id
                            String beanName = clazz.getDeclaredAnnotation(Component.class).value();

                            // bean定义对象，定义bean的类型和作用域(单例或原型prototype)等;每个bean定义对象与bean的class对象同一个维度
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setClazz(clazz);
                            if (clazz.isAnnotationPresent(Scope.class)) {
                                Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                                beanDefinition.setScope(scopeAnnotation.value());
                            } else {
                                beanDefinition.setScope("singleton");
                            }

                            // 将bean定义对象缓存到map中
                            beanDefinitionMap.put(beanName, beanDefinition);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("扫描异常");
                    }
                }
            }
        }
    }

    public Object getBean(String beanName) {
        if (beanDefinitionMap.containsKey(beanName)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if ("singleton".equals(beanDefinition.getScope())) {
                // 单例bean，直接从单例map中返回bean对象
                return singletonObjects.get(beanName);
            } else {
                // 原型prototype bean，每次创建bean对象
                return createBean(beanName, beanDefinition);
            }

        } else {
            throw new NullPointerException("不存在对应的bean");
        }
    }

}
