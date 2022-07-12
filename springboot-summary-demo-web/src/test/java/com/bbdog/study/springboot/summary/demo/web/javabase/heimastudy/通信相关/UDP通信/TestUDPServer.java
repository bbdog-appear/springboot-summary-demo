package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.通信相关.UDP通信;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * <p>
 *      测试UDP协议接收数据包-服务端
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestUDPServer.java Date：2022/7/12/012 23:39 Version：1.0
 */
public class TestUDPServer {

    public static void main(String[] args) throws Exception {
        System.out.println("启动服务端程序");
        // 1、创建一个接收客户端的数据包对象，其中接收的桶的大小最大是64KB。即客户端发来的数据，服务端通过端口监听到之后，是把数据放到了我们定义的buffer字节数组里的
        byte[] buffer = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        // 2、创建一个接收端的码头对象
        DatagramSocket socket = new DatagramSocket(6666);

        // 3、接收数据包。这里如果没有监听到客户端的请求时，这里是阻塞等待的，如果监听到客户端的请求，这里就会执行，把数据放入buffer中，然后就执行下一行代码了。
        socket.receive(packet);

        // 4、输出数据(其实就跟dubbo调用一样，调用方发送数据，先序列化成一串数据，再用字节输出流输出出去，然后接收方通过字节输入流读取信息放到这个字节数组里)。packet有个api是获取实际接收的字节数
        String msg = new String(buffer, 0, packet.getLength());
        System.out.println("接收的数据是：" + msg);

        // 5、服务端还可以获取发来信息的客户端的ip和端口。是从包里拿的，因为是包装的所有客户端的信息
        String hostAddress = packet.getAddress().getHostAddress();
        int port = packet.getPort();
        System.out.println("获取客户端的ip和端口为：" + hostAddress + ":" + port);

        socket.close();

    }

}
