package com.tw.BaseType_test;

import org.junit.Test;

public class test {

    // 写法 最好都加上 d，f，l
    @Test
    public void test() {
        Double a = 1d;
        double a2 = 1;
        System.out.println(a);
        System.out.println(a2);

        Float a3 = 1f;
        float a4 = 1;
        System.out.println(a3);
        System.out.println(a4);

        Long a5 = 1l;
        long a6 = 1;
        System.out.println(a5);
        System.out.println(a6);
    }

}
