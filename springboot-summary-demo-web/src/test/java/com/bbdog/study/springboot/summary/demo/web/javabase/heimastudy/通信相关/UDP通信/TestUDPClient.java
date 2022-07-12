package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.通信相关.UDP通信;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * <p>
 *      测试UDP协议传输数据包-客户端
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestUDPClient.java Date：2022/7/12/012 23:39 Version：1.0
 */
public class TestUDPClient {

    public static void main(String[] args) throws Exception {
        System.out.println("启动客户端");
        // 1、创建一个集装箱对象，用于封装需要发送的数据包。构造函数需要传四个参数：字节数组，发送数据的长度(utf-8中一个汉子占3个字节)，服务端ip(使用java的ip类)，服务端端口
        byte[] buffer = "今晚打老虎".getBytes();
        // 其中服务端的端口，到时候开发的时候再指定一下，启动后就可以访问该6666的端口
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 6666);

        // 2、创建一个码头对象(客户端这里可以指定端口，不指定时有个默认端口，同样服务端那边也是用此方法指定自己的端口为6666)
        DatagramSocket socket = new DatagramSocket(8888);
//        DatagramSocket socket = new DatagramSocket();

        // 3、开始发送数据包对象
        socket.send(packet);

        socket.close();

    }

}
