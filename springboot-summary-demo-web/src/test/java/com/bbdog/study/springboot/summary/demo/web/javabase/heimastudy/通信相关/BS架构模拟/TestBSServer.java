package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.通信相关.BS架构模拟;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *      测试B/S架构，即浏览器/服务器架构
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestBSServer.java Date：2022/7/20/020 1:13 Version：1.0
 */
public class TestBSServer {

    private static final ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws Exception {
        // 1、注册端口
        ServerSocket ss = new ServerSocket(8080);
        while (true) {
            // 2、开始等待接收浏览器的socket管道连接，意思是客户端那边的socket要和服务端这边碰面，然后服务端接受连接，
            // 如果浏览器那边还没有请求该服务端的ip和端口，这边会一直等待，即无socket管道请求时，这里会阻塞
            Socket socket = ss.accept();

            System.out.println("有客户端：" + socket.getRemoteSocketAddress() + "连接啦，socket对象为：" + socket.hashCode());

            // 7、每接收一个客户端socket通信管道的连接请求，就开启一个线程执行，现改为线程池的方式处理任务
            executor.execute(new BSArchServerThread(socket));
        }
    }

}

class BSArchServerThread extends Thread {

    private final Socket socket;

    public BSArchServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 1、响应消息给浏览器，即使用高级打印流打印数据到socket管道里，浏览器接收。注意浏览器是基于HTTP协议通信的，所以
            // 响应要按照一定的格式，浏览器才能识别
            PrintStream ps = new PrintStream(socket.getOutputStream());
            // 响应数据的响应头数据，这行就是告诉对方我的响应消息也是满足HTTP协议的，版本是1.1，也就是告诉浏览器，请认可我
            ps.println("HTTP/1.1 200 OK");
            // 这是代表响应数据的类型是网页或者文本内容
            ps.println("Content-type:text/html;charset=UTF-8");
            // 必须换一行
            ps.println();
            // 打印数据
            ps.println("<span style='color:green;font-size:60px'>欢迎光临米奇妙妙屋</span>");
            ps.close();
        } catch (Exception e) {
            System.out.println("客户端：" + socket.getRemoteSocketAddress() + "下线了");
        }
    }

}
