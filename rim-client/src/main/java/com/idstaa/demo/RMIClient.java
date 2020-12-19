package com.idstaa.demo;

import com.idstaa.pojo.User;
import com.idstaa.server.IHelloService;

import java.rmi.Naming;

/**
 * @author chenjie
 * @date 2020/12/17 19:52
 */
public class RMIClient {
    public static void main(String[] args) throws Exception {
        // 1、从注册表中获取远程对象，强转
        IHelloService service = (IHelloService) Naming.lookup("//127.0.0.1:8888/rmiserver");

        // 2、准备参数
        User user = new User("laowang", 18);

        // 3、调用远程方法sayHello
        String message = service.sayHello(user);
        System.out.println(message);
    }
}
