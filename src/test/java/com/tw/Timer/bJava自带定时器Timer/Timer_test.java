package com.tw.Timer.bJava自带定时器Timer;

import java.util.Date;
import java.util.Timer;

/**
 * java 自带定时器 : java.util.Timer
 * Timer 也是基于线程Runnable来实现的。当然它实现的也更复杂点。
 */

public class Timer_test {

    public static void main(String[] args) {

        Timer timer = new Timer();

        // 5s后执行
        // timer.schedule(new MyTask(), 1000);

        // 马上执行任务,每隔1000执行一次
        timer.scheduleAtFixedRate(new MyTask(), new Date(), 3000);

        System.out.println("准备，5秒之后开始        "+new Date());
        timer.scheduleAtFixedRate(new MyTask2(), 5000, 3000);


        System.out.println("==============XXXXXXXXXXXXXX==============");
    }

}
