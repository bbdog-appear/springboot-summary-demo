package com.bbdog.study.springboot.summary.demo.web.javabase;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：Singleton.java Date：2021/12/20 18:23 Version：1.0
 */
public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance(){
        if(null != instance) return instance;
        synchronized (Singleton.class){
            if (null == instance){
                instance = new Singleton();
            }
        }
        return instance;
    }

}
