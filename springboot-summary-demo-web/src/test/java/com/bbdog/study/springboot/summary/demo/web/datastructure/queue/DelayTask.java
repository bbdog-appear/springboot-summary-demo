package com.bbdog.study.springboot.summary.demo.web.datastructure.queue;

import lombok.Data;

import java.time.Instant;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *      延时任务
 * </p>
 *
 * @author cheng.wang
 * @version Id：DelayTask.java Date：2021/8/9 18:48 Version：1.0
 */
@Data
public class DelayTask implements Delayed {

    /**
     * 延迟时间
     */
    private final long delay;
    /**
     * 到期时间
     */
    private final long expire;
    /**
     * 数据
     */
    private final String msg;
    /**
     * 创建时间
     */
    private final long now;

    public DelayTask(long delay, String msg) {
        this.delay = delay;
        this.msg = msg;
        this.now = Instant.now().toEpochMilli();
        this.expire = now + delay;
    }

    /**
     * 获取延迟时间
     *
     * @param unit 单位对象
     * @return 延迟时间
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expire - Instant.now().toEpochMilli(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == this) {
            return 0;
        }
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

}
