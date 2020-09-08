package com.star.p4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author jiayq
 * @Date 2020-09-08
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<List<Character>> chars = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            String str = String.valueOf(scanner.nextInt());
            List<Character> temp = new ArrayList<>(str.length());
            for (char ch :
                    str.toCharArray()) {
                temp.add(Character.valueOf(ch));
            }
            chars.add(temp);
        }
        List<String> result = new ArrayList<>();
        for (List<Character> l :
                chars) {
            if (result.isEmpty()) {
                result = l.stream().map(x-> String.valueOf(x)).collect(Collectors.toList());
            } else {
                result = result.stream().flatMap(x-> l.stream().map(y -> x+String.valueOf(y))).collect(Collectors.toList());
            }
        }
        Object[] objects = result.stream().map(x -> Integer.valueOf(x)).toArray();
        Arrays.sort(objects);
        Arrays.stream(objects).forEach(x-> System.out.println(x));
    }

}
