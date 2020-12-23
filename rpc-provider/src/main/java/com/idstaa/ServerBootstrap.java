package com.idstaa;

        import com.idstaa.service.UserServiceImpl;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenjie
 * @date 2020/12/19 17:23
 */
@SpringBootApplication
public class ServerBootstrap {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ServerBootstrap.class,args);
        UserServiceImpl.startServer("127.0.0.1",8999);
    }
}
