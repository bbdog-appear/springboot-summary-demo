package com.bbdog.study.springboot.summary.demo.web.v2024.v08.算法;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 假设你正在爬楼梯。需要n阶你才能到达楼顶
 * 每次你可以爬1或2个台阶。你有多少种不同的方法可以爬到楼顶
 * 注意：给定n是一个正整数
 *
 * 示例1：
 * 输入：2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶
 * 1. 1阶 + 1阶
 * 2. 2阶
 *
 * 示例2：
 * 输入：3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶
 * 1. 1阶 + 1阶 + 1阶
 * 2. 1阶 + 2阶
 * 3. 2阶 + 1阶
 */
public class 爬楼梯 {

    /**
     * 使用hashMap存储中间结算结果
     */
    Map<Integer, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        int solution = new 爬楼梯().solution2(6);
        System.out.println(solution);
    }

    /**
     * 1.使用递归
     * 2.使用map存已计算的结果，避免重复计算；最终时间复杂度 O(n)
     *
     * @param n n阶
     * @return 种数
     */
    public int solution(int n) {
        if (map.get(n) != null) {
            return map.get(n);
        }
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int result = solution(n - 1) + solution(n - 2);
            map.put(n, result);
            return result;
        }
    }

    /**
     * 1.使用循环，用两个变量记录计算下一次结果的值；时间复杂度 O(n)
     *
     * @param n n阶
     * @return 种数
     */
    public int solution2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result = 0;
        int left = 1;
        int right = 2;
        for(int i = 3; i <= n; i++) {
            result = left + right;
            left = right;
            right = result;
        }
        return result;
    }


}
