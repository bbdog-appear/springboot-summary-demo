package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.foreach;

/**
 * <p>
 *      测试for循环和i++
 * </p>
 *
 * @author cheng.wang
 * @version Id：Output.java Date：2021/12/30 14:10 Version：1.0
 */
public class Output {

    public static void main(String[] args) {
        Output o = new Output();
        o.go();
//        o.lianLianKan();
    }

    /**
     * run方法里的go()方法编译不通过，但是如果用对象.go()方法，可以编译通过。
     * 原因可能是：run方法是static的，类加载的时候就会加载该方法，但是下面的go()方法此时还没有加载，所以编译器不知道go()方法是哪个
     * 如果Output o = new Output();相当于初始化一个对象了，那么类加载肯定已经完成，对象的go()肯定已经存在，所以编译通过。
     */
    static void run() {
//        go();
        Output o = new Output();
        o.go();
    }

    /**
     * 测试i++和++i的小程序
     */
    void go() {
        int y = 7;
        for (int i = 1; i < 8; i++) {
            // 最终打印出来的是：13 15 i = 6
            y++;
            if (i > 4) {
                System.out.println(++y + "");
            }
            if (y > 14) {
                System.out.println("i = " + i);
                break;
            }
        }
    }

    /**
     * 测试连连看，左侧是需要补充的代码，右侧是相符的输出：
     * x = x + 3;       45 6
     * x = x + 6;       36 6
     * x = x + 2;       54 6
     * x++;             60 10
     * x--;             18 6
     * x = x + 0;       6 14
     *                  12 14
     */
    void lianLianKan() {
        int x = 0;
        int y = 30;
        for (int outer = 0; outer < 3; outer++) {
            for (int inner = 4; inner > 1; inner--) {
                // x = x + 3    连接  54 6
                // x = x + 6    连接  60 10
                // x = x + 2    连接  45 6
                // x++          连接  36 6
                // x--          连接  18 6
                // x = x + 0    连接  6 14
                x = x + 0;
                y = y - 2;
                if (x == 6) {
                    break;
                }
                x = x + 3;
            }
            y = y - 2;
        }
        System.out.println(x + " " + y);
    }

}
