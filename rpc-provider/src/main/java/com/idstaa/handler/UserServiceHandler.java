package com.idstaa.handler;

import com.idstaa.service.RpcRequest;
import com.idstaa.service.UserServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.beans.BeansException;
import org.springframework.cglib.reflect.FastClass;
import org.springframework.cglib.reflect.FastMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

/**
 * 自定义业务处理器
 * @author chenjie
 * @date 2020/12/18 16:27
 */
@Component
public class UserServiceHandler extends ChannelInboundHandlerAdapter implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    // 当客户端读取数据是，该方法会别调用
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 注意： 客户端将来发送请求的时候会传递一个参数：UserService#sayHello#are you ok
        // 1、判断当前的请求是否符合规则
       /* if(msg.toString().startsWith("UserService")){
            // 2、如果符合规则，调用实现类到一个result
            UserServiceImpl userService = new UserServiceImpl();
            // 3、把调用实现类的方法获得的结果写到客户端
            String result = userService.sayHello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
            ctx.writeAndFlush(result);
        }*/

        RpcRequest rpcRequest = (RpcRequest) msg;
        Object handler = handler(rpcRequest);
        ctx.writeAndFlush("success");
    }

    private Object handler(RpcRequest rpcRequest) throws ClassNotFoundException, InvocationTargetException {
        // 使用Class.forName 进行加载Class文件
        Class<?> clazz = Class.forName(rpcRequest.getClassName());
        Object serviceBean = applicationContext.getBean(clazz);
        Class<?> serviceClass = serviceBean.getClass();
        String methodName = rpcRequest.getMethodName();
        Class<?>[] parameterTypes = rpcRequest.getParameterTypes();
        Object[] parameters = rpcRequest.getParameters();
        FastClass fastClass = FastClass.create(serviceClass);
        FastMethod fastMethod = fastClass.getMethod(methodName, parameterTypes);
        return fastMethod.invoke(serviceBean,parameters);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
