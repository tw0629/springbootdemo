package com.tw.Timer.bJava自带定时器Timer;

import java.util.Date;
import java.util.TimerTask;

public class MyTask2 extends TimerTask {

    int i = 0;

    @Override
    public void run() {

        System.out.println("task " + (++i) + " execute" + "         " + new Date() + "2222222");
    }

}
