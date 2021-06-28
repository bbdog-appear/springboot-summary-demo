package com.bbdog.study.springboot.summary.demo.web.jvm.bytecode;

/**
 * <p>
 *      字节码文件测试
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestByteCode.java Date：2021/6/7 14:49 Version：1.0
 */
public class TestByteCode {

    /**
     * 测试return前执行finally代码，会不会影响最终return的结果
     * 结果是：返回字符串"0"，并不是字符串"01"
     *
     * @param args 入参
     */
    public static void main(String[] args) {
//        testFinally2();
        test();
    }

    /**
     * 通过idea的view-->show bytecode 查看编译后的字节码：
     * 1、当执行到sb.toString();时，会将toString结果放在另一个临时变量1里
     * 2、然后执行finally里，将sb对象追加字符串"1"
     * 3、 但是最终return的还是临时变量1，也就是字符串"0"
     *
     * @return 最终得到的值
     */
    private static String testFinally2(){
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        try {
            return sb.toString();
        } finally {
            sb.append("1");
        }
    }

    private static void test() {
        String a = "I am ";
        String b = "cheng";
        String c = a + b;
        String d = "I am " + "cheng";
        System.out.println(c == d);
        Integer i = 100;
        int j = i;
        System.out.println(i == j);
    }

}
