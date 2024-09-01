package com.bbdog.study.springboot.summary.demo.web.v2024.v08.算法.递归;

import java.util.LinkedList;

public class 钥匙开盒子 {

    public static void main(String[] args) {
        LinkedList<String> currentBox = new LinkedList<>();
        currentBox.add("大盒子");
        currentBox.add("中盒子");
        currentBox.add("小盒子");
        currentBox.add("钥匙");
        currentBox.add("假钥匙");
        String result = new 钥匙开盒子().openBox(currentBox, 1);
        System.out.println(result);
    }

    /**
     * 1.每个递归都有两个条件：
     *  1.1 终止条件
     *  1.2 递归条件
     *
     * @param currentBox 当前盒子
     * @param count 终止条件
     * @return 结果
     */
    public String openBox(LinkedList<String> currentBox, int count) {
        if (count > 4) {
            return "很遗憾，没有找到钥匙";
        }
        if ("钥匙".equals(currentBox.poll())) {
            return "恭喜你，找到了钥匙";
        } else {
            count++;
            return openBox(currentBox, count);
        }
    }

}
