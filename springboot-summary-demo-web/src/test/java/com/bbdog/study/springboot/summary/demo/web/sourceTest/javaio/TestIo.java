package com.bbdog.study.springboot.summary.demo.web.sourceTest.javaio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * <p>
 *      测试io包的方法
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestIo.java Date：2021/4/13 13:46 Version：1.0
 */
public class TestIo {

    public static void main(String[] args) throws Exception {
//        testOriginalStream();
        testBufferedStream();
    }

    /**
     * 测试原始的流操作，用自己定义的byte数组作为缓冲区去操作，没有用到设计思想,并且效率较差
     *
     * @throws Exception 抛出的异常
     */
    public static void testOriginalStream() throws Exception{
        // 本地D盘下放一张图片,将该图片放入输入流
        FileInputStream inputStream = new FileInputStream("D:\\111.png");
        // 在本地D盘下创建一个png的文件，暂时是空图片，并放入输出流
        FileOutputStream outputStream = new FileOutputStream("D:\\副本333.png");

        // 定义一个字节数组，字节流一次读写一个数组的速度明显比一次读写一个字节的速度快很多，这是加入了数组这样的缓冲区效果
        byte[] bytes = new byte[2048];
        // 读取到缓冲区的字节总数
        int len = 0;

        // 从111.png文件中每次读取2048个字节，放入字节数组中
        // 下次循环，还是这个bytes对象，但是这次读取的2048个字节会覆盖之前的数据。
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(bytes);
            // 将字节数组中从第0个位置，读取2048个字节到副本333文件中。
            outputStream.write(bytes, 0, len);
        }
        inputStream.close();
        outputStream.close();
    }

    /**
     * 测试字节缓冲流操作，效率相对来说最好
     * 其中无论文件是什么类型，都可以进行流的读写操作。只不过有的文件需要进行分析，比如Excel的分析。表头和表数据。
     *
     * @throws Exception 抛出的异常
     */
    public static void testBufferedStream() throws Exception{
        // 字节缓冲流的作用就是提高输入输出的效率
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\333abc.xlsx"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\副本333abc.xlsx"));

        // 定义一个字节数组，字节流一次读写一个数组的速度明显比一次读写一个字节的速度快很多，这是加入了数组这样的缓冲区效果
        byte[] bytes = new byte[2048];
        // 读取到缓冲区的字节总数
        int len = 0;

        // 从111.png文件中每次读取2048个字节，放入字节数组中
        // 下次循环，还是这个bytes对象，但是这次读取的2048个字节会覆盖之前的数据。
        while ((len = bis.read(bytes)) != -1) {
            System.out.println(bytes);
            // 将字节数组中从第0个位置，读取2048个字节到副本333文件中。
            bos.write(bytes, 0, len);
        }
        bis.close();
        bos.close();
    }

}
