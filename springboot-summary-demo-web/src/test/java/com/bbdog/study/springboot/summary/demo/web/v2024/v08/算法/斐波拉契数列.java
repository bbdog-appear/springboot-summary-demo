package com.bbdog.study.springboot.summary.demo.web.v2024.v08.算法;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 写一个函数，输入n，求斐波拉契数列的第n项，斐波拉契数列的定义如下：
 *          0                       n = 0
 * f(n) =   1                       n = 1
 *          f(n - 2) + f(n - 1)     n > 1
 *
 */
public class 斐波拉契数列 {

    private static Map<Integer, Integer> storeMap = new ConcurrentHashMap<>();

    /**
     * 使用map缓存计算的结果；时间复杂度 O(n)
     * storeMap:{2=1, 3=2, 4=3, 5=5, 6=8, 7=13, 8=21, 9=34, 10=55}
     *
     * @param args 入参
     */
    public static void main(String[] args) {
        int fibonacci = new 斐波拉契数列().fibonacci(10);
        System.out.println(fibonacci + "\nstoreMap:" + storeMap.toString());
    }

    public int fibonacci(int n) {
        if (storeMap.get(n) != null) {
            return storeMap.get(n);
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        int result = fibonacci(n - 2) + fibonacci(n - 1);
        storeMap.put(n, result);
        return result;
    }

}
