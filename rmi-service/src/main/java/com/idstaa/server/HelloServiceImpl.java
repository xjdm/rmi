package com.idstaa.server;

import com.idstaa.pojo.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author chenjie
 * @date 2020/12/17 19:36
 */
public class HelloServiceImpl extends UnicastRemoteObject implements IHelloService {
    public HelloServiceImpl() throws RemoteException {
    }

    public String sayHello(User user) throws Exception {
        System.out.println("this is server，say hello to "+ user.getUsername());
        return  "success";
    }
}
