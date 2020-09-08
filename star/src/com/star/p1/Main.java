package com.star.p1;

import java.util.Scanner;

/**
 * @author jiayq
 * @Date 2020-09-08
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int total = num * 2 - 1;
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (total >= num) {
            for (int j = 0; j < i; j++) {
                stringBuilder.append(" ");
            }
            for (int j = 0; j < total - i; j++) {
                if (j%2 == 0) {
                    stringBuilder.append("*");
                } else{
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append("\n");
            i++;
            total--;
        }
        System.out.print(stringBuilder.toString());
    }

}
