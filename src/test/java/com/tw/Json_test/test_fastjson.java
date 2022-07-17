package com.tw.Json_test;

import cn.hutool.core.lang.Assert;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.model.JsonTestObject;
import com.model.TerminalAddressModel;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;

public class test_fastjson {

    @Test
    public void test() {

        TerminalAddressModel terminalAddressModel = new TerminalAddressModel();
        terminalAddressModel.setProvince("山西");
        terminalAddressModel.setTerminalAddressId(123L);
        terminalAddressModel.setWorkerCode("666");

        System.out.println("============================ com.alibaba.fastjson ===============================");


        //JSON.toJSONString  和  JSON.parseObject
        String s = JSON.toJSONString(terminalAddressModel);
        System.out.println("========>" + s);
        System.out.println("                                       ");
        TerminalAddressModel terminalAddressModel2 = JSON.parseObject(s, TerminalAddressModel.class);
        System.out.println("========>" + terminalAddressModel2);
        System.out.println("                                       ");


        //JSONObject.toJSONString  和  JSONObject.parseObject
        String ss = JSONObject.toJSONString(terminalAddressModel);
        System.out.println("========>" + ss);
        System.out.println("                                       ");
        TerminalAddressModel terminalAddressModel3 = JSONObject.parseObject(ss, TerminalAddressModel.class);
        System.out.println("========>" + terminalAddressModel3);
        System.out.println("                                       ");


        //JSONArray.toJSONString  和  JSONArray.parseObject
        String sss = JSONArray.toJSONString(terminalAddressModel);
        System.out.println("========>" + sss);
        System.out.println("                                       ");
        TerminalAddressModel terminalAddressModel4 = JSONArray.parseObject(sss, TerminalAddressModel.class);
        System.out.println("========>" + terminalAddressModel4);
        System.out.println("                                       ");


        System.out.println("============================ com.alibaba.fastjson ===============================");

        //JSONArray.toJSONString  和  JSONArray.parseObject

/*        String sss = JSON.toJSONString(terminalAddressModel);
        System.out.println("========>"+sss);
        System.out.println("                                       ");
        TerminalAddressModel terminalAddressModel4 = JSONArray.parseObject(ss, TerminalAddressModel.class);
        System.out.println("========>"+terminalAddressModel4);
        System.out.println("                                       ");*/

    }


    //测试 一个字段 是否 可以映射到 对象中的对应字段中去;     测试结果： 可以
    @Test
    public void test2() {
        String params = "{\"workerCode1\":\"156022\"}";
        TerminalAddressModel terminalAddressModel = JSON.parseObject(params, TerminalAddressModel.class);
        System.out.println("===============>" + terminalAddressModel.toString());

    }

    @Test
    public void test3() {

        List<Long> list = Arrays.asList(1L,2L,3L,4L,5L);
        String s = JSONObject.toJSONString(list);

        System.out.println("============> "+s);

    }


    @Test
    public void test4(){

        String json = "{\"id\":\"1\",\"name\":\"json1\",\"car_message\":{\"vin\":\"111\",\"serialName\":\"111\",\"fitStatus\":\"ture\"}}";
        JsonTestObject jsonTestObject = JSON.parseObject(json, JsonTestObject.class);
        System.out.println("===============>" + jsonTestObject.toString());

        System.out.println("10020062918490529859622379520".hashCode()%128);
        System.out.println();

        // String json2 = "{\"payment\":\"{\\\"paymentBehavior\\\":\\\"REGULAR_PAYMENT\\\"}\",\"order\":\"{\\\"orderType\\\":\\\"POS\\\"}\"}";


        String base64MW = "eyJwYXltZW50Ijoie1wicGF5bWVudEJlaGF2aW9yXCI6XCJSRUdVTEFSX1BBWU1FTlRcIn0iLCJvcmRlciI6IntcIm9yZGVyVHlwZVwiOlwiUE9TXCJ9In0=";
        byte[] decoded = Base64.getDecoder().decode(base64MW);


    }

    @Test
    public void test5(){

        String base64MW = "eyJwYXltZW50Ijoie1wicGF5bWVudEJlaGF2aW9yXCI6XCJSRUdVTEFSX1BBWU1FTlRcIn0iLCJvcmRlciI6IntcIm9yZGVyVHlwZVwiOlwiUE9TXCJ9In0=";

        //Original byte[]
        //byte[] bytes = base64MW.getBytes();

        //Base64 Encoded
        //String encoded = Base64.getEncoder().encodeToString(bytes);

        //Base64 Decoded
        byte[] decoded = Base64.getDecoder().decode(base64MW);

        //Verify original content
        System.out.println(new String(decoded));
        System.out.println(isBase64(base64MW));
        System.out.println("");


    }

    @Test
    public void test56(){
        String a = "";
        String b = null;
        String c = "  ";
        String d = "d";

        //Assert.isNull(b);
        //Assert.notNull(b);
        Assert.notEmpty(a);

    }

    private static boolean isBase64(String str) {
        String base64Pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
        return Pattern.matches(base64Pattern, str);
    }

}
