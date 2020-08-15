package com.study.studyannotation;

import com.study.studyannotation.anno.*;
import com.study.studyannotation.beans.Man;
import com.study.studyannotation.beans.People;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiayq
 * @Date 2020/8/14
 */
public class Main {

    public static void main(String[] args) {

        People people = new People("xiaomeiS");
        Man man = new Man("hah");
        parse(Arrays.asList(people.getClass().getDeclaredAnnotations()), StudyAnno.class);
        parse(Arrays.asList(man.getClass().getDeclaredAnnotations()), StudyAnno.class);
        parse(Arrays.asList(people), StudyClass.class);
        parse(Arrays.asList(man), StudyClass.class);
        parse(Arrays.asList(people.getClass().getDeclaredConstructors()), StudyCons.class);
        parse(Arrays.asList(man.getClass().getDeclaredConstructors()), StudyCons.class);
        parse(Arrays.asList(people.getClass().getDeclaredFields()), StudyField.class);
        parse(Arrays.asList(man.getClass().getDeclaredFields()), StudyField.class);
//        parse(people, StudyMethod.class);
//        parse(man, StudyMethod.class);
//        parse(people, StudyParam.class);
//        parse(man, StudyParam.class);
//        parse(people, StudyVar.class);
//        parse(man, StudyVar.class);

    }

    private static void parse(List list, Class annClazz) {
        list.stream().filter(x-> x!= null).distinct().forEach(object -> {
            // 获取使用注解的对象 (people)
            Class clazz = object.getClass();
            // 获取使用注解的对象上面的注解 (StudyClass对象)
            Annotation declaredAnnotation = clazz.getDeclaredAnnotation(annClazz);
            // 判断是否存在继承的注解，如果有继承的注解，那么获取继承的注解对象，否则是null
            Annotation annotation = clazz.isAnnotationPresent(annClazz) ? clazz.getAnnotation(annClazz) : null;
            // 将本身的注解和继承的注解的对象，进行流化，然后去重，去除null，最后遍历处理
            Arrays.asList(declaredAnnotation, annotation).stream().distinct().filter(x -> x != null).forEach(x -> {
                try {
                    // 获取注解对象中的注解元素 (name方法)
                    Method name = x.getClass().getDeclaredMethod("name", null);
                    // 执行注解元素，获取注解元素值 ("people")
                    Object nameValue = name.invoke(x, null);
                    // 获取到注解元素值之后做的操作
                    System.out.println("parseClass class = " + clazz.getSimpleName() + " , "+annClazz.getSimpleName()+" , name = " + nameValue);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        });
    }
}
