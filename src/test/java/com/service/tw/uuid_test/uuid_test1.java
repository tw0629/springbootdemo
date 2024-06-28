package com.service.tw.uuid_test;

import org.junit.Test;

import java.util.UUID;

public class uuid_test1 {

    @Test
    public void test(){

        String token = UUID.randomUUID().toString();
        System.out.println("===========> "+ token);     //===========> 5c29a79f-fbc3-406d-946a-6fceb24ed63a
        System.out.println("                             ");

        String token2 = token.substring(0,16);
        System.out.println("===========> "+ token2);    //===========> 5c29a79f-fbc3-40
        System.out.println("                             ");
    }
}
