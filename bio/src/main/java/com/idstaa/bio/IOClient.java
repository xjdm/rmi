package com.idstaa.bio;
import java.io.IOException;
import java.net.Socket;

/**
 * @author chenjie
 * @date 2020/12/18 8:46
 */
public class IOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8081);
        socket.getOutputStream().write("hello".getBytes());
        socket.getOutputStream().flush();
        System.out.println("server send back data ====");
        byte[] bytes = new byte[1024];
        int len = socket.getInputStream().read(bytes);
        System.out.println(new java.lang.String(bytes,0,len));
        socket.close();
    }
}
