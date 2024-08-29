package com.bbdog.study.springboot.summary.demo.web.v2024.v08.算法;

import java.util.Random;

public class 发牌 {

    public static void main(String[] args) {
        //存储108张牌的数组
        int[] a = new int[108];
        //4个玩家个25张牌
        int[][] player = new int[4][25];
        //当前剩余牌
        int leftNum = 108;
        int ranNum;
        //生成随机数
        Random random = new Random();
        for(int i = 0;i < a.length;i++) {
            a[i] = (i + 1) % 54;
            //大小王
            if(a[i] == 0) {
                a[i] = 54;
            }
        }

        //循环发牌
        for(int i = 0;i < 25;i++) {
            //为每个人发牌
            for(int j = 0;j < player.length;j++) {
                //生成随机下标
                ranNum = random.nextInt(leftNum);
                //发牌
                player [j][i] = a[ranNum];
                //删除已经发过的牌
                a[ranNum] = a[leftNum - 1];
                leftNum--;
            }
        }

        //循环输出玩家手中的牌
        for (int i = 0; i < player.length; i++) {
            System.out.print("玩家" + i + "的牌：");
            for (int j = 0; j < player[i].length; j++) {
                System.out.print(" " + player[i][j]);
            }
            System.out.println();
        }

        //底牌
        System.out.print("底牌：");
        for (int i = 0; i < 8; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println();
    }
}
