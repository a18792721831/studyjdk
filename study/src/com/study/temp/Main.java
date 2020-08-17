package com.study.temp;

import java.util.Scanner;

/**
 * @author jiayq
 * @Date 2020-06-04
 */
public class Main {


//    :strictfp:12345
//    => 1.2.3.45
//
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        //1. 数组
        char[] chars = string.toCharArray();
        //2. 位数分配
        //获取总长度：
        // 小于4位，大于12位，不允许
        // 4~12位：如果4的倍数，平均分配
        // 如果是 4~7 : 某n个是两位数字
        // 如果是 8~12 : 某n个是三位数字
        if (chars.length < 4 || chars.length > 12){
            System.out.println("intput error");
        }
        switch(chars.length){
            case 4:
                System.out.println();
        }

//        char[] chars = new char[]{'1','2','3','4'};
//        printOneIp(chars, 1);
        printIp(chars,chars.length%4);

    }

    public static void printIp(char[] chars,int value){
        if (value < 0 || value > 3){
            System.out.println("intput error");
        }
        switch (value){
            case 0:
                printOneIp(chars, -1);
                break;
            case 1:
                // value = 1 ; 1:2:3:45 1:2:34:5 1:23:4:5 12:3:4:5
                for(int i = 0;i < 4;i++){
                    printOneIp(chars, i);
                }
                break;
            case 2:
                for(int i = 0;i < 4;i++){
                    printOneIp(chars, i);
                }
                break;
            case 3:
                for(int i = 0;i < 4;i++){
                    printOneIp(chars, i);
                }
                break;
                default:
                    System.out.println("print error");
                    break;
        }
    }

    public static void printOneIp(char[] chars, int index){
        for(int i = 0;i < chars.length;i++){
            System.out.print(chars[i] + (i == index ? chars[++i] + "":"") + ":");
        }
        System.out.println();
    }

//    public static void printOneIp(char[] chars, int index){
//        for (int i = 0; i < chars.length; i++) {
//            System.out.print(chars[i] + (i == index ? getRepeat(chars, index) + "" : index == -1 ? "" : ":"));
//        }
//        System.out.println();
//    }

    public static String getRepeat(char[] chars, int times) {
        String result = "";
        for (int i = 0;i < times;i++) {
            result += chars[times - 1 + i];
        }
        result += ":";
        return result;
    }


}
