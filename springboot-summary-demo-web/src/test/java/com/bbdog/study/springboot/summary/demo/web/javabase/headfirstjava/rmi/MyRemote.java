package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：MyRemote.java Date：2022/12/5 15:59 Version：1.0
 */
public interface MyRemote extends Remote {

    String sayHello() throws RemoteException;

}
