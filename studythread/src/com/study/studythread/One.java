package com.study.studythread;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiayq
 * @Date 2020/6/30
 */
public class One {

    public static void main(String[] args) {
        String value = "1:是;0:否";
//        List list = toList()
//        System.out.println(list);
    }

    public static List toList(String value){
        return Arrays.asList(value.split(";")).stream().map(x -> {
            String[] one = x.split(":");
            return Arrays.asList(Integer.parseInt(one[0]),one[1]);
        }).collect(Collectors.toList());
    }
}
