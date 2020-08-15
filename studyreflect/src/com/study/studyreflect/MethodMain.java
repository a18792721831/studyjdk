package com.study.studyreflect;

import com.study.studyreflect.bean.People;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jiayq
 * @Date 2020/8/13
 */
public class MethodMain {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Class.forName("com.study.studyreflect.bean.People");
        People people = (People) clazz.newInstance();
        people.setName("小美");
        people.setAge(24);
        people.setNumber(78);
        System.out.println("-------------------public------------");
        Method sayPublic = clazz.getDeclaredMethod("say", null);
        sayPublic.setAccessible(true);
        System.out.println("public: " + sayPublic.invoke(people, null));
        System.out.println("-------------------private------------");
        Method sayPrivate = clazz.getDeclaredMethod("say", String.class);
        sayPrivate.setAccessible(true);
        System.out.println("private: " + sayPrivate.invoke(people, "小美:private"));
        System.out.println("-------------------protected------------");
        Method sayProtected = clazz.getDeclaredMethod("say", Integer.class);
        sayProtected.setAccessible(true);
        System.out.println("protected: " + sayProtected.invoke(people, 244));
        System.out.println("-------------------default------------");
        Method sayDefault = clazz.getDeclaredMethod("say", Double.class);
        sayDefault.setAccessible(true);
        System.out.println("default: " + sayDefault.invoke(people, 24.444));
        System.out.println("-------------------toString------------");
        Method toString = clazz.getDeclaredMethod("toString", null);
        toString.setAccessible(true);
        System.out.println("toString: " + toString.invoke(people, null));
    }

}
