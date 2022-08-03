package com.bbdog.study.springboot.summary.demo.web.算法.LeetCode算法.回文数;

/**
 * <p>
 *      1221
 * </p>
 *
 * @author cheng.wang
 * @version Id：Solution.java Date：2022/8/2 19:23 Version：1.0
 */
public class Solution {

    public boolean isPalindrome(int x) {
        // 负数肯定回文数不一样
        if (x < 0) {
            return false;
        }
        // 个位为0的，不可能是回文数，因为首位不可能是0，即没有012210这样的数
        if (x % 10 == 0 && x != 0) {
            return false;
        }
        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x = x / 10;
        }
        if (x < right) {
            if (x == right / 10) {
                return true;
            }
        }
        return x == right;
    }

}
