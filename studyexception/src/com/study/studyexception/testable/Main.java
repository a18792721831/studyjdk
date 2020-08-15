package com.study.studyexception.testable;

/**
 * @author jiayq
 * @Date 2020/8/11
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        try{
            main.testMyExceptionNon();
        } catch (MyError myError) {

        }
    }


    public void testMyError() throws MyError{
        throw new MyError();
    }

    public void testMyErrorNon() throws MyErrorNon {
        throw new MyErrorNon();
    }

    public void testMyException() throws MyException {
        throw new MyException();
    }

    public void testMyExceptionNon() throws MyExceptionNon{
        throw new MyExceptionNon();
    }
}
