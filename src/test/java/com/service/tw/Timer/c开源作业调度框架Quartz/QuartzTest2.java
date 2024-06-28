package com.service.tw.Timer.c开源作业调度框架Quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest2 {

    public static void main(String[] args) {


        // 1、创建JobDetial对象 , 并且设置选项
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("JobName2", "group_1").build();


        // 2、通过 TriggerBuilder 创建Trigger对象
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity("trigger_1", "group_1");
        triggerBuilder.startNow();
        // 设置重复次数和间隔时间
        triggerBuilder.withSchedule(SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInMilliseconds(1) //时间间隔
                .withRepeatCount(5) // 重复次数
        );
        // 设置停止时间
        //triggerBuilder.endAt(new Date(System.currentTimeMillis() + 3));
        // 创建Trigger对象
        Trigger trigger = triggerBuilder.build();


        // 3、创建Scheduler对象，并配置JobDetail和Trigger对象
        SchedulerFactory sf = new StdSchedulerFactory();
        try {
            Scheduler scheduler = sf.getScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            // 4、并执行启动、关闭等操作
            scheduler.start();

            //关闭调度器
            //scheduler.shutdown(true);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}