package com.study.studyannotation;

import com.study.studyannotation.anno.*;
import com.study.studyannotation.beans.Man;
import com.study.studyannotation.beans.People;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
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
        // getDeclaredAnnotations:获取直接标注在指定对象上面的注解
        // getAnnotations:获取指定对象上面的注解(可以获取继承的注解)
        parseAnno(people);
        parseAnno(man);
        System.out.println();
        parseClass(people);
        parseClass(man);
        System.out.println();
        parseCons(people);
        parseCons(man);
        System.out.println();
        parseField(people);
        parseField(man);
        System.out.println();
        parseMethod(people);
        parseMethod(man);
        System.out.println();
        parseParam(people);
        parseParam(man);
    }

    /**
     * 解析组合注解
     *
     * @param object 普通对象
     */
    private static void parseAnno(Object object) {
        // 获取普通的所有的注解
        Arrays.stream(object.getClass().getAnnotations()).filter(x -> x != null).forEach(x -> {
            // 获取注解的注解对象
            // 注意，这里不能使用反射。因为注解本质上是接口，所以，实际使用中，都是代理对象，当你使用反射获取的时候，获取得到的代理对象，这个代理对象没有注解信息了
            // 使用annotationType方法，获取的是带有注解信息的注解对象(代理对象)
            // 将含有注解信息的代理对象进行解析
            parse(x.annotationType(), StudyAnno.class, object.getClass());
        });
    }

    /**
     * 解析类
     *
     * @param object 普通对象
     */
    private static void parseClass(Object object) {
        // 获取普通对象的class对象
        parse(object.getClass(), StudyClass.class, object.getClass());
    }

    /**
     * 解析参数
     *
     * @param object
     */
    private static void parseParam(Object object) {
        // 获取普通对象的构造器、方法(全部可以有参数的方法)
        Constructor<?>[] declaredConstructors = object.getClass().getDeclaredConstructors();
        Method[] declaredMethods = object.getClass().getDeclaredMethods();
        Arrays.stream(declaredConstructors).filter(x -> x != null).forEach(x -> {
            // 获取参数
            Arrays.stream(x.getParameters()).filter(y -> y != null).forEach(y -> parse(y, StudyParam.class, object.getClass()));
        });
        Arrays.stream(declaredMethods).filter(x -> x != null).forEach(x -> {
            // 获取参数
            Arrays.stream(x.getParameters()).filter(y -> y != null).forEach(y -> parse(y, StudyParam.class, object.getClass()));
        });
    }

    /**
     * 解析构造
     *
     * @param object
     */
    private static void parseCons(Object object) {
        // 获取普通对象的Constructor对象
        Arrays.stream(object.getClass().getDeclaredConstructors()).filter(x -> x != null).forEach(x -> parse(x, StudyCons.class, object.getClass()));
    }

    /**
     * 解析属性
     *
     * @param object
     */
    private static void parseField(Object object) {
        // 获取对象的全部属性对象
        Arrays.stream(object.getClass().getDeclaredFields()).filter(x -> x != null).forEach(x -> parse(x, StudyField.class, object.getClass()));
    }

    /**
     * 解析方法
     *
     * @param object
     */
    private static void parseMethod(Object object) {
        // 获取对象的全部方法
        Arrays.stream(object.getClass().getDeclaredMethods()).filter(x -> x != null).forEach(x -> parse(x, StudyMethod.class, object.getClass()));
    }

    /**
     * 记录日志
     *
     * @param annotatedElement
     * @param annClass
     * @param objClass
     */
    private static void parse(AnnotatedElement annotatedElement, Class annClass, Class objClass) {
        System.out.println("---------- parse\t" + annClass.getSimpleName() + ":\t" + objClass.getSimpleName() + "----------");
        parse(annotatedElement, annClass);
    }

    /**
     * 注解解析
     *
     * @param annotatedElement 需要处理的AnnotatedElement对象
     * @param annClazz         需要处理的注解类型
     */
    private static void parse(AnnotatedElement annotatedElement, Class annClazz) {
        // 获取使用注解的对象上面的注解 (StudyClass对象)
        Annotation declaredAnnotation = annotatedElement.getAnnotation(annClazz);
        // 判断是否存在继承的注解，如果有继承的注解，那么获取继承的注解对象，否则是null
        Annotation annotation = annotatedElement.isAnnotationPresent(annClazz) ? annotatedElement.getAnnotation(annClazz) : null;
        // 将本身的注解和继承的注解的对象，进行流化，然后去重，去除null，最后遍历处理
        Arrays.asList(declaredAnnotation, annotation).stream().distinct().filter(x -> x != null).forEach(x -> {
            // 获取注解对象中的注解元素 (name方法)
            // 注解中的方法都是没有参数的
            // 同时因为代理对象的缘故，还需要去掉Object的2个无参公共方法:toString,hashCode,以及class的annotationType方法
            List<String> methodList = Arrays.asList("toString", "hashCode", "annotationType");
            Arrays.stream(x.getClass().getDeclaredMethods()).filter(y -> y.getParameterCount() == 0)
                    .filter(y -> !methodList.contains(y.getName()))
                    .forEach(y -> {
                        // 执行注解元素，获取注解元素值 ("people")
                        try {
                            Object nameValue = y.invoke(x, null);
                            System.out.println(annClazz.getSimpleName() + " , " + y.getName() + " = " + nameValue);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        // 获取到注解元素值之后做的操作
                    });
        });
    }
}
