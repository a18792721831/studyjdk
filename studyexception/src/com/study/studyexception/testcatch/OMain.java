package com.study.studyexception.testcatch;

/**
 * @author jiayq
 * @Date 2020/8/11
 */
public class OMain {

    public static void main(String[] args) {
        try {
            new OMain().test();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void test4() throws MyException4 {
        throw new MyException4();
    }

    public void test3() throws MyException3 {
        test4();
    }

    public void test2() throws MyException2 {
            test3();
    }

    public void test1() throws MyException1 {
            test2();
    }

    public void test() throws Throwable {
            test1();
    }

}
