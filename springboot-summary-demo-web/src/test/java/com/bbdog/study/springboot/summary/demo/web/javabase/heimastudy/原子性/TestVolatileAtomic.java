package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.原子性;

/**
 * <p>
 *      测试多个线程操作共享变量，由于不可见性，所以当一个线程改变count的值时，其他线程不一定得到最新的值去累加。
 *      然后考虑用volatile去保证可见性，但是呢这个count++不是原子性的，因为多个线程中，可能两个线程都读到10，然后两个线程都执行+1，结果
 *      都是11，这就少加了。所以这是两步操作，就是先读再写。如果不能保证原子性，那就有问题。然后加volatile后，其实并不能保证原子性的，所以
 *      要加锁
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestVolatileAtomic.java Date：2022/6/24/024 1:24 Version：1.0
 */
public class TestVolatileAtomic {

    public static void main(String[] args) {
        Runnable myRun = new MyRunnable06();
        for (int i = 1; i <= 100; i++) {
            // 启动100个线程，执行100次任务，最终希望的结果是10000，但是并不是，因为这个不是原子性的
            new Thread(myRun).start();
        }
    }

}

class MyRunnable06 implements Runnable {

    private volatile int count;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            count++;
            System.out.println("count =============>" + count);
        }
    }
}
