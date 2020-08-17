package com.study;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author jiayq
 * @Date 2020-05-12
 */
public class Main {

    private static Set<Integer> isCyced = new HashSet();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(foo(number));
    }

    public static String foo(int value){
        if (value == 1){
            return "True";
        } else if(isCyced.contains(value)){
            return "False";
        } else {
            int sum = 0;
            while(value > 0){
                sum += Math.pow(value%10, 2);
                value = value / 10;
            }
            isCyced.add(sum);
            return foo(sum);
        }
    }
}
