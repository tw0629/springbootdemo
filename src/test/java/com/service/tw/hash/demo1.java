package com.service.tw.hash;

import com.google.common.hash.HashCode;
import org.junit.Test;

/**
 * @author David Tian
 * @desc
 * @since 2020-12-02 13:12
 */
public class demo1 {

    @Test
    public void test(){

        String s1 = "tian";
        String s2 = "wei";
        String s3 = "qwertyuioppasdfghjklzxcvbnm";

        int i = s1.hashCode();
        int i2 = s2.hashCode();

        int l1 = i % 1000;
        int l2 = i2 % 1000;

        System.out.println("======> "+l1);
        System.out.println("======> "+l2);
        System.out.println("======");


        HashCode hashCodee = HashCode.fromString("tian");


        HashCode hashCode = HashCode.fromString(s1);
        HashCode hashCode3 = HashCode.fromString(s3);
        System.out.println("======> "+hashCode);
        System.out.println("======> "+hashCode3);
        System.out.println("======");
        System.out.println("======> "+hashCode.asInt());
        System.out.println("======> "+hashCode3.asInt());
        System.out.println("======> "+hashCode3.toString());
        System.out.println("======> "+hashCode3.asLong());
        System.out.println("======> "+hashCode3.hashCode());
        System.out.println("======> "+hashCode3.padToLong());

    }


    @Test
    public void test2(){
    }

    private void fengzhu(String value) {

    }

}
