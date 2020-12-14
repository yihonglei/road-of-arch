package com.jpeony.design.patterns.proxy.demo1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author yihonglei
 */
public interface MyRemote extends Remote {
    String sayHello() throws RemoteException;
}
