package com.tw.Date_test;


import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class test {

    @Test
    public void test() throws ParseException {
        SimpleDateFormat format = null;
        Date date = null;
        String dateStr = "20180724";
        System.out.println("=================================");


        format = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
        date = format.parse(dateStr);

        System.out.println("======>" + date);
        System.out.println("                                 ");

        format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        date = format.parse(dateStr);
        System.out.println("======>" + date);
        System.out.println("                                 ");

    }


    // 获得某天最大时间 2018-08-10 23:59:59
    @Test
    public void test2() {
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        ;
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        date = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("===============>" + date);


        System.out.println("                                        ");


        Timestamp dayStartTime = DateUtils.getDayStartTime(date);
        System.out.println("===============>" + dayStartTime);


    }

    // 获得某天最小时间 2018-08-10 00:00:00
    @Test
    public void test3() {
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        date = Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("===============>" + date);

        System.out.println("                                        ");


        Timestamp dayStartTime = DateUtils.getDayEndTime(date);
        System.out.println("===============>" + dayStartTime);


    }

    @Test
    public void test4() {
        DateFormat dateTimeformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strBeginDate = dateTimeformat.format(new Date());
        System.out.println(strBeginDate);
        System.out.println("=============================");

        System.out.println(new Date());
        System.out.println(DateUtils2.formatTimestamp(new Date()));
        System.out.println("=============================");

        Date format = DateUtils.format(new Date());
        System.out.println("=============>"+format);
    }

    /**
     *
     *   String = format(date)
     *   Date = parse(s)
     *
     */
    @Test
    public void test5() {

        Date date = new Date();
        System.out.println("=============>"+date);

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String s = sd.format(date);
        System.out.println("=============>"+s);

        Date d = null;
        try {
            d = sd.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("=============>"+d);
    }


}
