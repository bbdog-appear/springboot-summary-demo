package com.bbdog.study.springboot.summary.demo.web.datastructure.queue;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *      阻塞队列的用法
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootDelayQueue.java Date：2021/8/9 18:41 Version：1.0
 */
@Slf4j
public class BootDelayQueue {

    private static final DelayQueue<DelayTask> delayQueue = new DelayQueue<>();

    public static void main(String[] args) {
        initConsumer();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        delayQueue.add(new DelayTask(1000, "task1"));
        delayQueue.add(new DelayTask(2000, "task2"));
        delayQueue.add(new DelayTask(3000, "task3"));
        delayQueue.add(new DelayTask(4000, "task4"));
        delayQueue.add(new DelayTask(5000, "task5"));
    }

    private static void initConsumer() {
        Runnable task = () -> {
            while (true) {
                try {
                    log.info("尝试获取延迟队列中的任务{}", LocalDateTime.now());
                    DelayTask take = delayQueue.take();
                    log.info("获取结果：{}", take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(task).start();
    }

}
