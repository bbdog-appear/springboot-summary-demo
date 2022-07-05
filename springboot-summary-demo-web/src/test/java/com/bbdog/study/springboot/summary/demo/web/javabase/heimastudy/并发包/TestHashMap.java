package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.并发包;

import java.util.HashMap;

/**
 * <p>
 *      测试hashMap的线程不安全性
 *      两个线程共享map，并发情况下，两个线程操作map，使用put放值，会造成map数据丢失，所以是线程不安全的
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestHashMap.java Date：2022/6/28/028 0:09 Version：1.0
 */
public class TestHashMap {

    private static final HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        TestHashMap testHashMap = new TestHashMap();
        testHashMap.testHashMap();
    }

    void testHashMap() {
        Thread1A a1 = new Thread1A();
        Thread1A a2 = new Thread1A();
        a1.setName("线程1-");
        a2.setName("线程2-");
        a1.start();
        a2.start();

        // 这里要保证两个线程都跑完，才能跑主线程，可以用join方法
        // 其中join方法是将线程加入cpu竞争的行列里，a1 a2都会抢cpu资源，所以a1 a2是并发执行的，然后主线程会阻塞，直到两个线程都跑完
        try {
            a1.join();
            a2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Map的大小：" + map.size());
    }

    /**
     * 定义一个内部类的原因是，要使用外部类中的成员变量map
     */
    class Thread1A extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 500000; i++) {
                map.put(this.getName() + (i + 1), this.getName() + i + 1);
            }
            System.out.println(this.getName() + "结束！");
        }
    }

}
