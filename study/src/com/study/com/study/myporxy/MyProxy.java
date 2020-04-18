package com.study.com.study.myporxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author jiayq
 * @Date 2020-04-18
 */
public class MyProxy<T> implements InvocationHandler {

    private T target;

    public MyProxy(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("target class is " + target.getClass() + ", method is " + method.getName() +
                ", before, args is " + (args == null ? "" : args.toString()));
        Object result = method.invoke(target, args);
        System.out.println("target class is " + target.getClass() + ", method result is " + (result == null ? "" : result.toString()));
        return result;
    }
}
