package com.bbdog.study.springboot.summary.demo.web.linksure.复习.算法.排序;

import java.util.Arrays;

/**
 * 每次遍历的过程中，选择出最小的元素，放到当前位置
 * 适用场景：适用于小规模数据排序，简单但效率较低。时间复杂度:O(n²)
 */
public class 选择排序 {

    public static void main(String[] args) {
        int[] arr = new int[] {4, 6, 8, 7, 9, 2, 10, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 找出最小元素
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            // 与当前索引交换位置
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }

}
