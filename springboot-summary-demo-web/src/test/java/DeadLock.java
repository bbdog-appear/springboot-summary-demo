/**
 * 死锁
 *
 * @author cheng.wang
 * @version Date：2026/4/21
 */
public class DeadLock {

    // 创建两个锁对象
    private static final Object LOCK_A = new Object();
    private static final Object LOCK_B = new Object();

    public static void main(String[] args) {
        // 线程1：先拿锁A，再拿锁B
        Thread thread1 = new Thread(() -> {
            synchronized (LOCK_A) {
                System.out.println("线程1: 获得锁A，等待获取锁B...");

                // 模拟业务处理，增加死锁概率
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (LOCK_B) {
                    System.out.println("线程1: 同时获得锁A和锁B，执行完成");
                }
            }
        });

        // 线程2：先拿锁B，再拿锁A（顺序相反，导致死锁）
        Thread thread2 = new Thread(() -> {
            synchronized (LOCK_B) {
                System.out.println("线程2: 获得锁B，等待获取锁A...");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (LOCK_A) {
                    System.out.println("线程2: 同时获得锁A和锁B，执行完成");
                }
            }
        });

        thread1.start();
        thread2.start();
    }

}
