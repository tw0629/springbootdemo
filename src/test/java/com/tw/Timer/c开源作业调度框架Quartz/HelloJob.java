package com.tw.Timer.c开源作业调度框架Quartz;


import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {

        System.out.println("                                                ");
        System.out.println("======================第" + 1 + "次==========================");
        JobDetail detail = context.getJobDetail();
        String name = detail.getJobDataMap().getString("name");
        System.out.println("say hello      name:" + name);
    }

}