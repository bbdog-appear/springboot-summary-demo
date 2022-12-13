package com.bbdog.study.springboot.summary.demo.web.算法.LeetCode算法.Z字形变换;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *      将一个给定字符串s根据给定的行数numRows，以从上往下、从左到右进行Z字形排列。
 *      比如输入字符串为"PAYPALISHIRING"行数为3时，排列如下：
 *      P A H N
 *      APLSIIG
 *      Y I R
 *      之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *      请你实现这个将字符串进行指定行数变换的函数：
 *      stringconvert(strings,intnumRows);
 *
 *      示例1：
 *      输入：s="PAYPALISHIRING",numRows=3
 *      输出："PAHNAPLSIIGYIR"
 *      示例2：
 *      输入：s="PAYPALISHIRING",numRows=4
 *      输出："PINALSIGYAHRPI"
 *      解释：
 *      P  I  N
 *      A LS IG
 *      YA HR
 *      P  I
 *      示例3：
 *      输入：s="A",numRows=1
 *      输出："A"
 *
 *      提示：
 *      1<=s.length<=1000
 *      s由英文字母（小写和大写）、','和'.'组成
 *      1<=numRows<=1000
 *      </p>
 *
 * @author cheng.wang
 * @version Id：Solution.java Date：2022/12/9 11:29 Version：1.0
 */
public class Solution {


    public static void main(String[] args) {
        String result = new Solution().convert("PAYPALISHIRING", 4);
        System.out.println(result);
    }

    /**
     * 列举出不同长度字符串排列的索引位置，可以得出：
     * 如果numRows为3，则公式除了第n+=4，其他都可以套用n/2
     *
     * 自己想的是二维数组，但是太复杂，还写不出来。然后看的题解，发现那些人是真牛逼
     * 用一个flag来往返移动
     *
     * @param s 字符串
     * @param numRows 行数
     * @return 转换后字符串
     */
    public String convert(String s, int numRows) {
        // 定义一个List的StringBuilder，用来间接表示二维数组
        List<StringBuilder> resultList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            resultList.add(new StringBuilder());
        }
        int j = 0;
        int flag = -1;
        for (char aChar : s.toCharArray()) {
            resultList.get(j).append(aChar);
            if (j == 0 || j == numRows - 1) {
                flag = -flag;
            }
            j += flag;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : resultList) {
            result.append(builder);
        }
        return result.toString();
    }

}
