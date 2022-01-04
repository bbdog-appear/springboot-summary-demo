package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.foreach;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestFor.java Date：2021/12/29 15:28 Version：1.0
 */
public class TestFor {

    public static void main(String[] args) {
        test3();
    }

    /**
     * 测试大的long类型数据装进小的short类型的杯子，那么值可能会被裁掉。
     * 结果是-25534
     */
    public static void test3() {
        long x = 40002;
        short y = (short) x;
        System.out.println(y);
    }

    /**
     * 测试 i++ 和 ++i
     */
    public static void test2() {
        // ++i，++放在变量前面代表先执行加减操作然后再运用变量的值。
        int i = 0;
        int j = ++i;
        // 等同于下面代码
        int i1 = 0;
        i1 = i1 + 1;
        int j1 = i1;

        // i++，++放在变量后面代表x为0先赋值给y，然后再执行x递增的操作。
        int x = 0;
        int y = x++;
        int yx = y;
        int yxx = x;
        int z = x++;
        // 等同于下面的代码
        int x1 = 0;
        int y1 = x1;
        x1 = x1 + 1;
        System.out.println(i + "\n" + j);
        System.out.println(i1 + "\n" + j1);
        System.out.println();
        // 结果 2 0 0 1 1
        System.out.println(x + "\n" + y + "\n" + yx + "\n" + yxx + "\n" + z);
        System.out.println(x1 + "\n" + y1);
    }

    public void test(){
        for (int i = 0,j = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

}
