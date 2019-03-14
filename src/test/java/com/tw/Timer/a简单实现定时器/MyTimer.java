package com.tw.Timer.a简单实现定时器;

import java.util.Date;

/**
 * 定时器 : 简单实现
 * MyTimer 是基于线程 Thread 来实现的。
 */

public class MyTimer extends Thread {

    private Long time;

    public MyTimer(Long time) {
        this.time = time;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(time);//============>>>//  睡眠 相当于 "模拟每隔多长时间"
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            send();//============================>>>//  执行任务 相当于 "执行设定好的定时任务"
        }
    }

    /**
     * 开始执行任务
     */
    public void execute() {
        this.start();
    }

    /**
     * 定时任务
     */
    private void send() {
        System.out.println("任务执行了:" + new Date());
    }

    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer(2000L);
        myTimer.execute();
    }

}