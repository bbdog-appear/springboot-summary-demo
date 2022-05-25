package com.bbdog.study.springboot.summary.demo.web.javabase.jucmy.juc定时任务;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *      测试定时任务
 *      1、run后可以看出service.scheduleAtFixedRate是通过开子线程的方式去执行任务，所以该定时任务相对于主线程是异步的。
 *      2、initialDelay参数是2秒，意思2秒后执行第一次任务，period是15的意思是两次任务的时间间隔是15秒。
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestScheduled.java Date：2022/5/24/024 15:42 Version：1.0
 */
@Slf4j
public class TestScheduled {

    private static final ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
    private static boolean runFlag = true;

    /**
     * 简单定时任务测试
     */
    public static void testScheduled() {
        System.out.println("开始，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        service.scheduleAtFixedRate(() -> {
            System.out.println("开始执行任务，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            for (int i = 0; i < 5; i++) {
                int f = 0;
                f+=i;
                System.out.println("for循环内部：" + f);
            }
            System.out.println("本次任务执行结束，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }, 2, 15, TimeUnit.SECONDS);
        String str = "拜拜";
        System.out.println("结束，" + str + "，时间" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    /**
     * 1、测试是否是同一个线程。
     * 可以看出如果任务之间的间隔时间较短时，或者说并发情况下，当核心线程数为10个时，会随机的使用10个线程资源中的某一些线程去执行并发的任务。
     * 比如线程1执行第1个任务，线程2执行第2个任务，那第一个任务执行完，线程被释放，执行第3个任务时，拿到的还是线程1去执行，这就是线程池的意义。
     * 所以该定时任务中，每次任务的执行，可能都不是同一个线程，都是属于是子线程，都是异步的。
     * 2、任务执行时间超过5秒会怎么样
     * 可以看出如果任务的处理时间超过period即任务的间隔时间，那么是取大的时间等待，即等待第1次任务完成，10秒后，再处理第2次任务.不会在5秒后
     * 处理第2次任务的。那么如果时间相同呢，即任务处理时间5秒，任务间隔时间也是5秒，这样第2次任务也只会执行一次的。
     */
    public static void testScheduled2() {
        System.out.println("开始，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        service.scheduleAtFixedRate(() -> {
            System.out.println("开始执行任务，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            System.out.println("线程名：" + Thread.currentThread().getName());
            for (int i = 0; i < 5; i++) {
                int f = 0;
                f+=i;
                System.out.println("for循环内部：" + f);
            }
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("本次任务执行结束，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }, 2, 5, TimeUnit.SECONDS);
        String str = "拜拜";
        System.out.println("结束，" + str + "，时间" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    public static void testScheduled3() {
        AtomicInteger countNum = new AtomicInteger();
        System.out.println("开始，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        service.scheduleAtFixedRate(() -> {
            if (runFlag) {
                System.out.println("开始执行任务，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("本次任务执行结束，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                if (countNum.getAndIncrement() >= 5) {
                    runFlag = false;
                    System.out.println("标识变为false");
                    service.shutdown();
                    System.out.println("结束调度任务");
                }
            }
        }, 2, 5, TimeUnit.SECONDS);
        System.out.println("结束，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    public static void testScheduled4() {
        AtomicInteger countNum = new AtomicInteger();
        System.out.println("开始，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        ScheduledFuture<?> future = service.scheduleAtFixedRate(() -> {
            if (runFlag) {
                System.out.println("开始执行任务，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("本次任务执行结束，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                if (countNum.getAndIncrement() >= 5) {
                    runFlag = false;
                    System.out.println("标识变为false");
                }
            }
        }, 2, 5, TimeUnit.SECONDS);
        if (!runFlag) {
            future.cancel(true);
        }
        System.out.println("结束，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    public static void testScheduled5() {
        AtomicInteger countNum = new AtomicInteger();
        System.out.println("开始，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        ScheduledFuture<?> future = service.scheduleAtFixedRate(() -> {
            System.out.println("开始执行任务，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("本次任务执行结束，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            if (countNum.getAndIncrement() >= 4) {
                runFlag = false;
            }
        }, 2, 3, TimeUnit.SECONDS);
        // 这种不行，因为线程池执行是异步的，所以这里永远进不去，除非阻塞一下。
        if (!runFlag) {
            log.info("进入future.cancel");
            future.cancel(true);
        }
        System.out.println("结束，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    public static void main(String[] args) {
        testScheduled5();
    }

}
