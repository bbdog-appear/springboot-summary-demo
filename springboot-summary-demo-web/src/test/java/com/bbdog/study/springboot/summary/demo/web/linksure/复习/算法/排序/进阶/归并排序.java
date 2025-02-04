package com.bbdog.study.springboot.summary.demo.web.linksure.复习.算法.排序.进阶;

import java.util.Arrays;

/**
 * 归并排序是分治思想的最典型例子，分别通过递归调用将它们单独排序，最后将有序的子数组归并为最终的排序结果
 */
public class 归并排序 {

    private static int[] tmpArr;

    public static void main(String[] args) {
        int[] arr = new int[] {8, 4, 5, 7, 1, 3, 6, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr) {
        // 临时数组作为辅助
        tmpArr = new int[arr.length];
        // 采用分治思想，定义左右指针，先排序分组后的左右子组
        int left = 0;
        int right = arr.length - 1;
        sort(arr, left, right);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // 计算mid
        int mid = left + (right - left) / 2;
        // 左子组
        sort(arr, left, mid);
        // 右子组
        sort(arr, mid + 1, right);
        // 归并子组
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // 定义左子组和右子组的初始指针，以及临时数组指针
        int l = left;
        int r = mid + 1;
        int i = left;
        // 分别比较左右子组当前位置元素大小，较小的放入新数组
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                tmpArr[i++] = arr[l++];
            } else {
                tmpArr[i++] = arr[r++];
            }
        }
        // 特殊处理(左子组或右子组还未遍历完，继续遍历)
        while (l <= mid) {
            tmpArr[i++] = arr[l++];
        }
        while (r <= right) {
            tmpArr[i++] = arr[r++];
        }
        // 将结果复制给原数组
        for (int j = left; j <= right; j++) {
            arr[j] = tmpArr[j];
        }
    }

}
