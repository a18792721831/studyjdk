package com.study.mystring;

/**
 * @author jiayq
 * @Date 2020-04-18
 */
public class MyString {

    public static void main(String[] args){

        /**
         * one -> 字符串常量池
         * two -> 字符串常量池
         */
//        String one = "one";
//        String two = "one";
//        System.out.println(one == two);
//        true

        /**
         * two -> 堆空间 | 字符串常量池 -> 引用
         * one -> 堆空间 | 字符串常量池 -> 引用
         */
//        String two = new String("one");
//        String one = new String("one");
//        System.out.println(one == two);
//        false

        /**
         * one -> 字符串常量池
         * two -> 堆空间 -> 字符串常量池
         */
//        String one = "one";
//        String two = new String("one");
//        System.out.println(one == two);
//        false

        /**
         * two -> 堆空间 | 字符串常量池 -> 引用
         * one -> 字符串常量池
         */
//        String two = new String("one");
//        String one = "one";
//        System.out.println(one == two);
//        false

        /**
         * two -> 堆空间 | 字符串常量池 -> 引用
         * two -> 字符串常量池 引用 | 引用 -> 堆空间 |return 字符串常量池 -> 引用
         * one -> 字符串常量池 值 | 值 -> "one"
         */
//        String two = new String("one");
//        String three = two.intern();
//        System.out.println(two.intern() == two);
//        String one = "one";
//        System.out.println(one == three);

        /**
         * two -> 堆空间 | 字符串常量池 -> 引用
         * one -> 字符串常量池 值 | 值 -> "one"
         * two -> 字符串常量池 引用 | 引用 -> 堆空间 |return 字符串常量池 -> 值
         */
//        String two = new String("one");
//        String one = "one";
//        String three = two.intern();
//        System.out.println(two.intern() == two);
//        System.out.println(one == three);

        /**
         * two -> 堆空间 | 字符串常量池 -> 引用
         * two -> 字符串常量池 引用 | 引用 -> 堆空间
         * one -> 字符串常量池 值 | 值 -> "one"
         */
//        String two = new String("one");
//        String one = "one";
//        System.out.println(one == two.intern());
//        true

        /**
         * two -> 堆空间
         * two -> 字符串常量池 引用 | 引用 -> 堆空间
         * one -> 堆空间
         */
//        String two = new String("one");
//        two.intern();
//        String one = new String("one");
//        System.out.println(one == two);
//        false

        /**
         * two -> 堆空间
         * two -> 字符串常量池 引用 | 引用 -> 堆空间
         * one -> 堆空间
         * one -> 字符串常量池 已有 | 什么也不做
         */
//        String two = new String("one");
//        two.intern();
//        String one = new String("one");
//        one.intern();
//        System.out.println(one == two);
//        false

        /**
         * one -> 字符串常量池 | 编译优化 one = "one"
         * two -> 字符串常量池 | 与one地址相同
         */
//        String one = "o" + "n" + "e";
//        String two = "one";
//        System.out.println(one == two);
//        true

        /**
         * one -> 字符串常量池 | 编译优化
         * two -> StringBuilder.append() -> 堆空间 | 此时
         */
//        String one = "o" + "n" + "e";
//        String two = new String("o") + new String("n") + new String("e");
//        String three = new StringBuilder().append("o").append("n").append("e").toString();
//        System.out.println(one.intern() == one);
//        System.out.println(one == two);
//        System.out.println(one.intern() == two);
//        System.out.println(one == three);
//        System.out.println(one.intern() == three);
//        System.out.println(two.intern() == two);
//        System.out.println(one == two);
//        System.out.println(two == three);
//        System.out.println(two.intern() == three);
//        System.out.println(three.intern() == three);
//        System.out.println(one.intern() == two.intern());
//        System.out.println(one.intern() == three.intern());
//        System.out.println(two.intern() == three.intern());
//        false

//        String two = new String("oo") + new String("nn") + new String("ee");
//        String one = "oo" + "nn" + "ee";
//        String three = new StringBuilder().append("oo").append("nn").append("ee").toString();
//        System.out.println(one.intern() == one);
//        System.out.println(one == two);
//        System.out.println(one.intern() == two);
//        System.out.println(one == three);
//        System.out.println(one.intern() == three);
//        System.out.println(two.intern() == two);
//        System.out.println(one == two);

//        String two = new String("one") + new String("two");
//        String one = "onetwo";
//        System.out.println(two.intern() == two);
//        System.out.println(one == two);

//        String two = new String("one") + new String("two");
//        two.intern();
//        String one = "onetwo";
//        System.out.println(two.intern() == two);
//        System.out.println(one == two);
//        true

        String two = new String("one") + new String("two");
//堆空间创建："one","two","onetwo"
        String one = "onetwo";//字符串常量池已有(引用)
        two.intern();//将"onetwo"放入字符串常量池(引用)
        System.out.println(two.intern() == two);//字符串常量池中存储的是引用，引用堆空间地址
        System.out.println(two.intern() == one);
//true
        System.out.println(one == two);//字符串常量池中的引用，引用的对象是堆空间对象
//true


//        String two = new String("one") + new String("two");
//        String one = "onetwo";
//        System.out.println(two.intern() == two);
//        System.out.println(two.intern() == one);
//        System.out.println(one == two);

//        String two = new String("one") + new String("two");
//        String one = "onetwo";
//        System.out.println(one == two);
//        false

//        String one = "onetwo";
//        String two = new String("one") + new String("two");
//        System.out.println(one == two);
//        false

    }

}
