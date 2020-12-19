package com.idstaa.boot;

import com.idstaa.service.UserServiceImpl;

/**
 * @author chenjie
 * @date 2020/12/18 16:32
 */
public class ServerBoot {
    public static void main(String[] args) throws InterruptedException {
        UserServiceImpl.startServer("127.0.0.1",8999);
    }
}
