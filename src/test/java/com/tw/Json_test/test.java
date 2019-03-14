package com.tw.Json_test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.model.SendReceivePunchModel;
import org.junit.Test;

import java.util.Map;

public class test {

    @Test
    public void test() {
        /*JSONObject dataJson=new JSONObject("你的Json数据");
        JSONObject  response= dataJson.getJSONObject("response");
        JSONArray data=response.getJSONArray("data");
        JSONObject info=data.getJSONObject(0);
        String province=info.getString("province");
        String city=info.getString("city");
        String district=info.getString("district");
        String address=info.getString("address");
        System.out.println(province+city+district+address);*/


//        Map<String,String> strmap=new JSONObject();
//        System.out.println(strmap);

        String json = "{\"id\":\"1\",\"name\":\"Json技术\"}";
        JSONObject s1 = JSON.parseObject(json);
        Map map = JSON.toJavaObject(s1, Map.class);
        Object s2 = JSON.parse(json);
        Map map2 = JSON.toJavaObject((JSONObject) s2, Map.class);

        JSONObject s3 = JSONObject.parseObject(json);
        Object s4 = JSONObject.parse(json);
        JSONObject s5 = JSONArray.parseObject(json);
        Object s6 = JSONArray.parse(json);

        System.out.println("=============>" + s1);
        System.out.println("=============>" + map);
        System.out.println("=============>" + s2);
        System.out.println("=============>" + map2);
        System.out.println("=============>" + s3);
        System.out.println("=============>" + s4);
        System.out.println("=============>" + s5);
        System.out.println("=============>" + s6);


    }


    @Test
    public void test2() {

//        String json2 = "{\"id\":\"1\",\"name\":\"Json技术\"}";
//        JSONArray s7 = JSON.parseArray(json2);
//        System.out.println("=============>" + s7);

        JSON json = new JSONObject();
        JSON json2 = new JSONArray();

    }

    @Test
    public void test3(){
        String s = "{\"workerCode\":\"28856\"}";
        SendReceivePunchModel sendReceivePunchModel = JSON.parseObject(s, SendReceivePunchModel.class);
        System.out.println("============> "+sendReceivePunchModel.toString() );
    }

}


