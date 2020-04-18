package com.study.com.study.myporxy;

/**
 * @author jiayq
 * @Date 2020-04-18
 */
public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("hello for hello impl");
    }

    @Override
    public String getHello() {
        return "hello for hello impl";
    }

    @Override
    public void sayHelloTo(String name) {
        System.out.println("hello for hello impl , " + name);
    }

    @Override
    public String helloWith(String name) {
        return "hello for hello impl, " + name;
    }
}
