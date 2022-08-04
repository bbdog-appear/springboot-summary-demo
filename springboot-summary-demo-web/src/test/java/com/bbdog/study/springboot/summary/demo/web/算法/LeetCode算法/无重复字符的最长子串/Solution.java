package com.bbdog.study.springboot.summary.demo.web.算法.LeetCode算法.无重复字符的最长子串;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *      无重复字符的最长子串
 *
 *      给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *      示例：
 *      输入: s = "abcabcbb"
 *      输出: 3
 *      解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *      输入: s = "bbbbb"
 *      输出: 1
 *      解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *      输入: s = "pwwkew"
 *      输出: 3
 *      解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：Solution.java Date：2022/8/4 13:43 Version：1.0
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring("s");
    }

    public int lengthOfLongestSubstring(String s) {
        int finalMaxLength = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.clear();
            list.add(s.charAt(i));
            // 需要把刚才最长长度对应的字符串的每一个字符和后面比较，即a b c字符中b和后面一个b相同，那么abc就是最长长度
            for (int j = i + 1; j < s.length(); j++) {
                char c = s.charAt(j);
                if (list.contains(c)) {
                    break;
                }
                list.add(c);
            }
            // 每次内部循环计算的字符串长度取最大值
            finalMaxLength = Math.max(finalMaxLength, list.size());
        }
        return finalMaxLength;
    }

}
