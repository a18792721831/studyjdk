package com.star.p3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jiayq
 * @Date 2020-09-08
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Integer[][] arras = new Integer[num][];
        for (int i = 0; i < num; i++) {
            String str = String.valueOf(scanner.nextInt());
            Integer[] temp = new Integer[str.length()];
            for (int j = 0; j < str.length(); j++) {
                temp[j] = Integer.valueOf(str.charAt(j));
            }
            Arrays.sort(temp);
            arras[i] = temp;
        }

        Integer[][] indexAndLength = new Integer[2][arras.length];
        for (int i = 0; i < arras.length; i++) {
            indexAndLength[0][i] = 0;
            indexAndLength[1][i] = arras[i].length;
        }
        getOptions(arras, indexAndLength);
    }

    private static void getOptions(Integer[][] arras, Integer[][] indexAndLength) {

        for (int i = 0; i < arras.length; i++) {
            System.out.printf("%c", arras[i][indexAndLength[0][i]]);

        }
        System.out.println();
        if (addIndex(indexAndLength, arras.length)) {
            getOptions(arras, indexAndLength);
        }
    }

    private static boolean addIndex(Integer[][] indexAndLength, Integer index) {

        if (index <= 0) {
            return false;
        }
        if ((indexAndLength[0][index - 1] = indexAndLength[0][index - 1] + 1) < indexAndLength[1][index - 1]) {
            return true;
        }
        indexAndLength[0][index - 1] = 0;
        return addIndex(indexAndLength, index - 1);
    }

}
