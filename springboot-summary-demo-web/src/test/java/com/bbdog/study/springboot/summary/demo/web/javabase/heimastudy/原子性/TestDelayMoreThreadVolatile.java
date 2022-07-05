package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.原子性;

/**
 * <p>
 *      测一下延迟调度时，多个线程中，其中某个线程改了变量后，其他线程是否能感知。延迟调度的话，可以感知的，多个线程之间相当于串行执行了，也就是说线程1要
 *      等待线程0执行完后，线程1再执行，这时候再去执行任务时，读到主内存中的runFlag已经线程0改变过的了，然后把这个改变过的值复制一个副本到
 *      线程1的工作内存中，那么线程1这时候读取到的就是修改后的值。所以只有并发编程中，才会出现多线程直接的变量不可见性，或者不同步的情况，原因是
 *      并发情况下，两个线程一开始全部都将主内存中的共享变量复制一个副本到各自的工作内存中，那么工作内存中的值就不会变了。但是如果有延迟的这种情况
 *      线程1过了1秒再去将主内存中的共享变量复制一个副本到工作内存，这时候主内存中已经是修改后的值。
 *      2、那么如果并发情况下，即这个没有sleep时，其中某个线程修改runFlag的值时，其他线程是基本上不会感知的。
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestDelayMoreThreadVolatile.java Date：2022/6/23/023 23:34 Version：1.0
 */
public class TestDelayMoreThreadVolatile {

    public static void main(String[] args) {
        Runnable myRunnable = new MyRunnable();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(myRunnable).start();
        }
    }

}

class MyRunnable implements Runnable {
    private boolean runFlag = true;

    @Override
    public void run() {
        System.out.println("线程：" + Thread.currentThread().getName() + "读取runFlag的值：" + runFlag);
        if (runFlag) {
            runFlag = false;
        } else {
            runFlag = true;
        }
        System.out.println("线程：" + Thread.currentThread().getName() + "执行后的值" + runFlag);
    }

}
