package com.idstaa.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenjie
 * @date 2020/12/18 8:46
 */
public class IOServer {
    public static void main(String[] args) throws IOException {
        // 首先创建一个serverSocket
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("127.0.0.1",8081));
        while (true){
            // 同步阻塞
            Socket socket = serverSocket.accept();
            new Thread(()-> {
                try {
                   byte[] bytes = new byte[1024];
                    int len = socket.getInputStream().read(bytes);
                    System.out.println(new String(bytes,0,len));
                    socket.getOutputStream().write(bytes,0,len);
                    socket.getOutputStream().flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
