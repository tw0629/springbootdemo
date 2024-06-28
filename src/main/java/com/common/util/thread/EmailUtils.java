package com.common.util.thread;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.google.common.collect.Sets;
import com.service.tw2.FetchConfigurationBO;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Semaphore;

/**
 * @author David Tian
 * @desc
 * @since 2022/4/7 11:26
 */
public class EmailUtils {

    public static void main(String[] args) throws Exception {

        String onOffStoreId = "123456";
        String substring = onOffStoreId.substring(1, onOffStoreId.length() - 1);
        System.out.println(substring);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime3 = LocalDateTime.now();
        String dateStr = localDateTime3.format(fmt);
        System.out.println(dateStr);


        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(Instant.ofEpochMilli(1640878737155L), ZoneOffset.of("+8"));
        System.out.println(localDateTime2.toString());


        System.out.println("ChaileaseBNPL".equalsIgnoreCase("ChaileaseBNPL"));

        HashSet<String> set = Sets.newHashSet("CreditCard", "ChaileaseBNPL");
        if(set.contains("ChaileaseBNPL")){
            System.out.println("======>");
        }


        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-04-20 10:00:00"));


        SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // 北京
        bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));  // 设置北京时区
        SimpleDateFormat londonSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 伦敦
        londonSdf.setTimeZone(TimeZone.getTimeZone("Europe/London")); // 设置伦敦时区

        //System.out.println(zeroZoneTime("yyyy-mm-dd HH:mm:ss"));
        System.out.println(Calendar.getInstance(TimeZone.getTimeZone("Europe/London")).getTime());
        System.out.println(bjSdf.format(Calendar.getInstance(TimeZone.getTimeZone("Europe/London")).getTime()));
        System.out.println(Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai")).getTime());
        System.out.println(londonSdf.format(Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai")).getTime()));
        System.out.println(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTime());


        Date date = new Date();
        System.out.println("毫秒数:" + date.getTime() + ", 北京时间:" + bjSdf.format(date));
        System.out.println("毫秒数:" + date.getTime() + ", 伦敦时间:" + londonSdf.format(date));


        Calendar calendar = Calendar.getInstance();
        System.out.println("8时区: "+ calendar.getTime());
        System.out.println("8时区-: "+ startOfDay(1));
        LocalDateTime localDateTime = OffsetDateTime.now().toLocalDateTime();
        System.out.println("0时区: "+ new Date(localDateTime.toInstant(ZoneOffset.of("+0")).toEpochMilli()));



        OffsetDateTime.now().atZoneSameInstant(ZoneOffset.of("+8")).toLocalDate()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));


        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        System.out.println(today_start.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(today_end.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(new Date(today_start.toInstant(ZoneOffset.of("+0")).toEpochMilli()));
        System.out.println(new Date(today_end.toInstant(ZoneOffset.of("+0")).toEpochMilli()));


        System.out.println(OffsetDateTime.now().atZoneSameInstant(ZoneOffset.of("+8")).toLocalDate());
        System.out.println(OffsetDateTime.now().atZoneSameInstant(ZoneOffset.of("+8")).toLocalDateTime());
        System.out.println(OffsetDateTime.now().atZoneSameInstant(ZoneOffset.of("+8")).toLocalTime());
        System.out.println(OffsetDateTime.now().atZoneSameInstant(ZoneOffset.of("+8")).toLocalDateTime()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        String json = "[     {         \"file_alias\":\"chailease_0card_transaction_details\",         \"file_merchant_code_list\":\"\",         \"file_url_var_fm_exp\":{             \"date\":\"${fileMetaDataBO.fileNameDate?date('yyyy-MM-dd')?string('yyyyMMdd')}\"         },         \"batch_no_fm_exp\":\"\",         \"skip_holiday\":\"false\",         \"file_name_date_offset\":\"1\",         \"download_url_template\":\"中租0卡分期對賬檔${date}#${date}_貴司統編副檔名.csv\"     } ]";
        List<FetchConfigurationBO> fetchConfigurationBOList = toList(json, FetchConfigurationBO.class);
        JSONObject.parseArray(json, FetchConfigurationBO.class);
        System.out.println();
        

        String batchNo = "2022-04-12";
        String yyyyMMdd = LocalDate.parse(batchNo, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                .minusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(yyyyMMdd);


        System.out.println(OffsetDateTime.now());
        System.out.println(OffsetDateTime.now().atZoneSameInstant(ZoneOffset.of("+8")));

        Semaphore semaphore = new Semaphore(3);
        semaphore.release();
        System.out.println(semaphore);
    }

    public static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
            .configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true)
            .configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);
//            .registerModule(new Jdk8Module())
//            .registerModule(new JavaTimeModule()
//                    .addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
//                    .addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
//                    .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
//                    .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));


    public static <T> List<T> toList(String json, Class<T> tClass) {
        JavaType t = objectMapper.getTypeFactory().constructParametricType(List.class, tClass);
        try {
            return objectMapper.readValue(json, t);
        } catch (Exception e) {
            return null;
        }
    }

    public static Calendar startCalendar(int day) {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        c.add(Calendar.DATE, day);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.set(Calendar.AM_PM, Calendar.AM);
        return c;
    }

    public static Date startOfDay(){
        return startCalendar(0).getTime();
    }

    public static Date startOfDay(int day){
        return startCalendar(day).getTime();
    }

    public static final String zeroZoneTime(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        return dateFormat.format(new Date());
    }

    public static boolean isTheSameDay(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        return (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR))
                && (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH))
                && (c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH));
    }
}
