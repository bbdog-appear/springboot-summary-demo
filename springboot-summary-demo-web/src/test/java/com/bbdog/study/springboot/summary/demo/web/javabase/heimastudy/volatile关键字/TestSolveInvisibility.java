package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.volatile关键字;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *      并发编程下变量不可见性解决方案：
 *      1、加锁：注意并不是主线程和子线程同时对某个对象加锁，然后其中抢到锁后的线程先执行完，另外一个线程就查到最新的，这种理解是错误的。
 *      其实是对需要查询的那一方线程进行加锁，如下，主线程加锁，因为只有它一个线程加了这个synchronized关键字，所以它肯定拿到锁，然后清空主线程
 *      工作内存，然后就从主内存中拷贝共享变量最新的值到工作内存中成为副本。
 *      但其实比如一个公共的方法，进行了synchronized加锁，那么两个线程同时进来，一个线程先拿到锁，执行后，然后释放锁，另一个线程再拿到锁，肯定
 *      能读到最新的变量值。因为synchronized会清空工作内存，读取最新的值。
 *      2、对共享的变量加volatile关键字：把synchronized关键字去掉后，将flag用volatile关键字即可。
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestSolveInvisibility.java Date：2022/6/23/023 0:07 Version：1.0
 */
@Getter
@Setter
public class TestSolveInvisibility extends Thread{

    private volatile boolean flag = false;

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

class Visibility {
    public static void main(String[] args) {
        TestSolveInvisibility t = new TestSolveInvisibility();
        t.start();

        while (true) {
            // 这里因为在静态方法里，所以建议用类名.class文件作为锁，不建议直接用t对象
            synchronized (TestSolveInvisibility.class) {
                if (t.isFlag()) {
                    System.out.println("主线程拿到标识是true~~~~~");
                    break;
                }
            }
        }
    }
}
