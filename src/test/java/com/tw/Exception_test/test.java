package com.tw.Exception_test;

import com.common.Exception.AException;
import com.common.Exception.CException;
import org.junit.Test;

public class test {


    public Object test() {
        try {
            int i = 666;
            //int m = 5 / 0;

        } catch (Exception e) {
            System.out.println(e.getMessage() + "        " + e.getStackTrace());
//            return e.getStackTrace();
        }
        return "0";
    }

    @Test
    public void test2() {
        Object test = test();
        System.out.println("     " + test.toString());
        System.out.println("++++++++++++++++++++++++++++++++++++");
    }

    @Test
    public void test3() {
        try {
            f2();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("=====================");
    }

    public Object f1() {
        try {
            //int i = 666;
            int m = 5 / 0;

        } catch (Exception e) {
            throw new RuntimeException("f1 Exception, " +e.getMessage());
        }
        return "f1";
    }

    public Object f2() {
        f1();
        return "f2";
    }


    @Test
    public void exceptionTest() {

        try {
            throwTest();
            //throwTest2();
        }catch (CException e){
            System.out.println("CException");
        }catch (Exception e){
            System.out.println("Exception");
        }finally {

        }
    }

    public void throwTest() {
        throw new AException();
    }

    public void throwTest2() {
        throw new CException();
    }

}
