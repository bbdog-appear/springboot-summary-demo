package com.bbdog.study.springboot.summary.demo.web.算法.LeetCode算法.整数反转;

/**
 * <p>
 *      给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 *      如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
 *
 *      假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 *      举例：
 *      输入：x = 123
 *      输出：321
 *
 *      输入：x = -123
 *      输出：-321
 *
 *      输入：x = 120
 *      输出：21
 *
 *      输入：x = 0
 *      输出：0
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：Solution.java Date：2022/8/3 16:05 Version：1.0
 */
public class Solution {

    public int reverse(int x) {
        // 这里要声明为long类型，如果反转后的结果超过32位，用long类型接的话不会改变原有的值。然后再和这个值转成int类型的值比较，
        // 就能知道是否超过32位最大值，如果是不等于，代表超过32位，直接返回0
        long reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x = x /10;
        }
        return (int)reverse == reverse ? (int)reverse : 0;
    }

}
