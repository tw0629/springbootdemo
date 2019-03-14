package com.tw.Timer.c开源作业调度框架Quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


/**
 * 步骤：
 * <p>
 * 1 创建job
 * 2 创建工厂，获取调度器
 * 3 使用JobBuilder通过job生成jobDetail，可以传递数据
 * 4 通过TriggerBuilder创建Trigger，可以设置时间
 * 5 通过调度器注册ob和trigger
 * 6 启动调度
 */

public class QuartzTest {

    public static void main(String[] args) throws InterruptedException {

        // 1、创建JobDetial对象 , 并且设置选项
        // 指明job的名称，所在组的名称，以及绑定job类
        JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("JobName", "JobGroupName")
                .usingJobData("name", "quartz").build();

        // 2、通过 TriggerBuilder 创建Trigger对象
        // 定义触发的条件
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("CronTrigger1", "CronTriggerGroup")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
                .startNow().build();

        // 3、创建Scheduler对象，并配置JobDetail和Trigger对象
        // 创建工厂
        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            // 通过schedulerFactory获取一个调度器
            scheduler = schedulerfactory.getScheduler();
            // 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job, trigger);


            // 启动调度
            scheduler.start();


            // 用睡眠时间 来模拟这段执行任务的时间范围
            Thread.sleep(100000);


            // 停止调度
            scheduler.shutdown();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
