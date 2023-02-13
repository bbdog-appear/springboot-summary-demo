package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.代理相关;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：动态代理类.java Date：2023/2/13 16:33 Version：1.0
 */
public class 动态代理生成类 {

    public static void main(String[] args) {
        ITarget target = new Target();
        // 将目标类的class对象传入，复制生成一个代理类，然后用这个类加载器加载代理类，生成代理类的class对象，然后生产代理类对象。
        // 其中invoke是代理类的反射方法，可以知道到时候调用方法时，是先通过反射调用代理类的方法，然后method.invoke(target, args);是通过
        // 反射调用目标类原来的业务方法，即反向代理可以在原来目标类方法的基础上添加自己独有的逻辑代码
        // 肯定还有一个类，是需要传入ITarget接口的引用的，然后方法里肯定会接口调用：interface.f1()，那么到时候把下面的这个代理对象传入，
        // 就可以执行代理类中的f1方法，只不过这种是通过反射调用的。最后看到调用时先进入代理类的方法，输出后再调用原来目标类的方法，再输出
        ITarget proxyObject = (ITarget) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 添加代理类自己的逻辑控制代码
                System.out.println("进入了代理类的方法中");
                return method.invoke(target, args);
            }
        });
        // 这里其实可以写在一个类的方法里，通过多态的写法，只要ITarget的引用即可，到时候传入的是真正的代理对象proxyObject，再调用f1方法。
        proxyObject.f1();
    }

}
