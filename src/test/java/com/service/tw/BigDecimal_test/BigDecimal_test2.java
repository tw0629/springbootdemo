package com.service.tw.BigDecimal_test;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.NumberFormat;

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


    @Test
    public void test2(){

        float avg = (float) 3/10;
        BigDecimal  avgScore = BigDecimal.valueOf(avg);

        System.out.println("==========>"+avgScore);

        float avg2 = (float) 3/9;
        System.out.println("==========>"+avg2);
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMaximumFractionDigits(1);
        String s = numberFormat.format(avg2);
        System.out.println("==========>"+s);

    }


    @Test
    public void test3(){


        BigDecimal bigDecimal = new BigDecimal(123456.789);
        BigDecimal bigDecimal2 = new BigDecimal(10000);

        System.out.println("==========>"+bigDecimal.toString());

        BigDecimal bigDecimal3 = bigDecimal.divide(bigDecimal2);

        System.out.println("==========>"+bigDecimal3.toString());

        bigDecimal3 = bigDecimal.divide(bigDecimal2,2, RoundingMode.HALF_UP);

        System.out.println("==========>"+bigDecimal3.toString());


    }

    @Test
    public void test4(){

        Long amount = 100000L;
        BigDecimal divide = BigDecimal.valueOf(amount).divide(BigDecimal.valueOf(10l).pow(2));
        BigInteger bigInteger = divide.toBigIntegerExact();
        System.out.println("==========>"+bigInteger);

        Number number = 123456;
        Number number2 = 123456L;
        Number number3 = new BigDecimal(1.23456);
        System.out.println("==========>"+number);
        System.out.println("==========>"+number2);
        System.out.println("==========>"+number2.toString());
        System.out.println("==========>"+number3);
        System.out.println("==========>"+number3.toString());

        if("Tianwei".equalsIgnoreCase("TIANWEI")){
            System.out.println("==========>"+"Tianwei");
        }
        if("tianwei".equalsIgnoreCase("TIANWEI")){
            System.out.println("==========>"+"tianwei");
        }


        System.out.println("==========>");

    }



}
