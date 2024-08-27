package com.bbdog.study.springboot.summary.demo.web.v2024.v08.排序;

import java.util.Arrays;

public class 冒泡 {

    /**
     * int [] arr = {9, 7, 8, 5, 6, 4, 3, 2, 1}
     * {7, 9, 8, 5, 6, 4, 3, 2, 1}
     * {7, 8, 9, 5, 6, 4, 3, 2, 1}
     * {7, 8, 5, 9, 6, 4, 3, 2, 1}
     *
     */
    public static void main(String[] args) {
        int [] arr = {9, 7, 8, 5, 6, 4, 3, 2, 1};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
