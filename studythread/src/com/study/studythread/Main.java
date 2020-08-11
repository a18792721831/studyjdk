package com.study.studythread;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * @author jiayq
 * @Date 2020/6/17
 */
public class Main {

    private static List sortByNatural(List list) {
        Collections.sort(list, Collator.getInstance(Locale.CHINA));
        return list;
    }

    public static void main(String[] args) {
        List list = Arrays.asList("张三", "李四", "王五", "赵六", "JAVA", "123",
                "$%$#", "哈哈A", "1哈哈A", "1哈哈b", "1哈哈a", "哈哈", "哈", "怡情");
        System.out.println(sortByNatural(list));
        list = Arrays.asList("张三", "(张三", "（张三", "李四", "王五", "赵六", "JAVA", "123",
                "$%$#", "哈哈A", "1哈哈A", "1哈哈b", "1哈哈a", "哈哈", "哈", "怡情");
        System.out.println(sortByNatural(list));

        System.out.println("（".charAt(0));
    }

}
