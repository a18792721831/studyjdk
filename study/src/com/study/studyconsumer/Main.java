package com.study.studyconsumer;

import com.study.mycollection.People;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author jiayq
 * @Date 2020-05-23
 */
public class Main {

    public static void main(String[] args) {

        Consumer<Integer> consumer = x -> x = x+1;
        Consumer<String> stringConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        int x = 88;
        consumer.accept(x);
        System.out.println(x);
        stringConsumer.accept("hello");
        Consumer<People> peopleConsumer = people -> people.name = people.name + people.name;
        People people;
        peopleConsumer.accept(people = new People("hello "));
        System.out.println(people.name);

        Consumer<Integer> integerConsumer = y -> System.out.println(y);
        Arrays.asList(1,2,3).forEach(integerConsumer.andThen(integerConsumer));

        MyConsumer myConsumer = str -> str = str + str;
        MyInterface myInterface = string -> string = string + string;
    }

    @FunctionalInterface
    interface MyConsumer{
        void accept(String string);
    }

    interface MyInterface{
        void accept(String string);
    }

    static class People{
        String name;

        People(String s){
            name = s;
        }
    }

}
