package com.tw.Timer.bJava自带定时器Timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * 定时任务,这是一个线程
 */

class MyTask extends TimerTask {

    int i = 0;

    @Override
    public void run() {

        System.out.println("task " + (++i) + " execute" + "         " + new Date());
    }

}