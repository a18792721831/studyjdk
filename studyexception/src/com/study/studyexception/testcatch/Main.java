package com.study.studyexception.testcatch;

/**
 * @author jiayq
 * @Date 2020/8/11
 */
public class Main {

    public static void main(String[] args) {
        try {
            testcatch();
        } catch (MyException4 myException4) {
            myException4.printStackTrace();
        } catch (MyException3 myException3) {
            myException3.printStackTrace();
        } catch (MyException2 myException2) {
            myException2.printStackTrace();
        } catch (MyException1 myException1) {
            myException1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void testcatch() throws Throwable, MyException4, MyException3, MyException2, MyException1, Exception, Error {
    }

}
