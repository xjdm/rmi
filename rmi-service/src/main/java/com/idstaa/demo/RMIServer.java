package com.idstaa.demo;



import com.idstaa.pojo.User;
import com.idstaa.server.HelloServiceImpl;
import com.idstaa.server.IHelloService;


import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;


/**
 * @author chenjie
 * @date 2020/12/17 19:40
 */
public class RMIServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        // 1、创建HelloService实例
        IHelloService service = new HelloServiceImpl();

        // 2、获取注册表
        LocateRegistry.createRegistry(8888);

        // 3、对象的绑定
        Naming.bind("//127.0.0.1:8888/rmiserver",service);
    }
}
