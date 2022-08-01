package com.bbdog.study.springboot.summary.demo.web.算法.LeetCode算法.算法1;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：Solution.java Date：2022/8/1 15:31 Version：1.0
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode l3r = null;
        // 进位值
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            // 这里判断l1或l2，如果是空则为0，非空就是当前值
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;

            // 定义两个链表对应节点的计算和
            int sum = n1 + n2 + carry;
            carry = sum / 10;

            /* 我脑子不好使了，没有体会到指针的快乐，其中l3和l3r如果都指向一个节点，然后只用l3r操作这个节点，然后l3r的指针往后移动，
            就能延长这个链表的长度，开始我以为仅仅操作l3r，那如果l3r的指针往后移动，那么前面的节点不就丢失了吗？错！因为前一个节点，
            是有l3指向在的，并没有失去引用，画个图就明白了了！即这里先判断一下头节点是否为空，如果是空，初始化头结点，下次不要操作它了，
            去操作新定义的一个临时指针即可。或者换种思路就是一开始就定义一个-1节点，即头结点的前一个节点。那么就不用判断头结点非空了，
            直接操作即可。 */
            if (l3 == null) {
                l3r = l3 = new ListNode(sum % 10);
            } else {
                // 定义当前节点的下一个节点数据
                l3r.next = new ListNode(sum % 10);
                // 将临时变量的指针指向下一个节点
                l3r = l3r.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return l3;
    }

}
