package com.tw.System;

import org.junit.Test;

/**
 * @author David Tian
 * @since 2019-05-13
 */
public class nanoTime_demo {


    /**
     *
     * 纳秒
     * 　　ns（nanosecond）：纳秒， 时间单位。一秒的10亿分之一，即等于10的负9次方秒。常用作 内存读写速度的单位。
     * 　　1纳秒=0.000001 毫秒
     * 　　1纳秒=0.00000 0001秒
     *
     * java的System.currentTimeMillis()和System.nanoTime()区别:
     *
     * java中System.nanoTime()返回的是纳秒，nanoTime而返回的可能是任意时间，甚至可能是负数……
     * java中System.currentTimeMillis()返回的毫秒，这个毫秒其实就是自1970年1月1日0时起的毫秒数.   <<======== 注意
     *
     * (所以照就 毫秒与纳秒 不是1000000倍数 关系)
     *
     *
     * 两个方法都不能保证完全精确,精确程度依赖具体的环境.
     *
     */
    @Test
    public void test(){

        //自1970年1月1日0时起的毫秒数
        System.out.println("======毫秒======"+"注意:自1970年1月1日0时起的毫秒数(所以照就 毫秒与纳秒 不是1000000倍数 关系)");

        long startTime2 = System.currentTimeMillis();
        long endTime2 = System.currentTimeMillis();

        System.out.println("======startTime2:======>"+startTime2);
        System.out.println("======endTime2  :======>"+endTime2);


        //纳秒可能是任意时间，甚至可能是负数
        System.out.println("======纳秒======"+"注意:纳秒可能是任意时间，甚至可能是负数");

        long startTime = System.nanoTime();
        long endTime = System.nanoTime();

        System.out.println("======startTime:======>"+startTime);
        System.out.println("======endTime  :======>"+endTime);



        //test
        long time1 = System.nanoTime()/1000000L;
        long time2 = System.currentTimeMillis();
        System.out.println("======time1  :======>"+time1);
        System.out.println("======time2  :======>"+time2);


    }
}
