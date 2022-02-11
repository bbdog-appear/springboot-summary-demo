package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.数字与静态;

/**
 * <p>
 *      格式设定，用来指示应该用哪种形式来输出，这里的逗号是表示数字要以逗号来分开，并不是说这里有%与d两项参数
 *      1、格式化最多会有5个部分(不包括%符号)，下面的[]符号里面都是选择性的项目，因此只有%与type是必要的。格式化说明的顺序是有规定的。
 *      %[argument number][flags][width][.precision]type
 *      例如：format("%,6.1f", 42.000);其中6代表flags，.号代表width，1f代表.precision
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestFormat.java Date：2022/2/10 14:03 Version：1.0
 */
public class TestFormat {

    public static void main(String[] args) {
        // 1,000,000,000
        String format = String.format("%,d", 1000000000);
        System.out.println(format);
        // I have 476578.10 bugs to fix.
        String format1 = String.format("I have %.2f bugs to fix.", 476578.09876);
        System.out.println(format1);
        // I have 476,578.10 bugs to fix.
        String format2 = String.format("I have %,.2f bugs to fix.", 476578.09876);
        System.out.println(format2);
        // I have 476578.10, bugs to fix.
        String format3 = String.format("I have %.2f, bugs to fix.", 476578.09876);
        System.out.println(format3);
        //   42.0
        String format4 = String.format("%,6.1f", 42.000);
        System.out.println(format4);
    }

}
