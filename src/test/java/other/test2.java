package other;

import com.alibaba.fastjson.JSON;
import com.model.*;
import com.tw.A_commonObject.Order;
import com.tw.CheckParam.CheckParamUtil;
import com.tw.Date_test.DateUtils2;
import com.tw.Enum_test.TagTypeEnum;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author David Tian
 * @since 2019-03-16
 */
public class test2 {

    @Test
    public void test() {

        boolean i = true;

        Boolean ii = i;

        System.out.println("===============>" + ii);

    }

    @Test
    public void test2() {

        CommentInfoDTO commentInfoDTO = new CommentInfoDTO();
        commentInfoDTO.setType(2);
        commentInfoDTO.setTargetId("x1");
        commentInfoDTO.setFromId("g5");
        commentInfoDTO.setFromName("guest5");
        commentInfoDTO.setFromAvatar("www5");
        commentInfoDTO.setContent("评论5");
        commentInfoDTO.setScore(5);
        commentInfoDTO.setCreator("system");
        commentInfoDTO.setDateCreate(new Date());

        //List<CommentTagDTO> commentTagDTOList = new ArrayList<>();
        //commentInfoDTO.setCommentTagDTOList(commentTagDTOList);


        //<CommentSubScoreDTO> commentSubScoreDTOList = new ArrayList<>();
        //commentInfoDTO.setCommentSubScoreDTOList(commentSubScoreDTOList);

        String s = "";
        List<String> excludeNames = new ArrayList<>();
        excludeNames.add("id");
        excludeNames.add("typeName");
        excludeNames.add("commentTagDTOList");
        excludeNames.add("commentSubScoreDTOList");
        try {
            s = CheckParamUtil.checkParamExistNull(commentInfoDTO, excludeNames);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("===============>" + s);


    }


    @Test
    public void test3() {

        Object string = CheckParamUtil.checkParam(1, "String", "", null);

        System.out.println("===============>" + string);

    }

    @Test
    public void test4() {

        Long code = 1L;

        if (!StringUtils.isEmpty(code)) {
            System.out.println("=========>" + "XXXXX");
        }
    }


    @Test
    public void test5() {


        TagTypeEnum tagTypeEnum = TagTypeEnum.getByName("GOOD_COMMENT");
        System.out.println("===============>" + tagTypeEnum +"      "+tagTypeEnum.name());

        TagTypeEnum tagTypeEnum2 = TagTypeEnum.getByName("BAD_COMMENT");
        System.out.println("===============>" + tagTypeEnum2+"      "+tagTypeEnum2.name());


        System.out.println("==============================");

        String typeName = TagTypeEnum.getByCode(1);
        System.out.println("===============>" + typeName);

        String typeName2 = TagTypeEnum.getByCode(2);
        System.out.println("===============>" + typeName2);

        String typeName3 = TagTypeEnum.getByCode(3);
        System.out.println("===============>" + typeName3);

    }

    @Test
    public void test6() {

        String str1="2.30";
        BigDecimal bd=new BigDecimal(str1);
        System.out.println("===============>" + bd);


        System.out.println("=============================================" );

        String result = "";
        float num =(float)10/3;

        DecimalFormat df = new DecimalFormat("0.0");

        result = df.format(num);

        System.out.println("===============>" + result);

        BigDecimal bd2=new BigDecimal(result);
        System.out.println("===============>" + bd2);


    }

    @Test
    public void test7(){

        List list = new ArrayList();

        int batchCount = 100;

        if (list!=null){
            int recCount=list.size();
            if (recCount>0 && recCount<=batchCount){

                //operate
            }
            if (recCount>batchCount){

                int times = recCount / batchCount;
                int residue = recCount % batchCount;
                if (residue > 0) {
                    times = times + 1;
                }
                for (int i=0;i<times;i++){
                    if (i==times-1){
                        //operate
                    }else{
                        //operate
                    }
                }
            }
        }else {

            //
        }

    }

    @Test
    public void test8() {

        boolean b = false;
        if (!b) {
            System.out.println("=======>");
        }else {
            System.out.println("=======>"+b);
        }
    }

    @Test
    public void test9() {
        boolean b = "tian".equals("tian")&&!StringUtils.isEmpty("tian");
        System.out.println("=======>"+b);

        if (false||true) {

            System.out.println("=======>"+"来了");

        }

    }

    @Test
    public void test10() {
        Order order = new Order();
        order.setDate(new Date());
        order.setNo("0000");
        String queryParam = JSON.toJSONString(order);
        System.out.println(" ==========> "+ queryParam);

    }

    @Test
    public void test11() {
        System.out.println(" ==========> "+ new Date());

        Date date = new Date();

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sd.format(date);

        String[] s = format.split(" ");
        System.out.println("=======>"+s[0]);
        System.out.println("=======>"+s[1]);

    }

    @Test
    public void test12(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date parse = null;
        try {
            parse = sdf.parse("2019-07-17");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("=======>"+parse);
        System.out.println("=======>"+parse.getTime());
        System.out.println("=======>"+System.currentTimeMillis());

        /**
         * =======>1563379200000 18
         * =======>1563292800000 17
         * =======>1563355881337
         */


        long nowTime =System.currentTimeMillis();
        long todayStartTime = nowTime - (nowTime + TimeZone.getDefault().getRawOffset())% (1000*3600*24);
        System.out.println("=======>"+todayStartTime);


        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String format = sd.format(new Date());
        System.out.println("====XXX===>"+format);


    }

    @Test
    public void test13(){

        Date date=new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime(); //这个时间就是日期往后推一天的结果

        System.out.println("====XXX===>"+date);


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);

        System.out.println("====XXX===>"+dateString);

    }

    @Test
    public void test14(){
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sd.parse(sd.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("====XXX===>"+date);

    }


    @Test
    public void test15(){
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        long l = System.currentTimeMillis();
        String d = format.format(l);
        Date date= null;
        try {
            date = format.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Format To String(Date):"+d);
        System.out.println("Format To Date:"+date);
    }

    @Test
    public void test16() {
        int pageSize = 10;
        for (int a = 0; a < pageSize; a++) {
            boolean dealStatus = (a%2==0)?true:false;
            System.out.println("=============>  "+dealStatus);
        }
    }

    @Test
    public void test17() {
        VisitEventDto visitEventDto = new VisitEventDto();
        VisitEventBasicInfoDto visitEventBasicInfoDto = new VisitEventBasicInfoDto();
        visitEventBasicInfoDto.setCustomerId("1");
        visitEventBasicInfoDto.setCustomerName("111");
        visitEventBasicInfoDto.setCustomerPhone("135");
        visitEventDto.setVisitEventBasicInfoDto(visitEventBasicInfoDto);
        visitEventDto.setVin("888");

        System.out.println("=======1======>  "+visitEventDto.toString());


        visitEventDto.getVisitEventBasicInfoDto().setCustomerName("tian");

        System.out.println("=======2======>  "+visitEventDto.toString());

        System.out.println("=======over======");

    }

    @Test
    public void test18() {
        Date endDate = new Date();
        Date startDate = DateUtils2.StringToDate("2019-10-04 18:00:00",DateUtils2.FORMAT_TIME_NOMAL);
        String dateange = DateUtils2.getDateange(endDate, startDate);

        System.out.println("=======1======> "+dateange);

    }

    @Test
    public void test19() {

        VisitEventBasicInfo visitEventBasicInfo = new VisitEventBasicInfo();
        visitEventBasicInfo.setCustomerId("1");
        visitEventBasicInfo.setCustomerName("888");
        visitEventBasicInfo.setCustomerPhone("1352434");

        VisitEventDto visitEventDto = new VisitEventDto();

        BeanUtils.copyProperties(visitEventBasicInfo,visitEventDto.getVisitEventBasicInfoDto());

        System.out.println("=======1======> "+visitEventDto.toString());

    }


    @Test
    public void test20() {

        if("tian".equals(null)){
            System.out.println("=======1======> ");
        }
        System.out.println("=======000======> ");


        Random random = new Random();

        for(int i = 0 ; i<100; i++){

            //产生随机数
            //int number = random.nextInt(10 - 1 + 1) + 1;  // 1-10
            //int number2 = new Random().nextInt(1 - 0 + 1) + 0; // 0-1
            //double v = Math.floor(Integer.parseInt(String.valueOf(i)) / 2);
            int i1 = Integer.parseInt(String.valueOf(i)) / 2;

            System.out.println("=======000======> ");
        }

    }

    @Test
    public void test21() {
        VisitListQueryParam visitListQueryParam = new VisitListQueryParam();
        visitListQueryParam.setGroupCode("");
        visitListQueryParam.setShopCode("");
        visitListQueryParam.setVisitPlanType("");

        System.out.println("=======000======> "+visitListQueryParam);

        try {
            checkEmptySetNUll(visitListQueryParam,Arrays.asList("visitPlanType"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("=======111======> "+visitListQueryParam);

    }

    public static void checkEmptySetNUll(Object obj, List<String> excludeNames) throws IllegalAccessException{
        System.out.println("checkEmptySetNUll start!");
        long staryTime = System.currentTimeMillis();

        // 取到obj的class, 并取到所有属性
        Field[] fs = obj.getClass().getDeclaredFields();
        // 定义一个flag, 标记是否所有属性值为空
        String flag = "";
        // 遍历所有属性
        for (Field f : fs) {
            // 设置私有属性也是可以访问的
            f.setAccessible(true);

            if(f.get(obj) == null){
                continue;
            }

            // 校验 1.excludeNames排除不包括的属性名, 2.属性值为null, 3.属性值为""
            //if(!excludeNames.contains(f.getName()) && (f.get(obj) == null || "".equals(f.get(obj).toString()))) {
            if(!excludeNames.contains(f.getName()) && "".equals(f.get(obj).toString())) {
            //if(f.get(obj) == null || "".equals(f.get(obj).toString())) {
                // 若字段属性为空,就设置为null
                f.set(obj,null);
            }
        }

        System.out.println("checkEmptySetNUll end!  耗时:" + (System.currentTimeMillis()-staryTime)+"ms");

    }

    @Test
    public void test22(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date oldDate1 = null; //这里时间可以自己定
        Date oldDate2 = null;
        try {
            oldDate1 = format.parse("2019-10-12 15:16:00");
            oldDate2 = format.parse("2019-05-12 15:16:00"); //这里时间可以自己定
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(oldDate1.compareTo(oldDate2)); //判断,如果时间在这时间后,就执行后面操作
    }

    @Test
    public void test23(){
        Long val5 = 2953L;
        Long val3 = 100L;

        double v = val5.doubleValue() / val3.doubleValue();

        System.out.println("=======111======> "+Math.round(v));

    }

    @Test
    public void test24(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date finishDate = null; //这里时间可以自己定  23:59:59 00:00:00
        try {
            finishDate = format.parse("2019-10-14 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String timeReminder = "";
        finishDate = DateUtils2.modifyDateFormat(finishDate,DateUtils2.FORMAT_DATE_DEFAULT);
        Date todayDate = DateUtils2.modifyDateFormat(new Date(),DateUtils2.FORMAT_DATE_DEFAULT);
        long dayRange = DateUtils2.getDayRange(todayDate,finishDate);
        if(dayRange==0L){
            //return "今日";
            System.out.println("今日");
        }
        if(dayRange>0L&&dayRange<7L){
            //return dayRange + "天前";
            System.out.println(dayRange + "天前");
        }

        System.out.println("=======111======> ");

        //return timeReminder;
    }
}
