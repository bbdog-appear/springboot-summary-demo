package com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.springboot;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MineSpringApplication {

    public static void run(Class<?> configClazz) {
        // 创建spring容器
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // 注册配置类，AnnotationConfigApplicationContext就相当于之前自己写的扫描路径，找Component注解，Scope，然后去createBean；即注册完配置类后，就返回一个bean工厂(spring上下文)
        context.register(configClazz);
        context.refresh();

        // 启动Tomcat
        startTomcat(context);

    }

    private static void startTomcat(WebApplicationContext applicationContext) {
        Tomcat tomcat = new Tomcat();

        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        Connector connector = new Connector();
        connector.setPort(8081);

        Engine engine = new StandardEngine();
        engine.setDefaultHost("localhost");

        Host host = new StandardHost();
        host.setName("localhost");

        String contextPath = "";
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);

        // 接收到所有的请求/*，都会交给DispatcherServlet处理，而DispatcherServlet会根据请求路径/test，找到对应的Controller进行处理；因为dispatcher去找的时候，肯定要通过spring容器去找，所以需要传一个spring上下文容器
        tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet(applicationContext));
        context.addServletMappingDecoded("/*", "dispatcher");

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

}
