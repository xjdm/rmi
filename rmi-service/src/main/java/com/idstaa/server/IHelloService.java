package com.idstaa.server;

import com.idstaa.pojo.User;

import java.rmi.Remote;

/**
 * @author chenjie
 * @date 2020/12/17 19:35
 */
public interface IHelloService extends Remote {
    // 1、定义一个sayHello方法
    public String sayHello(User user) throws Exception;
}
