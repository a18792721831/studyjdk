package com.study.studyreflect;

import com.study.studyreflect.bean.People;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author jiayq
 * @Date 2020/8/13
 */
public class ClassMain {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz1 = People.class;
        People people = new People();
        Class clazz2 = people.getClass();
        Class clazz3 = Class.forName("com.study.studyreflect.bean.People");
        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
        Method[] methods = clazz1.getMethods();
        System.out.println("--------------------class----------------------------");
        Arrays.asList(methods).stream().forEach(x->
                System.out.println("class: " + x.getClass()+",name: " + x.getName() + ",parameter: " + x.getParameters().toString()+",returnType: " + x.getReturnType()));
        System.out.println("--------------------public field----------------------------");
        Field[] fields = clazz1.getFields();
        Arrays.asList(fields).stream().forEach(x->
                System.out.println("class: " + x.getClass() + ",name: " + x.getName() + ",type: " + x.getType()));
        System.out.println("--------------------all field----------------------------");
        Field[] declaredFields = clazz1.getDeclaredFields();
        Arrays.asList(declaredFields).stream().forEach(x->
                System.out.println("class: " + x.getClass() + ",name: " + x.getName() + ",type: " + x.getType() + ",getDeclaringClass: " + x.getDeclaringClass()));
        System.out.println("--------------------annotations----------------------------");
        Annotation[] annotations = clazz1.getAnnotations();
        Arrays.asList(annotations).stream().forEach(x->
                System.out.println("class: " + x.getClass() + ",type: " + x.annotationType()));
        System.out.println("--------------------interface----------------------------");
        Class[] interfaces = clazz1.getInterfaces();
        Arrays.asList(interfaces).stream().forEach(x->
                System.out.println("class: " + x.getClass() + ",name: " + x.getName() + ",typeName: " + x.getTypeName()));
    }

}
