package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.原子性;

/**
 * <p>
 *      这种多个子线程里用volatile不好对比，体现不了作用，需要使用不同的任务接口实现类才可以，也就是说MyRunnable04每次要不一样才好写代码
 *      这种舍弃掉
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestChildThreadVolatile.java Date：2022/6/24/024 1:08 Version：1.0
 */
public class TestChildThreadVolatile {

    public static void main(String[] args) {
        Runnable myRunnable = new MyRunnable04();
        for (int i = 0; i < 2; i++) {
            new Thread(myRunnable).start();
        }
    }

}

class MyRunnable04 implements Runnable {
    private volatile boolean runFlag = true;

    @Override
    public void run() {
        while (true) {
            System.out.println("线程：" + Thread.currentThread().getName() + "读取runFlag的值：" + runFlag);
            if (!runFlag) {
                System.out.println("线程：" + Thread.currentThread().getName() + "执行后的值" + runFlag);
                break;
            }
            runFlag = false;
        }
    }

}