package com.tw.BaseType_test;

import org.junit.Test;

public class long_test {

    @Test
    public void test1() {
        Long lableId = 1L;
        if (lableId != 1 && lableId != 2 && lableId != 3)
            System.out.println("====$====>" + lableId);
        if (lableId == 1 || lableId == 2 || lableId == 3)
            System.out.println("====$====>" + lableId);
    }

    @Test
    public void test2() {

        Long a = null;
        Long a2;
        long b;

        if (a == null) {
            System.out.println("=====a====");
        }
        if (a.equals(0)) {
            System.out.println("=====a2=====");
        }
    }

    @Test
    public void test() {
//        BeanUtils.copyProperties();
    }

}