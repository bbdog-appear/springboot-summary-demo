package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.通信相关.TCP通信;

import java.io.*;
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
 *      3、现在是修改后的版本，虽然能收到消息了，但是因为服务端这边是while循环，一直等待客户端发消息，但是客户端那边发一次消息就死了，然后服务端这边
 *      因为还在等待第二行消息，而这时候因为客户端死了，所以服务端也跟着死，再改进的话，可以把while改为if即可，即服务端接收一条后也死，就不会报错。
 *      4、改为循环发消息的方式，但是这种情况下，服务端只能接收一个客户端请求，即再启动一个客户端，发消息时，服务端接收不到消息的，原因是服务端的
 *      main方法Socket socket = ss.accept();在第一次客户端连接后就以后往后面执行了，第二个客户端建立socket连接时，这里1、2代码都不会跑到的
 *      5、再改为服务端可以接收多个客户端请求，即每来一个客户端请求，服务端这边开启一个线程执行，并发执行互不影响。
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

        while (true) {
            // 2、开始等待接收客户端的socket管道连接，意思是客户端那边的socket要和服务端这边碰面，然后服务端接受连接，
            // 如果客户端那边还没有请求该服务端的ip和端口，这边会一直等待，即无socket管道请求时，这里会阻塞
            Socket socket = ss.accept();

            // 7、每接收一个客户端socket通信管道的连接请求，就开启一个线程执行
            new ServerReadThread(socket).start();
        }
    }

}

class ServerReadThread extends Thread {

    private final Socket socket;

    public ServerReadThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
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
                System.out.println("服务端收到客户端：" + socket.getRemoteSocketAddress() + "的消息：" + msg);
            }
        } catch (Exception e) {
            /* 这里一般是某个客户端下线了，然后这边的socket管道肯定就断了，即抓到客户端下线异常。那抓到异常后，这个线程(客户端请求)肯定跑结束了
            * 但是一定要注意要把socket资源关闭，如果这里不关闭，可以看到虽然这个线程跑完了，即线程对象ServerReadThread被销毁了，其中该对象的
            * 实例变量socket肯定也会被垃圾回收掉，但是原来线程外面的socket对象，其实还有引用指向的(因为外层的方法没跑完，是个死循环)，那么这样
            * 就造成原来客户端的socket对象请求一直不会被回收，久而久之socket对象越来越多，造成内存泄漏，会导致系统oom。因此这里线程跑完后应该
            * 关闭socket资源 */
            System.out.println("客户端：" + socket.getRemoteSocketAddress() + "下线了");
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
