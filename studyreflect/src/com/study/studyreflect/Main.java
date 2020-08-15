package com.study.studyreflect;

import com.study.studyreflect.bean.Testttttt;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author jiayq
 * @Date 2020/8/14
 */
public class Main {

    public static void main(String[] args) {
        Class clazz = Testttttt.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        Arrays.asList(declaredFields).stream().forEach(x-> System.out.println(x.getName()));
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        Arrays.asList(declaredConstructors).stream().forEach(x-> System.out.println(x.getName()));
    }

}
