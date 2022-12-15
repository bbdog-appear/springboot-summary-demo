package com.bbdog.study.springboot.summary.demo.web.算法.LeetCode算法.字符串转换整数atoi;

/**
 * <p>
 *      请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个32位有符号整数（类似C/C++中的atoi函数）。
 *      函数myAtoi(string s)的算法如下：
 *      1.读入字符串并丢弃无用的前导空格
 *      2.检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。确定最终结果是负数还是正数。如果两者都不存在，则假定结果为正。
 *      3.读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 *      4.将前面步骤读入的这些数字转换为整数（即，"123"->123，"0032"->32）。如果没有读入数字，则整数为0。必要时更改符号（从步骤2开始）。
 *      5.如果整数数超过32位有符号整数范围[−2^31,2^31−1]，需要截断这个整数，使其保持在这个范围内。具体来说，小于−231的整数应该被固定为−2^31，大于2^31−1的整数应该被固定为2^31−1。
 *      6.返回整数作为最终结果。
 *      注意：
 *      本题中的空白字符只包括空格字符''。
 *      除前导空格或数字后的其余字符串外，请勿忽略任何其他字符。
 *
 *      示例1：
 *      输入：s="42"
 *      输出：42
 *      解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 *      第1步："42"（当前没有读入字符，因为没有前导空格）
 *            ^
 *      第2步："42"（当前没有读入字符，因为这里不存在'-'或者'+'）
 *            ^
 *      第3步："42"（读入"42"）
 *              ^
 *      解析得到整数42。
 *      由于"42"在范围[-2^31,2^31-1]内，最终结果为42。
 *
 *      示例2：
 *      输入：s="    -42"
 *      输出：-42
 *      解释：
 *      第1步："____-42"（读入前导空格，但忽视掉）
 *                ^
 *      第2步："    -42"（读入'-'字符，所以结果应该是负数）
 *                 ^
 *      第3步："    -42"（读入"42"）
 *                   ^
 *      解析得到整数-42。
 *      由于"-42"在范围[-2^31,2^31-1]内，最终结果为-42。
 *
 *      示例3：
 *      输入：s="4193 with words"
 *      输出：4193
 *      解释：
 *      第1步："4193 with words"（当前没有读入字符，因为没有前导空格）
 *            ^
 *      第2步："4193 with words"（当前没有读入字符，因为这里不存在'-'或者'+'）
 *            ^
 *      第3步："4193 with words"（读入"4193"；由于下一个字符不是一个数字，所以读入停止）
 *                ^
 *      解析得到整数4193。
 *      由于"4193"在范围[-2^31,2^31-1]内，最终结果为4193。
 *
 *      提示：
 *      0<=s.length<=200
 *      s由英文字母（大写和小写）、数字（0-9）、''、'+'、'-'和'.'组成
 * </p>
 *
 * @author cheng.wang
 * @version Id：Solution.java Date：2022/12/14 14:38 Version：1.0
 */
public class Solution {

    public static void main(String[] args) {
        int i = new Solution().myAtoi("4193 with words");
        System.out.println(i);
    }

    /**
     * 这题是看着题解抄的
     * 因为就遍历一次字符串，N为字符串的长度，时间复杂度：O(N)
     * 没有创建新的对象，都是常量，空间复杂度：O(1)
     *
     * @param s 字符串
     * @return 结果
     */
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int head = 0;
        int flag = 1;
        while (head < chars.length && chars[head] == ' ') {
             head++;
        }
        if (head == chars.length) {
            return 0;
        }
        if (chars[head] == '-') {
            flag = -1;
            head++;
        } else if (chars[head] == '+') {
            head++;
        }
        int result = 0;
        int tail;
        while (head < chars.length) {
            if (chars[head] < '0' || chars[head] > '9') {
                break;
            }
            tail = result;
            // 字符转数字，减字符0
            result = result * 10 + (chars[head++] - '0');
            // 判断是否溢出(因为定义的是int类型，判断*10之前和之后的值是否相等，如果不相等则超过32位溢出了)，如果溢出，则取int类型的最小值或最大值
            if (tail != result / 10) {
                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return result * flag;
    }

}
