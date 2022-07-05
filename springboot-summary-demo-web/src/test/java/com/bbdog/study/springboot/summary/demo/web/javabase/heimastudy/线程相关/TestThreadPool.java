package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.线程相关;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <p>
 *      测试线程池
 *      线程池在java中的代表类：ExecutorService
 *      java在Executors类下提供了一个静态方法，得到线程池对象：Executors.newFixedThreadPool(1);创建一个线程池ExecutorService返回
 *      ExecutorService提交线程任务对象执行的方法：Future<?> submit(Runnable task)，提交一个runnable任务对象给线程池执行
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestThreadPool.java Date：2022/6/20/020 23:46 Version：1.0
 */
public class TestThreadPool {

    /**
     * 创建一个线程池ExecutorService，即执行服务的意思
     */
    private final ExecutorService service = Executors.newFixedThreadPool(1);

    /**
     * 线程池的使用和说明
     */
    void testThreadPool() {
        for (int i = 0; i < 5; i++) {
            Future<?> future = service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("实现了任务接口的实现类任务方法");
                    System.out.println("每个实现类任务都会被丢到线程池-任务队列中，线程池-工作线程会执行队列中任务");
                }
            });
        }
    }

}
