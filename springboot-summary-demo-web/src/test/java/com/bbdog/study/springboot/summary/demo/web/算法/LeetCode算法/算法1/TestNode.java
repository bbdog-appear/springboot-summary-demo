package com.bbdog.study.springboot.summary.demo.web.算法.LeetCode算法.算法1;

/**
 * <p>
 *     《两数相加》
 *      给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 *      请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 *      你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 *      输入：l1 = [2,4,3], l2 = [5,6,4]
 *      输出：[7,0,8]
 *      解释：342 + 465 = 807.
 *
 *      https://leetcode.cn/problems/add-two-numbers/
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestNode.java Date：2022/8/1 15:32 Version：1.0
 */
public class TestNode {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l11 = new ListNode(3);
        ListNode l12 = new ListNode(4, l11);
        ListNode l1 = new ListNode(2, l12);

        ListNode l21 = new ListNode(4);
        ListNode l22 = new ListNode(6, l21);
        ListNode l2 = new ListNode(5, l22);

        ListNode l3 = solution.addTwoNumbers(l1, l2);
        System.out.println(l3);
    }

}
