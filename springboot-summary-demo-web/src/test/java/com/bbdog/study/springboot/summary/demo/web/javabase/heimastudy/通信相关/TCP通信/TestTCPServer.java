package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.通信相关.TCP通信;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>
 *      测试TCP协议读取数据实现方式-服务端
 *      1、这里socket连接流程：客户端发送一个socket通信管道连接请求给服务端，服务端这边接收到，即accept到后，服务端这边也和该socket通信管道
 *      连接，那么这时候客户端和服务端就连接起来了。连接起来后，也就通过IO流发送接收数据，发送的数据是发到socket通信管道中的，通过socket传输
 *      2、这样的服务端和客户端分别启动后，服务端这边会报错的，分析：服务端先启动，等待，然后客户端启动，这时候已经连接了，然后服务端这里直接跑到
 *      br.readLine()里了，通信的和IO流不太一样，IO流如果读取不到，直接返回null，但是现在不在IO文件里读，而是在通信管道里读，通信时认为
 *      br.readLine()还没有消息的时候，会一直等待。这时候客户端那边发送了消息，但是那边没有换行，然后服务端这边由于每次读一行，会认为客户端
 *      那边还没有完成一行，就还在这等待，结果客户端那边代码跑完了，然后客户端的socket通信管道连接已经断了，服务端这边认为客户端那边socket已经死了，
 *      然后服务端这边也会断开连接的，所以就报错Connection reset
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestTCPServer.java Date：2022/7/13/013 23:52 Version：1.0
 */
public class TestTCPServer {

    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动");
        // 1、注册端口
        ServerSocket ss = new ServerSocket(8888);

        // 2、开始等待接收客户端的socket管道连接，意思是客户端那边的socket要和服务端这边碰面，然后服务端接受连接，
        // 如果客户端那边还没有请求该服务端的ip和端口，这边会一直等待
        Socket socket = ss.accept();

        // 3、从socket通信管道中得到一个字节输入流，这个输入流就是通向socket通信管道的，所以通过这个输入流读取的话，
        // 可以读到当时客户端写到socket通信管道中的字节数据
        InputStream is = socket.getInputStream();

        // 4、把字节输入流转换成字符输入流
        Reader isr = new InputStreamReader(is);

        // 5、把字符输入流包装成缓冲字符输入流
        BufferedReader br = new BufferedReader(isr);

        // 6、按照行读取消息，这里因为包装了很多层，但其实底层还是由低级的字节输入流FileInputStream去读取数据的，然后把数据送到高级输入流做加工，
        // 无论是字符还是数字，在计算机底层都是二进制传输的，字符是数据，字节是大小单位，按照字节读，就相当于数那个二进制的位数，按照字符读，相当于直接一个一个字符读
        String msg;
        while ((msg = br.readLine()) != null) {
            System.out.println("服务端收到：" + msg);
        }
    }

}
