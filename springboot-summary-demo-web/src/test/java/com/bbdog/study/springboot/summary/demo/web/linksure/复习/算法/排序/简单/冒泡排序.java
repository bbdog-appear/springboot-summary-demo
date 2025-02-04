package com.bbdog.study.springboot.summary.demo.web.linksure.复习.算法.排序.简单;

import java.util.Arrays;

/**
 * 每次循环比较相邻两个元素大小后交换位置
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] arr = {9, 7, 6, 8, 1, 5, 3, 2, 4};
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }

    public static int[] sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            // 每执行一轮循环，数组最后一个元素就是最大值，不需要比较，所以循环次数为len-i-1
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

}
