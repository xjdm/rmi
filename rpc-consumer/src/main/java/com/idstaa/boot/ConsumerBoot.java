package com.idstaa.boot;

import com.idstaa.client.RPCConsumer;
import com.idstaa.service.IUserService;

/**
 * @author chenjie
 * @date 2020/12/18 17:10
 */
public class ConsumerBoot {
    // 参数定义
   // private static final String PROVIDER_NAME = "UserService#sayHello#";

    public static void main(String[] args) throws InterruptedException {

        // 1、创建代理对象
        RPCConsumer rpcConsumer = new RPCConsumer();
        IUserService service = (IUserService) rpcConsumer.createProxy(IUserService.class);

        // 2、循环给服务器写数据
        while(true) {
            String result = service.sayHello("ary you ok !!");
            System.out.println("已响应" + result);
            Thread.sleep(2000);
        }

    }
}
