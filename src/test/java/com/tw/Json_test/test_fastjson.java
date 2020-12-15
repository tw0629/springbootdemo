package com.tw.Json_test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.model.TerminalAddressModel;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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


}
