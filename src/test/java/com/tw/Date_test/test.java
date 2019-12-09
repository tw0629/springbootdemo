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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.tw.Date_test.DateUtils3.FORMAT_DATE_NOMAL;

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

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sd2 = new SimpleDateFormat("yyyy-MM-dd");

        String s = sd.format(date);
        System.out.println("=============>"+s);

        Date d = null;
        try {
            d = sd2.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("=============>"+d);
    }


    /**
     * https://blog.csdn.net/DAOYUANWANG/article/details/51713640
     */
    @Test
    public void test6() {

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateformat.parse("2020-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("=============>"+date);
        System.out.println("=============>"+dateformat.format(date));


    }

    @Test
    public void test7(){

        String string = "2016-10-24 21:59:06";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = sdf.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parse);
    }



    public static final String simple = "yyyy-MM-dd HH:mm:ss";

    public static final String dtSimpleShort = "yyyy-MM-dd";

    public static Date formatDate(Date date){
        SimpleDateFormat sd = new SimpleDateFormat(simple);
        SimpleDateFormat sd2 = new SimpleDateFormat(dtSimpleShort);

        String s = sd.format(date);
        try {
            date = sd2.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Test
    public void test8(){
        Date date = new Date();
        System.out.println("=============>"+date);

        date = formatDate(date);
        System.out.println("=============>"+date);
    }

    @Test
    public void test9(){
        String perFirstDayOfMonth = DateUtils3.getPerFirstDayOfMonth();
        System.out.println("=======1======>"+perFirstDayOfMonth);

        String maxMonthDate = DateUtils3.getMaxMonthDate();
        System.out.println("=======2======>"+maxMonthDate);

    }


    @Test
    public void test10(){


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));

        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, 28);
        System.out.println(c);

        Date time = c.getTime();

        String preDay = sdf.format(time);
        System.out.println(preDay);

    }

    @Test
    public void test11(){
        int daysOfMonth = DateUtils3.getDaysOfMonth("2019","11");
        int daysOfMonth2 = DateUtils3.getDaysOfMonth("2019","10");
        int daysOfMonth3 = DateUtils3.getDaysOfMonth("2019","2");
        int daysOfMonth4 = DateUtils3.getDaysOfMonth("2020","2");
        System.out.println("=======2019-11========"+daysOfMonth);
        System.out.println("=======2019-10========"+daysOfMonth2);
        System.out.println("=======2019-2========"+daysOfMonth3);
        System.out.println("=======2020-2========"+daysOfMonth4);
        System.out.println("===============");

    }

    @Test
    public void test12(){
        String assignDate = DateUtils3.getAssignDate(1, 1);
        System.out.println("==============="+assignDate);
        System.out.println("===============");
        //25200000

        String dateString = assignDate + " " + "10:36:00";
        Date date = DateUtils2.StringToDate(dateString, DateUtils2.FORMAT_DATE_YYYY_MM_DD_HH_MM_SS);

        System.out.println("==============="+date);
        System.out.println("===============");

    }

    @Test
    public void test13(){
        String s = "15:00";
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long ts = date.getTime();
        res = String.valueOf(ts);
        System.out.println("=======11 时分秒的时间戳========"+res);

        long lt = new Long(res);
        Date date1 = new Date(lt);
        res = simpleDateFormat.format(date1);
        System.out.println("=======22 时分秒========"+res);
    }


    @Test
    public void test14(){
        Date date = DateUtils2.longToDate(1572859353329L, DateUtils2.FORMAT_DATE_HH_MM_SS);
        System.out.println("=======11 时分秒的时间戳========"+date);

        String date2 = DateUtils2.longToDateStr(1572859353329L, DateUtils2.FORMAT_DATE_HH_MM_SS);
        System.out.println("=======11 时分秒的时间戳========"+date2);

        long time = new Date().getTime();
        System.out.println("=======时分秒的时间戳========"+time);
    }


    @Test
    public void test15(){
        Date date1 = new Date(2017, 5, 20);
        Date now;
        Calendar c = Calendar.getInstance();
        now = new Date(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH));

        if(date1.after(now)) {
            System.out.println("超过了今天");
        }
        else {
            System.out.println("没有超过今天");
        }


        //Calendar calendar = Calendar.getInstance();
        //calendar.setTime(date);

        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.YEAR,2019);
        calendar.set(Calendar.MONTH,0);
        calendar.set(Calendar.DATE,6);
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 34);
        calendar.set(Calendar.SECOND, 30);
        calendar.set(Calendar.MILLISECOND, 0);

        System.out.println("==============="+calendar.getTime());

        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String preDay = format.format(calendar.getTime());
        System.out.println("==============="+preDay);
        System.out.println("===============");


        String monthFirstDay = DateUtils3.getMonthFirstDay(-1, 0,0,0,0,0, DateUtils3.FORMAT_DATE_YYYY_MM_DD);
        System.out.println("==============="+monthFirstDay);
        //System.out.println("==============="+format.format(monthFirstDay));
        System.out.println("===============");

    }


    @Test
    public void test16(){

        String dateS1 = DateUtils3.longToDateStr(1572859353329L, FORMAT_DATE_NOMAL);
        String dateS2 = DateUtils3.longToDateStr(1572859353329L, DateUtils3.FORMAT_DATE_HH_MM_SS);

        System.out.println("==============="+dateS1);
        System.out.println("==============="+dateS2);


        Date date = DateUtils3.strToDate("2019-1-8 12:00:00", "yyyy-MM-dd HH:mm:ss");
        System.out.println("==============="+date);


        System.out.println("                                ");

        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date nextMonthTime = DateUtils3.getNextMonthTime(new Date(), 1);
        System.out.println("==============="+dft.format(nextMonthTime));
        Date nextMonthTime2 = DateUtils3.getNextMonthTime(new Date(), -1);
        System.out.println("==============="+dft.format(nextMonthTime2));


        Date date1 = DateUtils3.calFutureDate(date, 1);
        System.out.println("==============="+dft.format(date1));
        Date date2 = DateUtils3.calFutureDate(date, -1);
        System.out.println("==============="+dft.format(date2));


    }

    @Test
    public void test17(){
        Date dt=new Date();
        System.out.println(dt);

        String year=String.format("%tY", dt);

        String mon=String .format("%tm", dt);

        String day=String .format("%td", dt);

        System.out.println(year);

        System.out.println(mon);

        System.out.println(day);
    }

    @Test
    public void test18(){
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int dow = cal.get(Calendar.DAY_OF_WEEK);
        int dom = cal.get(Calendar.DAY_OF_MONTH);
        int doy = cal.get(Calendar.DAY_OF_YEAR);

        System.out.println("Current Date: " + cal.getTime());
        System.out.println("Day: " + day);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
        System.out.println("Day of Week: " + dow);
        System.out.println("Day of Month: " + dom);
        System.out.println("Day of Year: " + doy);

        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("==========>" + DateUtils3.getDateDateNum(new Date()));


        System.out.println("=====2=====>" + DateUtils3.addDateDay(new Date(),20));
        System.out.println("=====2=====>" + dft.format(new Date()));
        System.out.println("=====2=====>" + dft.format(DateUtils3.addDateDay(new Date(),20)));

    }

    @Test
    public void test19(){
        //
        String dateStr = "2018-1-9 17:18:30";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat(FORMAT_DATE_NOMAL);

        Date date = null;
        try {
            date = sdf2.parse(dateStr );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long hmslBefore = date.getTime() - DateUtils2.obtainYMD(date).getTime();
        long hmslNow = System.currentTimeMillis() - DateUtils2.obtainYMD(new Date()).getTime();



        Date newDate = date;
        if("EveryMonth".equals("EveryMonth")&&date.getTime()<(new Date()).getTime()){
            //获取下个月日期年月日的时间戳
            Date nextMonthDate = DateUtils2.obtainYMD(DateUtils3.getNextMonthTime(new Date(), 1));
            long monthymdl =DateUtils3.addDateDay(nextMonthDate,DateUtils3.getDateDateNum(date)).getTime();

            //判断日期的号
            if(DateUtils3.getDateDateNum(date)>DateUtils3.getDateDateNum(new Date())||(DateUtils3.getDateDateNum(date)==DateUtils3.getDateDateNum(new Date())&&hmslNow<=hmslBefore)){
                Date thisMonthDay = DateUtils3.addDateDay(new Date(), DateUtils3.getDateDateNum(date));
                //获取本月执行日期 年月日的时间戳
                monthymdl = DateUtils2.obtainYMD(thisMonthDay).getTime();
            }

            //下个月执行的日期
            newDate = DateUtils3.longToDate(monthymdl + hmslBefore,FORMAT_DATE_NOMAL);
        }

        System.out.println("                    ");
        System.out.println("===============>"+newDate);
        System.out.println("===============>"+sdf2.format(newDate));
        System.out.println("                    ");

    }


    @Test
    public void test20(){
        String dateStr = "2019-11-30 01:30:30";
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_NOMAL);

        Date date = null;
        try {
            date = sdf.parse(dateStr );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String nextMonthDayDate = DateUtils3.getNextMonthDayDate(date,1);
        System.out.println("===============>"+nextMonthDayDate);

        String nextMonthDayDate2 = DateUtils3.getNextMonthDayDate(date,2);
        System.out.println("===============>"+nextMonthDayDate2);

        String nextMonthDayDate3 = DateUtils3.getNextMonthDayDate(date,3);
        System.out.println("===============>"+nextMonthDayDate3);


        System.out.println("========XXX=======>"+new Date());
    }


    @Test
    public void test21(){
        Date date = DateUtils3.setDateDay(new Date(), 1);
        System.out.println("========XXX=======>"+DateUtils2.dateToString(date));

        Date date2 = DateUtils3.setDateDay(new Date(), 30);
        System.out.println("========XXX=======>"+DateUtils2.dateToString(date2));
    }


    @Test
    public void test22(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        //月份 --- 从0开始
        int monthDay = calendar.get(Calendar.DAY_OF_MONTH);


        System.out.println("========XXX=======>"+monthDay);
        System.out.println("========XXX=======>");
    }

    @Test
    public void test23(){
        long l = 1574771400000L;
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = format.format(l);
        Date date= null;
        try {
            date = format.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }



        System.out.println("========XXX=======>"+date);

        System.out.println("========XXX=======>");
    }

    @Test
    public void test24(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        //月份 --- 从0开始
        int month = calendar.get(Calendar.MONTH)+1;

        System.out.println("========XXX=======>"+calendar.get(Calendar.MONTH));
        System.out.println("========XXX=======>"+month);


        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar calendar2 = new GregorianCalendar();
        calendar2.setTime(null);

        System.out.println("========XXX=======>"+format.format(calendar2.getTime()));
        calendar2.add(Calendar.MONTH,-1);
        System.out.println("========XXX=======>"+format.format(calendar2.getTime()));

        System.out.println("========XXX=======>");
    }

    @Test
    public void test25(){
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        System.out.println("========XXX=======>"+format.format(calendar.getTime()));


        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar2.set(Calendar.HOUR_OF_DAY, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);
        System.out.println("========XXX=======>"+format.format(calendar2.getTime()));


        System.out.println("========XXX=======>");


    }

    @Test
    public void test26(){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH,-4);
        Date time = calendar.getTime();

        boolean after = time.after(new Date(1575539462608L - 24 * 3600 * 3));

        System.out.println("========XXX=======>"+new Date(System.currentTimeMillis() - 24 * 3600 * 38*1000));
        System.out.println("========XXX=======>"+System.currentTimeMillis());
        System.out.println("========XXX=======>"+after);
        System.out.println("========XXX=======>"+time);
        System.out.println("========XXX=======>");

    }


}
