package com.bbdog.study.springboot.summary.demo.web.linksure.复习.算法.排序.简单;

import java.util.Arrays;

public class 插入排序 {

    public static void main(String[] args) {
        int[] arr = new int[] {4, 3, 2, 10, 12, 1, 5, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 取出当前元素
            int current = arr[i];
            // 前一个位置
            int j = i - 1;
            // 当前元素小于前一个位置元素，继续向前比较(继续循环)
            while (j >= 0 && current < arr[j]) {
                // 将当前位置赋值前一个元素值(移动元素)
                arr[j + 1] = arr[j];
                // 指针前移
                j--;
            }
            // 直到当前元素值大于寻找的某个位置，将该位置赋值当前元素(即在正确位置插入当前元素)
            arr[j + 1] = current;
        }
    }

//    /**
//     * 自己实现：
//     * 缺点：交换操作较多，每次发现逆序时都会交换元素，而传统的插入排序可以通过移动元素来减少交换次数；代码上还可以精简一些，这里写的臃肿，可以向while中合并条件。
//     *
//     * @param arr 入参
//     */
//    public static void sort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            int compareIndex = i + 1;
//            while (compareIndex > 0) {
//                int preIndex = compareIndex - 1;
//                if (arr[compareIndex] > arr[preIndex]) {
//                    break;
//                }
//                int tmp = arr[preIndex];
//                arr[preIndex] = arr[compareIndex];
//                arr[compareIndex] = tmp;
//                compareIndex--;
//            }
//        }
//    }

}
