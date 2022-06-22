package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.volatile关键字;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *      1、以下程序，测试两个线程中的某个线程修改变量的值后，另一个线程是否可以拿到最新值。答案是拿不到的，因为如果是同一个线程，那同一个
 *      对象TestVolatile t，其中同一个线程中的某一步骤改了t对象里的实例变量值，执行到下一步时，拿t对象里的实例变量flag肯定已经改了。
 *      但是两个线程就不一样了，因为两个线程分别对应两个虚拟机栈，就相当于两个不同的栈空间的变量指向堆中的对象，其中有个线程改了后，另外一个
 *      线程不能感知到对象中的变量发生了变化。
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestVolatile.java Date：2022/6/22/022 22:18 Version：1.0
 */
@Getter
@Setter
public class TestVolatile extends Thread{

    private boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = " + flag);
    }

}

class TestVisibility {
    public static void main(String[] args) {
        TestVolatile t = new TestVolatile();
        t.start();

        while (true) {
            if (t.isFlag()) {
                System.out.println("主线程拿到标识是true~~~~~");
                break;
            }
        }
    }
}
