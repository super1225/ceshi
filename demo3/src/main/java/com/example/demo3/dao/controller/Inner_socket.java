package com.example.demo3.dao.controller;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

//@Component
public class Inner_socket {
    //@PostConstruct
    public static int web() {

        try
        {
            //System.out.println("Hello World!");
            HelloService remoteService = SimpleRpc.getRemoteService( HelloService.class, "10.42.3.106", 1000);
            String str = remoteService.hello("DW服务正常");
            System.out.println(str);
            HelloService remoteService1 = SimpleRpc.getRemoteService( HelloService.class, "10.42.3.37", 8999);
            String str1 = remoteService1.hello("YC服务正常");
            System.out.println(str1);
            HelloService remoteService2 = SimpleRpc.getRemoteService( HelloService.class, "10.42.3.38", 8);
            String str2 = remoteService2.hello("BK服务正常");
            System.out.println(str2);

            return 0;
        }
        catch (Exception e)
        {
            System.out.println("服务异常");
            return 1;
        }


    }
}