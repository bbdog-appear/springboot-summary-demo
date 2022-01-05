package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.dotcom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * <p>
 *      游戏助手类
 * </p>
 *
 * @author cheng.wang
 * @version Id：GameHelper.java Date：2021/12/29 10:31 Version：1.0
 */
public class GameHelper {

    private static final String ALPHABET = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt + "");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0)
                return null;
        } catch (IOException e) {
            System.out.println("IOException:" + e);
        }
        return inputLine;
    }

    /**
     * 设置DotCom的位置
     * 其中要考虑到重叠等问题
     *
     * @param comSize DotCom的大小，比如3个连续格子
     * @return DotCom的位置
     */
    public ArrayList<String> placeDotCom(int comSize) {
        // 需要返回的DotCom的位置
        ArrayList<String> alphaCells = new ArrayList<>();
        String[] alphaCoords = new String[comSize];
        String temp = null;
        // 计算过程中的DotCom位置信息
        int[] coords = new int[comSize];
        int attempts = 0;
        boolean success = false;
        // 使用随机数计算出的位置，如9，那么就是第10个位置
        int location = 0;

        // 控制DotCom图形的横竖排版(1 横着，7 竖着)
        comCount++;
        int incr = 1;
        if ((comCount % 2) == 1) {
            incr = gridLength;
        }
        // 如果是false则继续循环。其中&符号是指：&左边如果不成立，则继续执行&右边部分，然后再进行&操作。
        while (!success & attempts++ < 200) {
            // 生成一个0~48的随机数
            location = (int) (Math.random() * gridSize);
            int x = 0;
            success = true;
            // 如果是false且已经达到DotCom的大小，则跳出循环。其中&&符号是指：&&左边如果不成立，不执行&&右边部分，直接返回。
            while (success && x < comSize) {
                // 该步骤防止重叠问题
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incr;
                    // 判断DotCom中的下一个位置是否超过7X7宫格，即是否超过49
                    if (location >= gridSize) {
                        success = false;
                    }
                    // 判断是否超过右边缘，该步骤是否有用？
                    if (x > 0 && (location % gridLength == 0)) {
                        success = false;
                    }
                } else {
                    // 如果重叠，则会跳出循环
                    success = false;
                }
            }
        }
        int x = 0;
        int row = 0;
        int column = 0;
        while (x < comSize) {
            grid[coords[x]] = 1;
            // 计算在哪一行
            row = (int) (coords[x] / gridLength);
            // 计算在哪一列
            column = coords[x] % gridLength;
            // 用abc表示列
            temp = String.valueOf(ALPHABET.charAt(column));

            // 拼接字符串，比如c1 c2 c3等
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
        }
        return alphaCells;
    }

}
