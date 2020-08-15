package com.study.studyreflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author jiayq
 * @Date 2020/8/13
 */
public class ConstructorMain {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Class.forName("com.study.studyreflect.bean.People");
        Constructor defaultCon = clazz.getDeclaredConstructor(null);
        defaultCon.setAccessible(true);
        Object defaultInstance = defaultCon.newInstance(null);
        System.out.println(defaultInstance);
        Constructor stringCon = clazz.getDeclaredConstructor(String.class);
        stringCon.setAccessible(true);
        Object xiao = stringCon.newInstance("小丽");
        System.out.println(xiao);
    }

}
