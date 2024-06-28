package com.service.tw.guava;

import com.google.common.base.CaseFormat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author David Tian
 * @desc
 * @since 2022/4/2 10:18
 */
public class CaseFormat_test {

    public static void main(String args[]) {

        if(!(Math.abs(100L) == Math.abs(100L))){
            System.out.println("不等");
        }else {
            System.out.println("等");
        }

        Integer a = 2;
        if(!a.equals(null)){
            System.out.println("a不等null");
        }

        System.out.println(200L);
        System.out.println(-(200L));
        System.out.println(-(-200L));
        System.out.println(-(-200L));

        System.out.println("Long 转 LocalDateTime:"+LocalDateTime.ofInstant(Instant.ofEpochMilli(1648806194000L), ZoneId.systemDefault()));
        System.out.println("Long 转 LocalDate:"+ LocalDateTime.ofInstant(Instant.ofEpochMilli(1648742400000L), ZoneId.systemDefault()).toLocalDate());

        CaseFormat_test tester = new CaseFormat_test();
        tester.testCaseFormat();
    }

    private void testCaseFormat() {
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));

        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "testdata"));
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, "testData"));

        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "TestData"));
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "testData"));
    }
}
