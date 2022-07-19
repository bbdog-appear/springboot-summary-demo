package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.通信相关.TCP通信;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * <p>
 *      测试图片上传功能-客户端程序
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestPicUpload.java Date：2022/7/19/019 22:51 Version：1.0
 */
public class TestPicUploadClient {

    private static final String SRC_IMAGE = "G:\\wangcheng\\studyDir\\clipboard.png";

    public static void main(String[] args) throws Exception {
        // 1、请求与服务端的socket通信管道。需要重视的是这根socket管道是该客户端本次执行的线程与服务端建立的一个通道，通道两端都可以获得
        // 输入、输出流，客户端可以通过输出流发送信息给socket管道，服务端可以通过输入流从该根socket管道读取信息，同样服务端可以通过输出流
        // 发送信息给这根socket管道，客户端可以通过输入流从该根socket管道中读取数据，这其中的来来回回，用的都是这同一根socket管道，即
        // 这个客户端的线程发过去的数据，服务端返回回来的依然是走到原来的线程中去，不会发生线程间的数据错乱！即如果别的线程里服务端返回的数据
        // ，数据是放在那个线程对应的socket管道里的，自己的这个线程如果没有收到消息，会一直等待的，所以请求过去的数据，返回回来肯定还是走到该线程。
        // 自己猜想的可能每个客户端的某一个线程执行时，都会new一个socket管道，服务端那边也会接到该socket管道请求，线程跑完后被回收，
        // 该socket管道应该也会被回收，不会造成出现大量的线程的情况(即cpu占用率高)，socket对象被回收，也不会一直占用内存。
        Socket socket = new Socket(InetAddress.getLocalHost(), 7777);

        // 2、从socket管道中获取字节输出流
        OutputStream os = socket.getOutputStream();

        // 3、把字节输出流包装成高级的缓冲字节输出流
        BufferedOutputStream bos = new BufferedOutputStream(os);

        // 4、读取本地上传文件，写出到bos流，即复制。定义一个字节缓冲输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(SRC_IMAGE));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bos.flush();
        // 本地流管道可以关闭，但是通信流管道不要随便关闭，因为关闭socket通信流管道后，管道可能就死了，客户端和服务端就断开连接了
        bis.close();
        // 这里客户端如果输出完数据，就要通知服务端数据已经发送完，那么服务端那边就不会一直等待了
        socket.shutdownOutput();
        System.out.println("传输图片数据完毕");

        // 5、接下来需要服务端给该客户端一个回应，那么还是用这根socket管道，不用再从服务端那里请求一根新的socket管道到客户端了，
        // 即每个线程(客户端执行，调用服务端，服务端返回，客户端再执行，这可以看成是一个线程)用一根管道即可。所以客户端还要接收客户端的数据，
        // 即从该根管道里获取字节输入流，并读取服务端响应的消息数据。这里的输入流也是一样，如果服务端那边还没有发响应消息，这个输入流会一直等待的，
        // 因为socket管道里的输入流就有这个等待的属性，即socket通信管道里的输入输出流之间是有誓言的。所以这里使用高级的字符输入流包一下socket
        // 里的字节输入流，只要那边服务端往管道里发数据，这里的read方法就会从阻塞状态变为执行状态，这就跟我们的Pegasus调用一样，a调用b，b返回
        // 回来数据后，a服务立马就会接受到，并执行后续的代码，这其中客户端都在一个线程中请求和返回数据的。
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 如上所说，这里如果没读到消息，会一直阻塞的，当读到一次消息，该方法执行，到最后执行结束。如果用while循环，这里一样的，没有消息时阻塞，
        // 有消息时执行，并进入下一次循环，然后再读socket管道中的消息，如果没有新的消息，那么会阻塞，如果有新的消息，就会执行。
        String response = br.readLine();
        System.out.println(response);
    }

}
