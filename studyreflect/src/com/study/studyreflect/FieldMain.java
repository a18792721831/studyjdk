package com.study.studyreflect;

import com.study.studyreflect.bean.People;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author jiayq
 * @Date 2020/8/13
 */
public class FieldMain {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
//        People people = new People();
//        Class clazz = Class.forName("com.study.studyreflect.bean.People");
//        System.out.println("------------setName----------------");
//        Field name = clazz.getDeclaredField("name");
//        name.setAccessible(true);
//        name.set(people, "小美");
//        System.out.println("------------setAge-----------------");
//        Field age = clazz.getDeclaredField("age");
//        age.setAccessible(true);
//        age.set(people, 22);
//        System.out.println("------------setNumber-----------------");
//        Field number = clazz.getDeclaredField("number");
//        number.setAccessible(true);
//        number.setInt(people, 88);
//        System.out.println("------------testPublic-----------------");
//        Field testPublic = clazz.getDeclaredField("testPublic");
//        testPublic.setAccessible(true);
//        testPublic.set(people,"test##public");
//        System.out.println("------------testprivate-----------------");
//        Field testPrivate = clazz.getDeclaredField("testPrivate");
//        testPrivate.setAccessible(true);
//        testPrivate.set(people,"test##private");
//        System.out.println("------------testProtected-----------------");
//        Field testProtected = clazz.getDeclaredField("testProtected");
//        testProtected.setAccessible(true);
//        testProtected.set(people, "test##protected");
//        System.out.println("------------testDefault-----------------");
//        Field testDefault = clazz.getDeclaredField("testDefault");
//        testDefault.setAccessible(true);
//        testDefault.set(people, "test##Default");
//        System.out.println(people);
        Class clazz = Class.forName("com.study.studyreflect.bean.People");
        int summer = 10;
        Object[] objects = new Object[summer];
        for (int i = 0; i < summer; i++) {
            Object instance = clazz.newInstance();
            Field name = clazz.getDeclaredField("name");
            name.setAccessible(true);
            name.set(instance, "小美"+i);
            objects[i] = instance;
        }
        Arrays.asList(objects).stream().forEach(System.out::println);
    }

}
