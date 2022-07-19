package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.通信相关.TCP通信;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *      测试图片上传功能-服务端程序
 *      1、接收多个客户端传输来的图片数据存储到服务器路径：G:\wangcheng\studyDir\图片服务器
 *      2、响应一个成功的消息给当前客户端
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestPicUploadServer.java Date：2022/7/19/019 22:53 Version：1.0
 */
public class TestPicUploadServer {

    public static final String DEST_FILE = "G:\\wangcheng\\studyDir\\图片服务器\\";

    private static final ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动");
        // 1、注册端口
        ServerSocket ss = new ServerSocket(7777);

        while (true) {
            // 2、开始等待接收客户端的socket管道连接，意思是客户端那边的socket要和服务端这边碰面，然后服务端接受连接，
            // 如果客户端那边还没有请求该服务端的ip和端口，这边会一直等待，即无socket管道请求时，这里会阻塞
            Socket socket = ss.accept();

            System.out.println("客户端" + socket.getRemoteSocketAddress() + "已连接~~");

            // 7、每接收一个客户端socket通信管道的连接请求，就开启一个线程执行，现改为线程池的方式处理任务
            executor.execute(new ServerUploadThread(socket));
        }
    }

}

class ServerUploadThread extends Thread {

    private final Socket socket;

    public ServerUploadThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 1、接收当前客户端发来的图片资源
            InputStream is = socket.getInputStream();
            // 2、包装成高级的缓冲字节输入流
            BufferedInputStream bis = new BufferedInputStream(is);
            // 3、从bis流中读取客户端发来的图片字节，写出到服务器仓库路径中去。即定义一个高级的缓冲字节输出流
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(TestPicUploadServer.DEST_FILE + UUID.randomUUID() + ".png"));
            byte[] bytes = new byte[1024];
            int len;
            // ！！需要注意这里，这里read因为是循环读，在socket通信流里，这里会一直阻塞的，即一直去尝试读取管道里新的数据，所以客户端那边
            // 要加个方法提示，即客户端那边输出完后，给这边一个提示，这边再调用read方法就会返回-1，程序才能继续往下走。否则走不到下面的响应客户端
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            bos.flush();
            bos.close();
            // 4、服务端响应接收成功的结果，即使用打印流包装字节输出流，打印字符出去，效率高
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.println("亲爱的客户端，我已经收到图片");
            // 5、这里要睡一下，不然这里线程执行完了，socket可能就被断了，客户端可能还没来得及收到服务端消息，就断开连接了
            Thread.sleep(10000);
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
