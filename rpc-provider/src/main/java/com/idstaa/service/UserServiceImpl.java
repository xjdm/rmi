package com.idstaa.service;

import com.idstaa.handler.UserServiceHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author chenjie
 * @date 2020/12/18 16:21
 */
public class UserServiceImpl implements IUserService{
    public String sayHello(String msg) {
        System.out.println("are your ok ?"+ msg);
        return "are you ok ?" + msg;
    }

    public static void startServer(String ip,int port) throws InterruptedException {
        // 1、创建两个线程池对象
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        // 2、创建服务端的启动引导对象
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        // 3、配置启动引导对象
        serverBootstrap.group(bossGroup,workGroup)
                // 设置通道为NIO
                .channel(NioServerSocketChannel.class)
                // 创建监听channel
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel nioServerSocketChannel) throws Exception {
                        ChannelPipeline pipeline = nioServerSocketChannel.pipeline();
                        pipeline.addLast(new StringEncoder());
                        pipeline.addLast(new StringDecoder());
                        pipeline.addLast(new UserServiceHandler());
                    }
                });

        // 4、绑定端口
        serverBootstrap.bind(8999).sync();
    }
}
