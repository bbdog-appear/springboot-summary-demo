package com.bbdog.study.springboot.summary.demo.web.算法.LeetCode算法.最长回文子串;

/**
 * <p>
 *      给你一个字符串s，找到s中最长的回文子串。
 *
 *      示例1：
 *      输入：s="babad"
 *      输出："bab"
 *      解释："aba"同样是符合题意的答案。
 *
 *      示例2：
 *      输入：s="cbbd"
 *      输出："bb"
 *
 *      提示：
 *      1<=s.length<=1000
 *      s仅由数字和英文字母组成
 * </p>
 *
 * @author cheng.wang
 * @version Id：Solution.java Date：2022/12/8 10:43 Version：1.0
 */
public class Solution {

    public static void main(String[] args) {
        String s = new Solution().longestPalindrome("a");
        System.out.println(s);
    }

    /**
     * 自己思路：
     * 1、将字符串反转，记为reverse
     * 2、使用两个指针遍历两个字符串，移动指针，将相同字符拼接成字符串，直到字符不相同时停止遍历，
     * 该字符串就是回文数
     *
     * 上面思路不对，换种思路：
     * 直接列举所有的子串，将最长的回文数子串取出。
     *
     * 最终还是看着题解写的暴力解法，用了三次循环遍历，时间复杂度O(n^3)，空间复杂度O(1)
     *
     * @param s 字符串
     * @return 回文数子串
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int max = 0;
        int first = 0;
        int last = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (validFlag(chars, i, j) && j - i + 1 > max) {
                    max = j - i + 1;
                    first = i;
                    last = j + 1;
                }
            }
        }
        return s.substring(first, last);
    }

    private boolean validFlag(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }

}
