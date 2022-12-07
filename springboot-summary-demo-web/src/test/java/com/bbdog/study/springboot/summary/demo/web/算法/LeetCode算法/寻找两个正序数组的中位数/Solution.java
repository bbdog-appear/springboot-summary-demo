package com.bbdog.study.springboot.summary.demo.web.算法.LeetCode算法.寻找两个正序数组的中位数;

/**
 * <p>
 *      《寻找两个正序数组的中位数》
 *      给定两个大小分别为m和n的正序（从小到大）数组nums1和nums2。请你找出并返回这两个正序数组的中位数。
 *      算法的时间复杂度应该为O(log(m+n))
 *
 *      示例1：
 *      输入：nums1 = [1,3], nums2 = [2]
 *      输出：2.00000
 *      解释：合并数组 = [1,2,3] ，中位数 2
 *
 *      示例2：
 *      输入：nums1 = [1,2], nums2 = [3,4]
 *      输出：2.50000
 *      解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 *      提示：
 *      nums1.length == m
 *      nums2.length == n
 *      0 <= m <= 1000
 *      0 <= n <= 1000
 *      1 <= m + n <= 2000
 *      -106 <= nums1[i], nums2[i] <= 106
 * </p>
 *
 * @author cheng.wang
 * @version Id：Solution.java Date：2022/12/7 10:02 Version：1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double medianSortedArrays = new Solution().findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    /**
     * 我的思路：找出两个数组中的最小值，再找出两个数组中的最大值，用(最小值+最大值)/2
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length != 0 && nums2.length != 0) {
            int min = Math.min(nums1[0], nums2[0]);
            int max = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
            return (min + max) / 2.0;
        } else if (nums2.length != 0) {
            return (nums2[0] + nums2[nums2.length - 1]) / 2.0;
        } else if (nums1.length != 0) {
            return (nums1[0] + nums1[nums1.length - 1]) / 2.0;
        } else {
            return 0.0;
        }
    }

}
