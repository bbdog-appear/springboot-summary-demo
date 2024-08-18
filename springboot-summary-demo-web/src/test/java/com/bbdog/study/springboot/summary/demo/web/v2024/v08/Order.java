package com.bbdog.study.springboot.summary.demo.web.v2024.v08;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Order implements Delayed {

    @Override
    public long getDelay(TimeUnit unit) {
        return 3000;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }

}
