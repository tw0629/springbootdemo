package com.tw.StringUtils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author David Tian
 * @since 2019-04-06
 */
public class test2 {


    /**
     * public static String defaultIfEmpty(String str,
     *                                     String defaultStr)
     *
     * 如果str为 空 或 null ，则返回defaultStr。否则返回str；
     */
    @Test
    public void test(){
        String s = "";
        String s2 = "666";

        System.out.println("=========>"+StringUtils.defaultIfEmpty(s,s2));
        System.out.println("=========>"+StringUtils.defaultIfEmpty(s2,s));

        System.out.println("===========================");

        String ss = null;
        String ss1 = "";
        String ss2 = "   ";
        String ss3 = "ttttt";
        String ss4 = "888888";

        System.out.println("=========>"+StringUtils.defaultIfEmpty(ss,ss4));
        System.out.println("=========>"+StringUtils.defaultIfEmpty(ss1,ss4));
        System.out.println("=========>"+StringUtils.defaultIfEmpty(ss2,ss4));
        System.out.println("=========>"+StringUtils.defaultIfEmpty(ss3,ss4));
    }

    @Test
    public void test2() {

        String join = StringUtils.join("wwwww", "tttt");
        System.out.println("=========>"+join);

    }

    @Test
    public void test3() {

        //str1的第一个字符 a 在ASCII码表中十进制的下标为 97 ，str2的第一个字符 I 是 73 ，97比73多24，所以返回 24 。
        String str1 = "abc";
        String str2 = "IloveU";
        System.out.println(str1.compareTo(str2));

        System.out.println("===========================");

        //str1比str2少7个字符，所以返回 -7
        String str11 = "ljj";
        String str22 = "ljjLovexql";
        System.out.println(str11.compareTo(str22));

        /**
         * 24
         * ===========================
         * -7
         */
    }

    @Test
    public void test4() {

        String s = "名单筛选匹配结果.xlsx";

        String substring = s.substring(0,s.lastIndexOf("."));

        System.out.println("=========>"+substring);

    }


}
