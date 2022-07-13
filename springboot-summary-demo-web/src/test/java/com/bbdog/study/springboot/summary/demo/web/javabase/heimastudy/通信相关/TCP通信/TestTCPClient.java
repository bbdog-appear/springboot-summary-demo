package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.通信相关.TCP通信;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * <p>
 *      测试TCP协议写出数据实现方式-客户端
 *      1、这里注意不要关闭socket管道，因为本来这就是一种TCP连接，关闭了这个管道，相当于两边的socket都死了，即不能通信了
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestTCPClient.java Date：2022/7/13/013 23:52 Version：1.0
 */
public class TestTCPClient {

    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动");
        // 1、客户端要请求与服务端的socket管道连接(看了源码，其实最终底层调native方法去建立与服务端的socket连接)，
        // 即客户端和服务端现在是用一根socket管道连接在，使用TCP协议
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        // 2、从socket通信管道中得到一个字节输出流，看了源码os引用实际上指向的是SocketOutputStream对象，是一个低级流，
        // 这个流其实是通向上面的socket管道的，即用该低级输出流写出的数据是流向socket管道里的，
        // 然后服务端那边到时候通过字节输入流读取这个socket管道里的数据，然后用高级流包装一下转化为字符
        OutputStream os = socket.getOutputStream();

        // 3、把低级流的字节输出流包装成高级的打印流，这里把上面的os对象即低级的字节输出流包装一下，ps执行时，实际上就是执行os对象里的方法，
        // 即还是执行上面的那个对象的方法，最终会把数据流向socket管道
        PrintStream ps = new PrintStream(os);
        // 4、开始发消息出去
        ps.println("我是客户端，我发送一条消息：今晚打老虎");
        ps.flush();
        System.out.println("客户端发送完毕");
    }

}
