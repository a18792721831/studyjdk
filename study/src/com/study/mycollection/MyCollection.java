package com.study.mycollection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @author jiayq
 * @Date 2020-04-18
 */
public class MyCollection {

    public static void main(String[] args){
        Vector<Integer> vector = new Vector<Integer>();
        vector.add(1);
        vector.add(10);
        vector.add(10);
        vector.add(20);
        System.out.println(vector.toString());
        vector.remove(Integer.valueOf(10));
        System.out.println(vector.toString());

        LinkedList<Long> longs = new LinkedList<>();
    }

}
