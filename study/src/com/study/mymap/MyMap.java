package com.study.mymap;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * @author jiayq
 * @Date 2020-04-20
 */
public class MyMap {

    public static void main(String[] args) {

        HashMap<People, Integer> hashMap = new HashMap<>();
        hashMap.put(new People(), 22);
        hashMap.put(new People(), 22);
        hashMap.put(new People(), 22);

//        Iterator<Map.Entry<People, Integer>> entryIterator = hashMap.entrySet().iterator();
//        entryIterator.forEachRemaining(x -> x.setValue(x.getValue() + 12));
//        while(entryIterator.hasNext()){
//            Map.Entry<People, Integer> entry = entryIterator.next();
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
//        System.out.println("------------");

        for(Integer integer : hashMap.values()){
            System.out.println(integer);
        }



        System.out.println(hashMap.values());


    }

    private static class People{
        @Override
        public int hashCode() {
            return 0;
        }
    }

}
