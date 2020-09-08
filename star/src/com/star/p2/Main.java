package com.star.p2;

import java.util.Scanner;

/**
 * @author jiayq
 * @Date 2020-09-08
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim().toLowerCase();
        int[] nums = new int[140];
        for (char ch :
                str.toCharArray()) {
            nums[ch] = nums[ch]+1;
        }
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= '0' && i <= 'z'){
                if (i <='9') {
                    if (nums[(char)index2] < nums[i]) {
                        index2 = i;
                    }
                } else {
                    if (nums[(char)index1] < nums[i]) {
                        index1 = i;
                    }
                }
            }
        }
        System.out.printf("%c %d\n",index1,nums[(char)index1]);
        System.out.printf("%c %d\n",index2,nums[(char)index2]);
    }

}
