package com.study.com.study.myporxy;

import java.lang.reflect.Proxy;

/**
 * @author jiayq
 * @Date 2020-04-18
 */
public class ProxyMain {

    public static void main(String[] args){
        Hello hello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(),
                HelloImpl.class.getInterfaces(), new MyProxy<Hello>(new HelloImpl()));
        hello.sayHello();
        System.out.println();
        hello.sayHelloTo("小美");
        System.out.println();
        System.out.println(hello.getHello());
        System.out.println();
        System.out.println(hello.helloWith("小美"));
    }

}
