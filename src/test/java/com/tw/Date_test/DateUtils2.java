package com.tw.Date_test;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils2 {

    public final static String FORMAT_DATE_DEFAULT = "yyyy-MM-dd";

    public final static String FORMAT_DATE_YYYYMMDD = "yyyyMMdd";

    public final static String FORMAT_DATE_YYMMDD = "yyMMdd";

    public final static String FORMAT_DATE_YYYY_MM_DD = "yyyy-MM-dd";

    public final static String FORMAT_DATE_PATTERN_1 = "yyyy/MM/dd";

    public final static String FORMAT_DATE_PATTERN_2 = "yyyy/M/dd";

    public final static String FORMAT_DATE_PATTERN_3 = "yyyy/MM/d";

    public final static String FORMAT_DATE_PATTERN_4 = "yyyy/M/d";

    public final static String FORMAT_DATE_PATTERN_5 = "yy/MM/dd";

    public final static String FORMAT_DATE_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public final static String FORMAT_DATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public final static String FORMAT_DATE_YYYY_MM_DD_HHMM = "yyyy-MM-dd HHmm";

    public final static String FORMAT_DATE_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    public final static String FORMAT_DATE_YY_MM_DD_HH_MM = "yy/MM/dd HH:mm";

    public final static String FORMAT_DATE_HH_MM = "HH:mm";

    public final static String FORMAT_DATE_HH_MM_SS = "HH:mm:ss";

    public final static String FORMAT_DATE_HHMM = "HHmm";

    public final static String FORMAT_DATE_HHMMSS = "HHmmss";

    public static final String FORMAT_WORK_TIME = "yyyy-MM-dd HHmmss";

    public static final String FORMAT_TIME_NOMAL = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    /**
     * Compares two Dates from their string value.
     *
     * @param stringValue1
     *            Date 1 as string value.
     * @param stringValue2
     *            Date 2 as string value.
     *
     * @return the value <code>0</code> if the argument stringValue1 is equal
     *         to stringValue2; a value less than <code>0</code> if this
     *         stringValue1 is before the stringValue2 as Date; and a value
     *         greater than <code>0</code> if this stringValue1 is after the
     *         stringValue2.
     * @since 1.2
     */
    public final static int compareDate(String stringValue1, String stringValue2) throws ParseException {
        Date date1 = tryParse(stringValue1);
        if (date1 == null)
            throw new ParseException("Can not parse " + stringValue1 + " to Date.", 0);
        Date date2 = tryParse(stringValue2);
        if (date2 == null)
            throw new ParseException("Can not parse " + stringValue1 + " to Date.", 0);
        return date1.compareTo(date2);
    }

    /**
     * Returns current system date as formatted string value with default format
     * pattern.
     *
     * @return current system date.
     *
     * @see #FORMAT_DATE_DEFAULT
     */

    public final static String getCurrentDateAsString() {
        return getCurrentDateAsString(FORMAT_DATE_DEFAULT);
    }

    /**
     * Returns current system date as formatted string value with given format
     * pattern.
     *
     * @param formatPattern
     *            format pattern.
     * @return current system date.
     *
     */
    public final static String getCurrentDateAsString(String formatPattern) {
        Date date = new Date();
        return format(date, formatPattern);
    }

    public final static String getFormtPattern1ToPattern2(String stringValue, String formatPattern1,
                                                          String formatPattern2) {
        Date date = parse(stringValue, formatPattern1);
        return format(date, formatPattern2);
    }

    /**
     * Returns current system date.
     *
     * @return current system date.
     */
    public final static Date getCurrentDate() {
        return new Date();
    }

    public final static String getTodayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return dayOfWeek + "";
    }

    /**
     * time compare: <br>
     * if startTime before endTime<br>
     * return true<br>
     * else<br>
     * return false<br>
     * @param startTime
     * @param endTime
     * @return
     */
    public final static boolean compareTime(String startTime, String endTime) throws ParseException {
        if (StringUtils.isEmpty(startTime)) {
            return true;
        }
        if (StringUtils.isEmpty(endTime)) {
            endTime = getCurrentDateAsString(FORMAT_DATE_YYYY_MM_DD_HH_MM_SS);
        }
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_YYYY_MM_DD_HH_MM_SS);
        Date start = sdf.parse(startTime);
        Date end = sdf.parse(endTime);
        if (start.before(end)) {
            return true;
        }
        return false;
    }

    // 判断当前时间是否在时间date2之前
    // 时间格式 2012-10-16 16:16:34
    public static boolean isDateBefore(String date2) {
        try {
            Date date = new Date();
            System.out.println(date);
            DateFormat df = DateFormat.getDateTimeInstance();
            System.out.println(date.before(df.parse(date2)));
            return date.before(df.parse(date2));
        } catch (ParseException e) {
            System.out.print("[SYS] " + e.getMessage());
            return false;
        }
    }

    // 判断时间date1是否在时间date2之前
    // 时间格式 2012-10-16 16:16:34
    public static boolean isDateBefore(String date1, String date2) {
        try {
            if (StringUtils.isEmpty(date1)) {
                return true;
            }
            if (StringUtils.isEmpty(date2)) {
                date2 = getCurrentDateAsString(FORMAT_DATE_YYYY_MM_DD_HH_MM_SS);
            }
            DateFormat df = DateFormat.getDateTimeInstance();
            return df.parse(date1).before(df.parse(date2));
        } catch (ParseException e) {
            System.out.print("[SYS] " + e.getMessage());
            return false;
        }
    }

    /**
     * Format Date value as string value with default format pattern.
     *
     * @param date
     *            Date value.
     * @return formatted date as string value.
     *
     * @see #FORMAT_DATE_DEFAULT
     */
    public final static String format(Date date) {
        if (date == null) {
            return "";
        }
        return format(date, FORMAT_DATE_DEFAULT);
    }

    /**
     * Format Date value as string value with default format pattern.
     *
     * @param date
     *            Date value.
     * @return formatted date as string value.
     *
     * @see #FORMAT_DATE_DEFAULT
     */
    public final static String formatDateTime(Date date) {
        if (date == null) {
            return "";
        }
        return format(date, FORMAT_DATE_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * parse long time to common date according to your format
     * @param longValue
     * @param format
     * @return
     */
    public static String parseLongToDate(String longValue, String format) {
        if (StringUtils.isEmpty(longValue))
            return "";
        long val = Long.valueOf(longValue);

        if (val > 0) {
            return DateFormatUtils.format(val, format);
        } else {
            return "";
        }
    }

    /**
     * parse long time to common date according to "yyyy-MM-dd HH:mm:ss" format
     * @param longValue
     * @return
     */
    public static String parseLongToDate(String longValue) {
        return parseLongToDate(longValue, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * Format Date value as string value with default format pattern.
     *
     * @param date
     *            Date value.
     * @return formatted date as string value.
     *
     * @see #FORMAT_DATE_DEFAULT
     */
    public final static String formatTimestamp(Date date) {
        if (date == null) {
            return "";
        }
        return format(date, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    /**
     * Format Date value as string value with default format pattern.
     *
     * @param date
     *            Date value.
     * @return formatted date as string value.
     *
     * @see #FORMAT_DATE_DEFAULT
     */
    public final static Date parseTimestamp(String date) {
        if (date == null) {
            return null;
        }
        return parse(date, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    /**
     * Format Date value as string value with given format pattern.
     *
     * @param date
     *            Date value.
     * @param formatPattern
     *            format pattern.
     * @return formatted date as string value.
     *
     */
    public final static String format(Date date, String formatPattern) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(formatPattern).format(date);
    }

    /**
     * Parse string value to Date with default format pattern.
     *
     * @param stringValue
     *            date value as string.
     * @return Date represents stringValue.
     * @see #FORMAT_DATE_DEFAULT
     */
    public final static Date parse(String stringValue) {
        return parse(stringValue, FORMAT_DATE_DEFAULT);
    }

    /**
     * Parse string value to Date with given format pattern.
     *
     * @param stringValue
     *            date value as string.
     * @param formatPattern
     *            format pattern.
     * @return Date represents stringValue, null while parse exception occurred.
     * @see #FORMAT_DATE_DEFAULT
     */
    public final static Date parse(String stringValue, String formatPattern) {
        SimpleDateFormat format = new SimpleDateFormat(formatPattern);
        try {
            return format.parse(stringValue);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Try to parse string value to date.
     *
     * @param stringValue
     *            string value.
     * @return Date represents stringValue, null while parse exception occurred.
     */
    public final static Date tryParse(String stringValue) {
        Date date = parse(stringValue, FORMAT_DATE_DEFAULT);
        if (date != null) {
            return date;
        }
        date = parse(stringValue, FORMAT_DATE_YYYYMMDD);
        if (date != null) {
            return date;
        }
        date = parse(stringValue, FORMAT_DATE_YYYYMMDDHHMMSS);
        if (date != null) {
            return date;
        }
        date = parse(stringValue, FORMAT_DATE_YYYY_MM_DD_HH_MM_SS);
        if (date != null) {
            return date;
        }
        date = parse(stringValue, FORMAT_DATE_YYYY_MM_DD_HHMM);
        if (date != null) {
            return date;
        }
        date = parse(stringValue, FORMAT_DATE_PATTERN_1);
        if (date != null) {
            return date;
        }
        date = parse(stringValue, FORMAT_DATE_PATTERN_2);
        if (date != null) {
            return date;
        }
        date = parse(stringValue, FORMAT_DATE_PATTERN_3);
        if (date != null) {
            return date;
        }
        date = parse(stringValue, FORMAT_DATE_PATTERN_4);
        if (date != null) {
            return date;
        }
        return date;
    }

    /**
     * get day of week
     * @param SUN_FST_DAY_OF_WEEK
     * @return
     */
    public static int getDayOfWeek(int SUN_FST_DAY_OF_WEEK) {
        if (SUN_FST_DAY_OF_WEEK > 7 || SUN_FST_DAY_OF_WEEK < 1)
            return 0;
        if (SUN_FST_DAY_OF_WEEK == 1)
            return 7;
        return SUN_FST_DAY_OF_WEEK - 1;
    }

    public static Timestamp parseTimestamp(String stringValue, String formatPattern) {
        return new Timestamp(parse(stringValue, formatPattern).getTime());
    }

    public static Timestamp parseTimestamp(Date d) {
        return new Timestamp(d.getTime());
    }

    // -----------------------------------------------------------------------
    /**
     * Adds a number of milliseconds to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addMilliseconds(Date date, int amount) {
        return add(date, Calendar.MILLISECOND, amount);
    }

    // -----------------------------------------------------------------------
    /**
     * Adds a number of minutes to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addMinutes(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    // -----------------------------------------------------------------------
    /**
     * Adds to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param calendarField  the calendar field to add to
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     *
     */
    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    public static String getExchangeFormat(String dateStr, String sourFormat, String destFormat) {
        String dt = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(destFormat);
            dt = sdf.format(parse(dateStr, sourFormat));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dt;
    }

    public static Date plugOneDate(Date date) {
        return new Date(date.getTime() + 24 * 60 * 60 * 1000L);
    }

    /**
     * 锟斤拷锟�ate锟侥猴拷一锟届，锟斤拷时锟斤拷锟斤拷直锟轿�0:00:00
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static Date getNextDay(Date date) {
        Date nextDay = new Date(date.getTime() + 24 * 60 * 60 * 1000L);
        nextDay.setHours(0);
        nextDay.setMinutes(0);
        nextDay.setSeconds(0);
        return nextDay;
    }

    /**
     * 删锟斤拷date锟叫碉拷时锟斤拷锟街★拷锟诫、锟斤拷锟斤拷
     *
     * @param date
     * @return
     */
    public static Date truncateTime(Date date) {
        if (date == null) {
            return null;
        }

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }

    public static Date setTime(Date date, int hour, int minute, int second, int milliSecond) {
        if (date == null) {
            return null;
        }

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, second);
        c.set(Calendar.MILLISECOND, milliSecond);

        return c.getTime();
    }

    public static Date setTime(Date date, String time) {
        if (date == null) {
            return null;
        }
        Calendar timeC = Calendar.getInstance();
        timeC.setTime(parse(time, FORMAT_DATE_HH_MM_SS));

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, timeC.get(Calendar.HOUR_OF_DAY));
        c.set(Calendar.MINUTE, timeC.get(Calendar.MINUTE));
        c.set(Calendar.SECOND, timeC.get(Calendar.SECOND));
        c.set(Calendar.MILLISECOND, timeC.get(Calendar.MILLISECOND));

        return c.getTime();
    }

    /**
     * 锟皆革拷时锟斤拷date锟斤拷锟斤拷锟斤拷锟斤拷贫锟�锟斤拷前锟狡讹拷)锟斤拷锟斤拷
     *
     * @param date
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @param milliSecond
     * @return
     */
    public static Date addDate(Date date, int year, int month, int day, int hour, int minute, int second,
                               int milliSecond) {
        if (date == null) {
            return null;
        }

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, year);
        c.add(Calendar.MONTH, month);
        c.add(Calendar.DATE, day);
        c.add(Calendar.HOUR_OF_DAY, hour);
        c.add(Calendar.MINUTE, minute);
        c.add(Calendar.SECOND, second);
        c.add(Calendar.MILLISECOND, milliSecond);

        return c.getTime();
    }

    public static Date addDate(Date date, int year, int month, int day, int hour, int minute, int second) {
        return addDate(date, year, month, day, hour, minute, second, 0);
    }

    public static Date addDate(Date date, int hour, int minute, int second) {
        return addDate(date, 0, 0, 0, hour, minute, second, 0);
    }

    /**
     * 锟斤拷锟斤拷day1锟斤拷day2锟斤拷锟斤拷锟斤拷锟�day1-day2)锟斤拷锟斤拷锟斤拷
     *
     * @param day1
     * @param day2
     * @return
     */
    public static int getIntervalDays(Date day1, Date day2) {
        if (day1 == null || day2 == null) {
            throw new IllegalArgumentException("Argument day1 or day2 must be not null.");
        }

        Date day1ToUse = truncateTime(day1);
        Date day2ToUse = truncateTime(day2);
        long intervalMilliSecond = getIntervalMilliSeconds(day1ToUse, day2ToUse);

        return (int) (intervalMilliSecond / (24 * 60 * 60 * 1000));
    }

    /**
     * 锟斤拷锟斤拷day1锟斤拷day2锟斤拷锟斤拷锟斤拷锟�day1-day2)锟斤拷锟铰凤拷
     *
     * @param day1
     * @param day2
     * @return
     */
    public static int getIntervalMonths(Date day1, Date day2) {
        if (day1 == null || day2 == null) {
            throw new IllegalArgumentException("Argument day1 or day2 must be not null.");
        }

        Calendar calDay1 = Calendar.getInstance();
        calDay1.setTime(day1);
        Calendar calDay2 = Calendar.getInstance();
        calDay2.setTime(day2);

        int yearInterval = calDay1.get(Calendar.YEAR) - calDay2.get(Calendar.YEAR);
        int monthInterval = calDay1.get(Calendar.MONTH) - calDay2.get(Calendar.MONTH);

        return yearInterval * 12 + monthInterval;
    }

    /**
     * 锟斤拷锟斤拷day1锟斤拷day2锟斤拷锟斤拷锟斤拷锟�day1-day2)锟斤拷锟斤拷
     *
     * @param day1
     * @param day2
     * @return
     */
    public static int getIntervalYears(Date day1, Date day2) {
        if (day1 == null || day2 == null) {
            throw new IllegalArgumentException("Argument day1 or day2 must be not null.");
        }

        Calendar calDay1 = Calendar.getInstance();
        calDay1.setTime(day1);
        Calendar calDay2 = Calendar.getInstance();
        calDay2.setTime(day2);

        return calDay1.get(Calendar.YEAR) - calDay2.get(Calendar.YEAR);
    }

    private static long MILLISECOND_ONE_MINUTE = 60 * 1000;

    private static long MILLISECOND_ONE_HOUR = 3600 * 1000;

    private static long MILLISECOND_ONE_DAY = MILLISECOND_ONE_HOUR * 24;

    /**
     * 锟斤拷式锟斤拷(**锟斤拷**小时**锟斤拷**锟斤拷**锟斤拷锟斤拷)锟斤拷示start锟斤拷end锟斤拷时锟斤拷锟�end-start)
     *
     * @param start
     * @param end
     * @return
     */
    public static String intervalFormatDisplay(Date start, Date end) {
        long minus = getIntervalMilliSeconds(end, start);
        if (minus < 0) {
            throw new IllegalArgumentException("The date end must great than or equal the date start.");
        }

        StringBuilder interval = new StringBuilder();
        long days = minus / MILLISECOND_ONE_DAY;
        if (days > 0) {
            interval.append(days).append("锟斤拷");
        }

        minus -= days * MILLISECOND_ONE_DAY;
        long hours = minus / MILLISECOND_ONE_HOUR;
        if (hours > 0) {
            interval.append(hours).append("小时");
        }

        minus -= hours * MILLISECOND_ONE_HOUR;
        long minutes = minus / MILLISECOND_ONE_MINUTE;
        if (minutes > 0) {
            interval.append(minutes).append("锟斤拷");
        }

        minus -= minutes * MILLISECOND_ONE_MINUTE;
        long seconds = minus / 1000;
        if (seconds > 0) {
            interval.append(seconds).append("锟斤拷");
        }

        long millis = minus - seconds * 1000;
        if (millis > 0) {
            interval.append(millis).append("锟斤拷锟斤拷");
        }

        return interval.toString();
    }

    /**
     * 锟斤拷锟斤拷day1锟斤拷day2时锟斤拷锟斤拷锟侥猴拷锟斤拷锟斤拷(day1-day2)
     *
     * @param day1
     * @param day2
     * @return
     */
    public static long getIntervalMilliSeconds(Date day1, Date day2) {
        if (day1 == null || day2 == null) {
            throw new IllegalArgumentException("Argument day1 or day2 must be not null.");
        }

        return day1.getTime() - day2.getTime();
    }

    public static String convertStartDate(String startDateStr) {
        if (StringUtils.isNotEmpty(startDateStr)) {
            return startDateStr + " 00:00:00";
        }
        return "";
    }

    public static Date convertStartDate(Date date) {
        return truncateTime(date);
    }

    public static String convertEndDate(String endDateStr) {
        if (StringUtils.isNotEmpty(endDateStr)) {
            return endDateStr + " 23:59:59";
        }
        return "";
    }

    public static Date convertEndDate(Date date) {
        if (date == null) {
            return null;
        }

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }

    /**
     * 得到时间差字符串
     * @param d1
     * @param d2
     * @return
     */
    public static  String dateDifferStr(Date d1, Date d2) {
        long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
        long days = diff / (1000 * 60 * 60 * 24);
        long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
        String s = "" + days + "天" + hours + "小时" + minutes + "分";
        return s;
    }

    /**
     * Main method for test.
     *
     * @param args
     * @throws EncryptException
     */


    /**
     * Returns current system date as formatted string value with default format
     * pattern.
     *
     * @return current system date.
     *
     * @see #FORMAT_TIME_NOMAL
     */
    /**
     * 指定时间 添加或减少多少天
     *
     * @param date
     * @param day
     * @return
     */
    public static Date addDay(Date date, int day) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DAY_OF_YEAR, day);
        return rightNow.getTime();

    }



    public static void main(String[] args) throws Exception {
        // String stringValue = "20110610090519";
        // System.out.println(stringValue);
        System.out.println(DateUtils2.compareTime(null, null));
        // System.out.println("Parse \"" + stringValue
        // + "\" using format pattern \"" + DateUtils.FORMAT_DATE_DEFAULT
        // + "\" with method \"DateUtils.parse()\", result: "
        // + DateUtils.parse(stringValue));
        // stringValue = "20080506";
        // System.out.println("Parse \"" + stringValue
        // + "\" using method \"DateUtils.tryParse()\", result: "
        // + DateUtils.tryParse(stringValue));
        // String s =
        // DateUtils.getExchangeFormat(stringValue,FORMAT_DATE_YYYYMMDDHHMMSS,DateUtils.FORMAT_DATE_YYYY_MM_DD_HH_MM_SS);
        // System.out.print("--->>>"+s);

        // String str = "2011-08-09";
        // System.out.println(UserPasswordUtil.decrypt("PVuyeIHtXnXv5oSPwPUug66w=="));
        // System.out.println(DateUtils.getFormtPattern1ToPattern2(str,
        // DateUtils.FORMAT_DATE_YYYY_MM_DD,
        // DateUtils.FORMAT_DATE_YYYY_MM_DD_HH_MM_SS));
        // str = "aaa\r\nbbb";
        // List<String> list = StringUtil.strToList(str, "\r\n");
        // System.out.println(list.size());
        // System.out.println(StringUtil.listToStr(null, ","));

        // String value = "a,b,,c,,";
        // System.out.println(value.split("\\,").length);
        // System.out.println(StringUtil.removeSplit(value, ","));

        // Class clazz = TmEmployeeUserInfo.class;
        // Field field = clazz.getDeclaredField("spellName");
        // System.out.println(field.getName());

        // System.out.println(UserPasswordUtil.encrypt("oscwebadmin@163.com"));
        // System.out.println(JCEnDecrypt.randomDecrypt("2AF5022B2E78478A9761FD3381BB"));
        // System.out.println(JCEnDecrypt.randomEncrypt("aaa")); 41l2Iw4V
        // String regEx="[1]{1}[3,5,8,6]{1}[0-9]{9}"; //锟斤拷示a锟斤拷f
        // System.out.println(Pattern.compile(regEx).matcher("18258842633").find());

        // System.out.println(isDateBefore("2012-10-17 17:50:03"));
        //
        // System.out.println(isDateBefore("2012-10-17 17:48:03",
        // getCurrentDateAsString(FORMAT_DATE_YYYY_MM_DD_HH_MM_SS)));

        String date = DateUtils2.format(new Date(), DateUtils2.FORMAT_DATE_YYMMDD);
        System.out.println(date);
    }

    /**
     *
     * <br />dateFormat(返回yyyyMMdd)
     * <br />方法描述 ：返回 String 类型 yyyyMMdd 样式
     * <br />创建人 ： 白枫朝
     * <br />创建时间 ： 2017年8月15日 下午2:17:04
     * <br />@param   name
     * <br />@param  @return    设定文件
     * <br />@return String  yyyyMMdd  DOM对象
     * <br />@Exception 异常对象
     * <br />修改人 ：
     * <br />修改备注 ：
     * <br />@since  CodingExample　Ver(编码范例查看) 1.1
     */
    public static String dateFormat(Date date)
    {
        DateFormat df = new SimpleDateFormat(FORMAT_DATE_YYYYMMDD);
        return df.format(date);
    }
    /**
     * date to string(yyyy-MM-dd HH:mm:ss)
     * @param date
     * @return
     */
    public static String dateToString(Date date)
    {
        if(null == date)
        {
            return null;
        }
        DateFormat df = new SimpleDateFormat(FORMAT_DATE_YYYY_MM_DD_HH_MM_SS);
        return df.format(date);

    }

    /**
     *
     * <br />dateFormat2(这里用一句话描述这个方法的作用)
     * <br />方法描述 ：将Date 转换为 yyyy-MM-dd 字符串
     * <br />创建人 ： 白枫朝
     * <br />创建时间 ： 2017年8月17日 下午3:26:23
     * <br />@param   name
     * <br />@param  @return    设定文件
     * <br />@return String    DOM对象
     * <br />@Exception 异常对象
     * <br />修改人 ：
     * <br />修改备注 ：
     * <br />@since  CodingExample　Ver(编码范例查看) 1.1
     */
    public static String dateFormat2(Date date)
    {
        DateFormat df = new SimpleDateFormat(FORMAT_DATE_DEFAULT);
        return df.format(date);
    }

    public static Date StringToDate(String dateString)
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_YYYYMMDDHHMMSS);
            Date date = sdf.parse(dateString);
            return date;
        }
        catch (ParseException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Date StringToDate(String dateString,String dateFormat)
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            Date date = sdf.parse(dateString);
            return date;
        }
        catch (ParseException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    /**
     * 指定时间 添加或减少多少月
     * @param date
     * @param month
     * @return
     */
    public static Date addMonth(Date date, int month){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        //rightNow.add(Calendar.YEAR,-1);//日期减1年
        //rightNow.add(Calendar.MONTH,3);//日期加3个月
        rightNow.add(Calendar.MONTH,month);//日期加XX天
        return rightNow.getTime();

    }

    /**
     * 添加 second 秒
     * @param date
     * @param second
     * @return
     */
    public static Date addSecond(Date date, int second) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.SECOND, second);//时间加分钟
        return rightNow.getTime();

    }

    public static long getMillis(Date createTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_DATE_YYYYMMDDHHMMSSSSS);
        Long date = Long.parseLong(df.format(createTime));
        return date;
    }

    /**
     * 将date转换为String
     * @param date
     * @return
     */
    public static String dateToString(Date date,String dateFormat)
    {
        if(null == date)
            return null;
        DateFormat df = new SimpleDateFormat(dateFormat);
        return df.format(date);

    }

    public static String getDateange(Date endDate, Date nowDate) {

            long nd = 1000 * 24 * 60 * 60;
            long nh = 1000 * 60 * 60;
            long nm = 1000 * 60;
            // long ns = 1000;
            // 获得两个时间的毫秒时间差异
            long diff = endDate.getTime() - nowDate.getTime();
            // 计算差多少天
            long day = diff / nd;
            // 计算差多少小时
            long hour = diff % nd / nh;
            // 计算差多少分钟
            long min = diff % nd % nh / nm;
            // 计算差多少秒//输出结果
            // long sec = diff % nd % nh % nm / ns;
            return day + "天" + hour + "小时" + min + "分钟";

    }

    public static long getDayRange(Date endDate, Date startDate) {

        long nd = 1000 * 24 * 60 * 60;

        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        // 计算差多少天
        long day = diff / nd;

        return day;
    }

    /**
     * 更改日期Date的显示格式
     */
    public static Date modifyDateFormat(Date date, String format){
        SimpleDateFormat sd = new SimpleDateFormat(format);
        try {
            date = sd.parse(sd.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日期详情获取日期
     * @return
     */
    public static Date obtainYMD(Date date){

        return modifyDateFormat(date,FORMAT_DATE_DEFAULT);
    }

    /**
     * 将时间戳转换为日期
     */
    public static Date longToDate(long l, String formatStr){
        SimpleDateFormat format =  new SimpleDateFormat(formatStr);
        String d = format.format(l);
        Date date= null;
        try {
            date = format.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将时间戳转换为日期字符串
     */
    public static String longToDateStr(long l, String formatStr){
        SimpleDateFormat format =  new SimpleDateFormat(formatStr);
        Date date = new Date(l);
        String dateStr = format.format(date);
        return dateStr;
    }


}
