package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：MyRemoteClient.java Date：2022/12/5 18:08 Version：1.0
 */
public class MyRemoteClient {

    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    private void go() {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/Remote Hello");
            String s = service.sayHello();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
