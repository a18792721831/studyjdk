package com.study.mycollection;

/**
 * @author jiayq
 * @Date 2020-04-19
 */
public class People {

    private int age;

    public People(int age){
        this.age = age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString(){
        return age + "";
    }

}
