package com.study.mycollection;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jiayq
 * @Date 2020-04-18
 */
public class MyCollection {

    public static void main(String[] args) {
        Vector<People> vector = new Vector<People>();
        for (int i = 1;i<=10;i++){
            System.out.println(vector.size()+" "+vector.capacity());
            vector.add(new People(i));
        }
//        System.out.println(vector.toString());
        for(int i = 0;i < vector.size();i++){
            People people = vector.get(i);
            people.setAge(people.getAge() + 1);
        }
//        System.out.println(vector.toString());
        for (People people : vector) {
            people.setAge(people.getAge() + 1);
        }
        System.out.println(vector.toString());
        vector.stream().forEach(x -> x.setAge(x.getAge() + 1));
        System.out.println(vector.toString());
        Iterator<People> iterator = vector.iterator();
        while (iterator.hasNext()){
            People people = iterator.next();
            people.setAge(people.getAge() + 1);
        }
        System.out.println(vector.toString());
        ListIterator<People> listIterator = vector.listIterator(7);
        while (listIterator.hasPrevious()){
            People people = listIterator.previous();
            people.setAge(people.getAge() + 2);
            if(people.getAge() == 7){
                listIterator.remove();
            }
        }
        System.out.println(vector.toString());
        ListIterator<People> listIterator1 = vector.listIterator();
        while (listIterator1.hasNext()){
            People people = listIterator1.next();
            people.setAge(people.getAge() + 3);
        }
        System.out.println(vector.toString());
        vector.forEach(x -> x.setAge(x.getAge() + 5));
        System.out.println(vector.toString());
        for(int i = 0;i < vector.size();i++){
            People people = vector.get(i);
            if (people.getAge() == 20){
                vector.add(new People(30));
            }
        }
        System.out.println(vector.toString());
        for(int i = 0;i < vector.size();i++){
            People people = vector.get(i);
            if (people.getAge() == 20 || people.getAge() == 30){
                vector.remove(people);
                i--;
            }
        }
        System.out.println(vector.toString());
        vector = vector.stream().filter(people -> people.getAge() != 21).
                collect(Vector::new,Vector::add,(left,right)->left.addAll(right));
        System.out.println(vector);
    }

}
