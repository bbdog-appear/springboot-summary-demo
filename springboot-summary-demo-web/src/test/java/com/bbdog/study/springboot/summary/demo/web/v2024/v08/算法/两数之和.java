package com.bbdog.study.springboot.summary.demo.web.v2024.v08.算法;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 提示：
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 */
public class 两数之和 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,6,13,8,7,9};
        int[] result = new 两数之和().twoSum2(nums, 20);
        System.out.println(Arrays.toString(result));
    }


    /**
     * 暴力穷举：两个for循环；时间复杂度 O(n²)
     * 例 nums:{6,88,7,11,15,2} 目标值:9
     *
     * @param nums 数组
     * @param target 目标
     * @return 结果
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return nums;
        }
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 问题:上面第二次循环中，已经把第一次扫描的数又扫描了一次，时间复杂度是比较高的
     * 解:引入hash表，存储每个数对应的数组下标值
     * 说明:map中key存数组下标对应的值，value存数组下标，通过 map.get(target-数组中元素值)是否存在为关键点
     *
     * 例 nums:{4,6,13,8,7,9} 目标值:20
     * map:{4:0, 6:1, 13:2, 8:3}
     * 结果 {2,4}
     *
     * 时间复杂度 O(n)
     *
     * @param nums 数组
     * @param target 目标
     * @return 结果
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
