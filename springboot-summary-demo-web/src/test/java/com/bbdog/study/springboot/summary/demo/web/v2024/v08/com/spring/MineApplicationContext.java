package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器类
 * 注解：ComponentScan、Component、Scope
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
                singletonObjects.put(beanName, createBean(beanDefinition));
            }

        }

    }

    /**
     * 简单的创建bean过程
     * spring中的创建bean过程还有其他内容，后面再说
     *
     * @param beanDefinition bean定义对象
     * @return bean对象
     */
    public Object createBean(BeanDefinition beanDefinition) {
        Class<?> clazz = beanDefinition.getClazz();
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
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
                return createBean(beanDefinition);
            }

        } else {
            throw new NullPointerException("不存在对应的bean");
        }
    }

}
