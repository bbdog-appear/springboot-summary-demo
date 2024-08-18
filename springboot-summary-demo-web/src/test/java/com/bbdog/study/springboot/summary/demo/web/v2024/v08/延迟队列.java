package com.bbdog.study.springboot.summary.demo.web.v2024.v08;

import com.bbdog.study.springboot.summary.demo.web.SpringbootSummaryDemoWebApplication;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class 延迟队列 extends SpringbootSummaryDemoWebApplication {

    /**
     * 使用jdk自带的DelayQueue延迟队列，实现超时订单自动关闭功能/实现到达配置的购汇时间后发起购汇(另一种方法实现，搞一个配置表，配置12小时后购汇，每生成一个申请单后，把当前时间+配置的12小时，记录时间在worksheet中，然后定时任务轮询，如果到达当前时间，则发起购汇。跟这个原理一模一样)
     * 缺点：不支持分布式
     */
    @Test
    public void testRedisAutoConfiguration() {
        DelayQueue<Order> queue = new DelayQueue<>();
        // 延迟队列里添加订单
        this.addOrder(queue);
        // 启动一个线程，取延迟消息
        this.execute(queue);
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 队列中均达到超时时间，并被take取出后，延迟队列的元素就会被移除，最后是一个空的延迟队列
        log.info("=======结果是：{}", queue);
    }

    /**
     * 启动一个线程，取延迟消息
     *
     * @param queue 延迟队列
     */
    private void execute(DelayQueue<Order> queue) {
        Executors.newSingleThreadExecutor().execute(() -> {
            while (true) {
                try {
                    // 等待队列中的元素达到delay时间后才会返回该元素,阻塞式
                    Order order = queue.take();
                    // 处理超时的订单
                    log.info("=======订单号：{}", order.getOrderId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void addOrder(DelayQueue<Order> queue) {
        Order order = new Order("110111001", 8000);
        queue.put(order);
        Order order2 = new Order("110111002", 15000);
        queue.put(order2);
        Order order3 = new Order("110111003", 10000);
        queue.put(order3);
    }

    @Data
    public class Order implements Delayed {

        // 订单处理的延迟时间
        private long delayTime;
        // 过期时间
        private long expireTime;
        // 订单ID
        private String orderId;

        public Order(String orderId, long delayTime) {
            this.orderId = orderId;
            this.delayTime = delayTime;
            this.expireTime = System.currentTimeMillis() + delayTime;
        }

        /**
         * 如果到达超时时间，返回负数
         *
         * @param unit 单位
         * @return 延迟队列DelayQueue的take()方法，判断该方法返回负数时，take方法会将该order元素取出
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(expireTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        /**
         * 比较方法，给延迟队列里的元素排序的
         *
         * @param o 每个元素
         * @return 比较结果
         */
        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
                // 小于排后面
                return -1;
            }
            if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
                // 大于排前面
                return 1;
            }
            return 0;
        }

    }

}
