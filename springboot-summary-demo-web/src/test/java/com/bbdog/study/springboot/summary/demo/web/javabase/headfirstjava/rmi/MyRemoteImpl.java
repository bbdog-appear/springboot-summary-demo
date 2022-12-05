package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：MyRemoteImpl.java Date：2022/12/5 16:12 Version：1.0
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    public MyRemoteImpl () throws RemoteException{

    }

    @Override
    public String sayHello() throws RemoteException {
        return "Server says , Hey ";
    }

    public static void main(String[] args) throws Exception {
        MyRemote service = new MyRemoteImpl();
        Naming.rebind("Remote Hello", service);
    }

}
