package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.死锁;

/**
 * <p>
 *      1、测试必然死锁的代码
 *      2、死锁形成的条件，其中主要是必然有两个线程，每个线程各自持有不同的资源，并各自请求对方的资源
 *      3、那么定义两个资源，和两个线程
 *      4、其中启动main方法后，线程a先抢到cpu，执行到synchronized (reSources01)，然后睡了一秒，那么这时候线程b肯定抢到cpu
 *      并执行synchronized (reSources02)，那么线程a定时等待后被唤醒，执行到synchronized (reSources02)时，发现锁已经被
 *      线程b占用，a线程就会阻塞，等待锁02释放，那么同时线程b定时等待后被唤醒，执行到synchronized (reSources01)时，发现锁还是
 *      被线程a占用，因为线程a的锁的代码块没有执行完，01资源(锁)就不会被释放，所以线程b就会阻塞，等待锁01释放。这样两边都阻塞住了，
 *      都不会释放，就形成了死锁。
 *      5、那么在实际的生产中，两个线程不一定是代码new出来去互相抢锁，而是存在这种情况，两个应用的各自接口在执行时，这肯定是两个线程，
 *      去同时更新数据库中的两条数据，但是两个线程更新顺序是相反的，即线程a的事务里，有两步操作，第一步更新01数据，第二步更新02数据。
 *      线程b的事务里，也有两步操作，第一步更新02数据，第二步更新01数据。那么当a、b线程各自执行了第一步后，a线程执行第二步时，
 *      更新02数据，但是发现02数据是线程b持有的，因为线程b的事务没有执行完(即线程b拿不到数据01)，所以线程b一直控制着02数据，行锁锁住不会释放。
 *      那么这样的话，线程a和线程b都因为数据库行锁阻塞了，就形成了死锁。
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestDeadLock.java Date：2022/6/21/021 23:29 Version：1.0
 */
public class TestDeadLock {

    private static final Object reSources01 = new Object();
    private static final Object reSources02 = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (reSources01) {
                    System.out.println("线程a占用资源01，并请求资源02");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (reSources02) {
                        System.out.println("线程a成功占用资源02");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (reSources02) {
                    System.out.println("线程b占用资源02，并请求资源01");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (reSources01) {
                        System.out.println("线程b成功占用资源01");
                    }
                }
            }
        }).start();
    }

}
