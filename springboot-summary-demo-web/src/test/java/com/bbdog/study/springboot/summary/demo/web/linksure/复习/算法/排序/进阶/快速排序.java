package com.bbdog.study.springboot.summary.demo.web.linksure.复习.算法.排序.进阶;

import java.util.Arrays;

/**
 * 快速排序是对冒泡排序的一种改进：
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法再分别快速排序，可以递归进行
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] arr = new int[] {6, 1, 2, 7, 9, 4, 5, 8, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 定义左右指针
        int left = 0;
        int right = arr.length - 1;
        sort(arr, left, right);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // 分区(求出基准索引，左边元素均比基准值小，右边元素均比基准值大)
        int pivot = partition(arr, left, right);
        // 左子组排序
        sort(arr, left, pivot - 1);
        // 右子组排序
        sort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        // 定义基准值(最右侧为基准值)
        int pivotV = arr[right];
        // 定义快慢指针(慢指针i，快指针j)
        int i = left;
        // 慢指针遍历到基准值索引前一位结束
        for (int j = left; j < right; j++) {
            if (arr[j] < pivotV) {
                // 交换位置
                swap(arr, i, j);
                i++;
            }
        }
        // 交换基准值
        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
