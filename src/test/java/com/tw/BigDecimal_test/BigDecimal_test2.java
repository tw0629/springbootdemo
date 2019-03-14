package com.tw.BigDecimal_test;

import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimal_test2 {

    @Test
    public void test() {
        BigDecimal bdv = new BigDecimal("12.3456");//字符串转成bigdecimal
        bdv = bdv.setScale(3, BigDecimal.ROUND_HALF_UP);
        System.out.println(bdv);
        BigDecimal bdv2 = new BigDecimal("12.3454");//字符串转成bigdecimal
        bdv2 = bdv.setScale(3, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(bdv2);
        BigDecimal bdv3 = new BigDecimal("12.3454");//字符串转成bigdecimal
        bdv3 = bdv.setScale(3, BigDecimal.ROUND_HALF_EVEN);
        System.out.println(bdv3);

    }
}
