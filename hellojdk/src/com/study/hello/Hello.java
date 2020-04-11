package com.study.hello;

/**
 * @author jiayq
 * @Date 2020-02-03
 */
public class Hello {

    public static void main(String[] args) {

        Hello hello = new Hello();
        Hello hello1 = new Hello();
        System.out.println(hello.hashCode());
        System.out.println(hello1.hashCode());

    }

}
