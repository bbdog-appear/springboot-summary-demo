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
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 7};
        double medianSortedArrays = new Solution().findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    /**
     * 我的思路：找出两个数组中的最小值，再找出两个数组中的最大值，用(最小值+最大值)/2
     *
     * 上面的理解就是错的，中位数的定义：如果数据的个数是奇数，则中间那个数据就是这群数据的中位数，
     * 如果数据的个数是偶数，则中间那2个数据的算术平均值就是这群数据的中位数
     * 1、先合并两个数组并排序-使用归并排序
     * 2、如果是奇数，则取中间的那个数，如果是偶数，则两个数的平均数
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        // 两个数组合并后并排序的数据
        int[] numSum = new int[nums1.length + nums2.length];
        while (i < nums1.length || j < nums2.length) {
            // 当其中一个数组遍历完成后，将另一个数组剩下的所有元素复制到合并数组列尾
            if (j == nums2.length || (i != nums1.length && nums1[i] < nums2[j])) {
                numSum[k++] = nums1[i++];
            } else {
                numSum[k++] = nums2[j++];
            }
        }
        // 如果是奇数则直接取中间那个数，如果是偶数则取中间两位数的平均值
        return numSum.length % 2 != 0 ? (double)numSum[numSum.length / 2] :
                ((double)numSum[(numSum.length / 2) - 1] + (double)numSum[numSum.length / 2]) / 2;
    }

}
