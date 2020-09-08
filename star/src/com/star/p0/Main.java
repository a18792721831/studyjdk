package com.star.p0;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author jiayq
 * @Date 2020-09-08
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal b1 = new BigDecimal(scanner.next());
        BigDecimal b2 = new BigDecimal(scanner.next());
        System.out.println(b1.add(b2));
    }

}
