package com.tw.Date_test;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author David Tian
 * @desc
 * @since 2019-11-04 11:28
 *
 * 注意：注意,Calendar对象默认一月为0
 */
public class DateUtils3 {

    public static final String FORMAT_DATE_NOMAL = "yyyy-MM-dd HH:mm:ss";

    public final static String FORMAT_DATE_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    public final static String FORMAT_DATE_YYYY_MM_DD = "yyyy-MM-dd";

    public final static String FORMAT_DATE_HH_MM_SS = "HH:mm:ss";


    /**
     * 描述:获取下一个月的第一天.
     */
    public static String getPerFirstDayOfMonth() {
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }

    /**
     * 获取下个月的这个时间点
     * @param date
     * @param monthNum
     */
    public static Date getNextMonthTime(Date date,int monthNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        //calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - monthNum); // 设置为上一个月
        calendar.add(Calendar.MONTH, monthNum);

        return calendar.getTime();
    }

    /**
     * 暂定
     */
    public static Date calFutureDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + days);
        return calendar.getTime();
    }

    /**
     * 获取当前月份最后一天
     */
    public static String getMaxMonthDate() {
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        // calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }

    /**
     * 描述:获取指定月份的第几天的日期.
     * Calendar.MONTH: 1  表示：下一个月
     * Calendar.MONTH: 1 表示： 下一个天
     *
     * 注意：Calendar add()和set()的区别
     */
    public static String getAssignDate(int month,int day) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        //calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.MONTH, month);
        calendar.add(Calendar.DATE, day);
        return dft.format(calendar.getTime());
    }

    /**
     * 描述:获取指定月份的天数.
     */
    public static int getDaysOfMonth(String dyear, String dmonth) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM");
        Calendar rightNow = Calendar.getInstance();
        try {
            rightNow.setTime(simpleDate.parse(dyear+"/"+dmonth));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int days = rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);//根据年月 获取月份天数
        return days;
    }


    /**
     * 初始一个日期
     *
     * ======>注意: Calendar对象默认本月为0
     */
    public static String getMonthFirstDay(int year,int month,int day,int hour, int minute, int second,String format){
        Calendar c = Calendar.getInstance();
        if(year>=0){
            c.set(Calendar.YEAR, year);
        }
        if(month>0&&month<13){
            c.set(Calendar.MONTH, month-1);
        }
        if(day>0&&day<=31){
            c.set(Calendar.DAY_OF_MONTH,day);
            //c.set(Calendar.DAY_OF_MONTH,0); 一月
            //calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            //c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
            //c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        }
        if(hour>=0&&hour<24){
            c.set(Calendar.HOUR_OF_DAY,hour);
        }
        if(minute>=0&&minute<60){
            c.set(Calendar.MINUTE,minute);
        }
        if(hour>=0&&hour<60){
            c.set(Calendar.SECOND,second);
        }

        SimpleDateFormat dft = new SimpleDateFormat(format);
        return dft.format(c.getTime());
    }


    /**
     * 将时间戳转换为日期字符串
     */
    public static String longToDateStr(long l, String format){
        if(StringUtils.isEmpty(format)){
            format = FORMAT_DATE_NOMAL;
        }
        SimpleDateFormat sdf =  new SimpleDateFormat(format);
        return sdf.format(l);
    }

    /**
     * 将时间戳转换为日期
     */
    public static Date longToDate(long l, String format){
        SimpleDateFormat sdf =  new SimpleDateFormat(format);
        String d = longToDateStr(l, "");
        Date date= null;
        try {
            date = sdf.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将日期字符串转换为Date
     * @param dateStr
     * @param format
     * @return
     */
    public static Date strToDate(String dateStr, String format) {
        if (dateStr.equals("") || dateStr == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取日期年月日时分秒的数字
     */
    public static void getDatePerUnitNum(){
        String dateStr = "2019-11-09 12:30:30";
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        //月份 --- 从0开始
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        int day2 = calendar.get(Calendar.DAY_OF_MONTH);
        //星期 --- 一周中的第几天(罗马星期日一二三四五六)
        int week = calendar.get(Calendar.DAY_OF_WEEK-1);
        //星期 --- 一年中的第几周
        int week2 = calendar.get(Calendar.WEEK_OF_YEAR);
        //天 --- 一年中的第几天
        int day3 = calendar.get(Calendar.DAY_OF_YEAR);

        //星期几
        String []arr = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        //1.数组下标从0开始；2.老外的第一天是从星期日开始的
        System.out.println("今天是："+arr[calendar.get(Calendar.DAY_OF_WEEK)-1]);

    }


    /**
     * 获取日期日的数字
     */
    public static int getDateDateNum(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //月份 --- 从0开始
        int monthDay = calendar.get(Calendar.DAY_OF_MONTH);
        return monthDay;
    }

    /**
     * 1:把日期往后增加一天.整数往后推,负数往前移动
     * @return
     */
    public static Date addDateDay(Date date,int dayNum){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,dayNum);
        return calendar.getTime();
    }

    /**
     * 设置为该月的某一天
     */
    public static Date setDateDay(Date date,int dayNum){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.DATE,dayNum);
        return calendar.getTime();
    }


    /**
     * 计算所得月份的最后一天  monthNum:【当月:1, 下个月:2, 3个月:3】
     */
    public static String getNextMonthDayDate(Date date,int monthNum) {
        SimpleDateFormat dft = new SimpleDateFormat(FORMAT_DATE_NOMAL);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, monthNum-1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }

    public static int differDay(Date endDate,Date startDate){
        long num = (endDate.getTime() - startDate.getTime())/(60*60*24*1000);
        return (int)num;
    }


}
