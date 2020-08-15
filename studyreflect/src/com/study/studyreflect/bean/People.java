package com.study.studyreflect.bean;

import java.io.Serializable;
import java.lang.annotation.Documented;

/**
 * @author jiayq
 * @Date 2020/8/13
 */
@Deprecated
public class People implements Serializable {

    private String name;

    private Integer age;

    private int number;

    private String testPrivate;

    public String testPublic;

    protected String testProtected;

    String testDefault;

    public People(){

    }

    public People(String name){
        this.name = name;
    }

    public String say(){
        return name+age;
    }


    private String say(String string){
        return string;
    }

    protected Integer say(Integer integer){
        return integer;
    }

    Double say(Double doub) {
        return doub;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getTestPrivate() {
        return this.testPrivate;
    }

    public String getTestPublic() {
        return this.testPublic;
    }

    public String getTestProtected() {
        return this.testProtected;
    }

    public String getTestDefault() {
        return this.testDefault;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setTestPrivate(String testPrivate) {
        this.testPrivate = testPrivate;
    }

    public void setTestPublic(String testPublic) {
        this.testPublic = testPublic;
    }

    public void setTestProtected(String testProtected) {
        this.testProtected = testProtected;
    }

    public void setTestDefault(String testDefault) {
        this.testDefault = testDefault;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString(){
        return "People[name=" + name + ",age=" + age + ",number=" + number + ",testPublic=" + testPublic + ",testPrivate=" + testPrivate
                + ",testProtected=" + testProtected + ",testDefault=" + testDefault + "]";
    }
}
