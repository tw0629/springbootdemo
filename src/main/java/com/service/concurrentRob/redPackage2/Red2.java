package com.service.concurrentRob.redPackage2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author David Tian
 * @desc
 * @since 2020-09-03 16:16
 */
public class Red2 {

    //private AtomicInteger size = new AtomicInteger(10);

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<LuckyMoney> luckyMoneys = new LinkedBlockingQueue<>();

        List<FutureTask> futureTasks = new ArrayList<>();

        //准备抢红包
        for (int i = 0; i < 5; i++) {
            FutureTask<Object> futureTask = new FutureTask<>(new CatchLuckMoney(luckyMoneys, "name" + i), null);
            new Thread(futureTask,"name"+i).start();
            futureTasks.add(futureTask);
        }
        Thread.sleep(5);//确保抢红包线程准备就绪
        Random random = new Random(100);
        //发5个红包
        for (int i = 0; i < 5; i++) {
            luckyMoneys.put(new LuckyMoney("红包"+i, random.nextInt(100)+1));
        }
        //等到红包抢完
        while (!luckyMoneys.isEmpty()){
            Thread.sleep(1);
        }
        //终止抢红包线程
        for (FutureTask futureTask : futureTasks) {
            futureTask.cancel(true);
        }

    }
}

class CatchLuckMoney implements Runnable {
    private LinkedBlockingQueue<LuckyMoney> luckyMoneys;
    private String name;

    public CatchLuckMoney(LinkedBlockingQueue<LuckyMoney> luckyMoneys, String name) {
        this.luckyMoneys = luckyMoneys;
        this.name = name;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            LuckyMoney redPackage = null;
            try {
                redPackage = luckyMoneys.take();
            } catch (InterruptedException e) {
            //  e.printStackTrace();
                break;
            }
            System.out.println(name + "抢到了-->" + redPackage);
            luckyMoneys.remove(redPackage);
        }
        System.out.println("end>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+Thread.currentThread().getName());
    }
}

class LuckyMoney {

    public LuckyMoney(String name, Integer money) {
        this.name = name;
        this.money = money;
    }

    private String name;
    private Integer money;

    @Override
    public String toString() {
        return "LuckyMoney{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

}
