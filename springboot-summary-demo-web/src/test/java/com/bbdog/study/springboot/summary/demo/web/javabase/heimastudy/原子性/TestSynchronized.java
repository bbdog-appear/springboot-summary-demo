package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.原子性;

/**
 * <p>
 *      测试并发的多线程下，变量的可见性问题
 *      1、使用synchronized，5个线程同时执行，然后都拿到主内存中的runFlag，并复制到工作内存，都是true。这时线程1抢到锁
 *      将runFlag改为false，然后释放锁。然后线程0抢到锁，再执行synchronized时会清空工作内存中的旧值，然后读取主内存中
 *      最新的值复制一个副本到工作内存，所以线程0执行时，读到的已经是改变后的值。
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestSynchronized.java Date：2022/6/24/024 0:45 Version：1.0
 */
public class TestSynchronized {

    public static void main(String[] args) {
        Runnable myRunnable = new MyRunnable02();
        for (int i = 0; i < 5; i++) {
            new Thread(myRunnable).start();
        }
    }

}

class MyRunnable02 implements Runnable {
    private boolean runFlag = true;

    @Override
    public void run() {
        synchronized (MyRunnable02.class) {
            System.out.println("线程：" + Thread.currentThread().getName() + "读取runFlag的值：" + runFlag);
            if (runFlag) {
                runFlag = false;
            } else {
                runFlag = true;
            }
            System.out.println("线程：" + Thread.currentThread().getName() + "执行后的值" + runFlag);
        }
    }

}
