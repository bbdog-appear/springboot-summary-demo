package com.bbdog.study.springboot.summary.demo.web.v2024.v08.jmm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestJmm {

    /**
     * 加volatile后，主内存中变量的修改会立马通知到其他线程
     */
    private static volatile boolean flag = false;

    /**
     * 1.线程2将主内存的变量flag值改为true，但是此时线程1对flag的变化不可见，还是false，一直在循环，不会打印下面那句话
     * 2.线程2只是改变线程副本的值
     *
     * 3.如果加了volatile关键字，那么线程2对主内存的修改后，会立马通知到其他线程，即线程1的变量副本也会跟着变；保证多线程之间变量副本的可见性
     *
     * 4.volatile的原理？
     *
     *
     * @param args 参数
     */
    public static void main(String[] args){
        log.info("start main");
        new Thread(() -> {
            log.info("主线程执行开始");
            while (!flag) {

            }
            log.info("flag已改变=========");
        }).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        childThread();
    }

    private static void childThread() {
        new Thread(() -> {
            log.info("子线程执行开始");
            flag = true;
            log.info("子线程执行结束");
        }).start();
    }

}
