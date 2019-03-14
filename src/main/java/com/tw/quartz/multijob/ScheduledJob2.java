package com.tw.quartz.multijob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class ScheduledJob2 implements Job {

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.err.println("第二个任务正在运行 is running…………………………………… ");

    }

}