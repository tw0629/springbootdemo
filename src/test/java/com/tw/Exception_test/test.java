package com.tw.Exception_test;

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
        String s = null;
        String s2 = "";

        System.out.println("=====================");
        System.out.println(s);
        System.out.println(s2);
    }
}
