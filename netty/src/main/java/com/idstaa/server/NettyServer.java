package com.idstaa.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author chenjie
 * @date 2020/12/18 9:54
 * 接收客户端请求，打印在控制台
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        // 1、创建2个线程池对象
        // bossGroup负责接收用户连接
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        // workerGroup 负责处理用户的io读写操作
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();


        // 2、创建启动引导类
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        // 3、设置启动引导类
        // 添加到组中，两个线程池，第一个位置的线程就负责接收，第二个参数就负责读写
        serverBootstrap.group(bossGroup, workerGroup)
                // 给我们当前设置一个通道类型
                .channel(NioServerSocketChannel.class)
                // 绑定一个初始化监听
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    // 事件监听Channel通道
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        // 获取pipeLine
                        ChannelPipeline pipeline = nioSocketChannel.pipeline();
                        // 绑定编码
                        pipeline.addFirst(new StringEncoder());
                        pipeline.addLast(new StringDecoder());
                        // 绑定业务逻辑
                        pipeline.addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
                                // 获取入栈信息，打印客户端传递的数据
                                System.out.println(msg);
                            }
                        });

                    }
                });

        // 4、启动引导类绑定端口
        ChannelFuture future = serverBootstrap.bind(9999).sync();
        // 5、关闭通道
        future.channel().closeFuture();
    }
}
