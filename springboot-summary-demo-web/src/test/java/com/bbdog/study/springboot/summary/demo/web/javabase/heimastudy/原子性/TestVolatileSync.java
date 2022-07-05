package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.原子性;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *      测试并发的多线程下，变量的可见性问题
 *      2、当子线程有延迟时，那么主线程肯定先执行，那么主线程一开始就读到runFlag的值为true，并且不会变。
 *        当子线程没有延迟时，那么会出现概率性，如果子线程先执行把runFlag的值改了，这时候主线程再执行，会读到主内存中最新修改的值作为副本放在工作内存。
 *      所以之前的例子里，给子线程睡一会的情况下有延迟，主线程是一定不会获取到修改后的值。
 *      3、所以在子线程有延迟的情况下，给共享变量加volatile关键字是有作用的，当一个线程修改时，另一个线程会从主存中同步最新的值
 *      4、那为什么多个子线程中，其中一个子线程修改变量，
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestVolatileSync.java Date：2022/6/24/024 0:27 Version：1.0
 */
@Getter
@Setter
public class TestVolatileSync implements Runnable{

    private volatile boolean runFlag = true;

    @Override
    public void run() {
        System.out.println("线程：" + Thread.currentThread().getName() + "读取runFlag的值：" + runFlag);
        if (runFlag) {
            runFlag = false;
        } else {
            runFlag = true;
        }
        System.out.println("线程：" + Thread.currentThread().getName() + "执行后的值" + runFlag);
    }

}

class VisibilityVar {
    public static void main(String[] args) {
        TestVolatileSync testVolatileSync = new TestVolatileSync();
        new Thread(testVolatileSync).start();

        while (true) {
            boolean runFlag = testVolatileSync.isRunFlag();
            if (!runFlag) {
                System.out.println("主线程拿runFlag：" + runFlag);
                break;
            }
        }
    }
}


