package com.tw.Json_test;


import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;



/*
 * 将符合json格式的字符串转为json对象并分别取出里面的数据。
 *
 * 引入json jar包时，请引入"import net.sf.json.JSONObject"
 *
 */


public class test_json_lib {

    @Test
    public void test1() {

        //模拟获取到的符合json格式的字符串{"data":{"pow":100,"net":99,"dev":69},"success":true,"message":"成功"}
        String jsonStr = "{\"data\":{\"pow\":100,\"net\":99,\"dev\":69},\"success\":true,\"message\":\"成功\"}";
        System.out.println("1---将符合json格式的字符串jsonStr=====" + jsonStr);

        //将符合json格式的字符串转换为JSONObject
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        System.out.println("2---转换为JSONObject=====" + jsonObject);

        //取出json对象里的data数据。
        JSONObject jsonData = jsonObject.getJSONObject("data");
        System.out.println("3---取出json对象里的data数据  jsonData=====" + jsonData);

        String success = jsonObject.getString("success");
        String message = jsonObject.getString("message");
        System.out.println("4---success=====" + success + "  |  message=====" + message);

        //取出jsonData数据里的pow,net,dev数据。
        String pow = jsonData.getString("pow");
        String net = jsonData.getString("net");
        String dev = jsonData.getString("dev");
        System.out.println("5---pow=" + pow + " | " + "net=" + net + " | " + "dev=" + dev);

    }

    @Test
    public void test2() {

        //模拟获取到的json对象数组格式的字符串{"total":"1","rows":[{"createdate":"2017-10-26 00:00:00","name":"aaaa"},{"createdate":"2017-10-27 13:39:35","name":"bbb"}]}
        String jsonArrayStr = "{\"total\":\"1\",\"rows\":[{\"createdate\":\"2017-10-26 00:00:00\",\"name\":\"aaaa\"},{\"createdate\":\"2017-10-27 13:39:35\",\"name\":\"bbb\"}]}";
        System.out.println("1---将符合json对象数组格式的字符串jsonArrayStr=====" + jsonArrayStr);

        //将符合json对象数组格式的字符串转换为json对象
        JSONObject jsonObject = JSONObject.fromObject(jsonArrayStr);
        System.out.println("2---转换为JSONObject=====" + jsonObject);

        //取出json对象里的total数据。
        String strTotal = jsonObject.getString("total");
        System.out.println("3---取出json对象里的total数据  total=====" + strTotal);

        //取出json对象里的rows数据
        String strRows = jsonObject.getString("rows");
        System.out.println("4---取出json对象里的rows数据  jsonRows=====" + strRows);

        //转换成json对象数组
        JSONArray jsonArrayRows = JSONArray.fromObject(strRows);
        System.out.println("5---strRows转换为JsonArray数据 jsonArrayRows=====" + jsonArrayRows);
        //从数组里取出各值。
        for (int i = 0; i < jsonArrayRows.size(); i++) {
            JSONObject jsonObjectRows = (JSONObject) jsonArrayRows.get(i);
            String createdate = jsonObjectRows.get("createdate").toString();
            String name = jsonObjectRows.get("name").toString();
            System.out.println("6---createdate=====" + createdate + "  |   name=====" + name);

            JSONObject s1 = (JSONObject) jsonArrayRows.get(i);
//            JSONArray s2 = (JSONArray)jsonArrayRows.get(i);
            JSON s3 = (JSON) jsonArrayRows.get(i);
            System.out.println("                                                 ");
            System.out.println("========>" + s1);
//            System.out.println("========>"+s2);
            System.out.println("========>" + s3);
            System.out.println("                                                 ");
        }

    }


    @Test
    public void test3() {
        JSONArray jsonArray3 = JSONArray.fromObject("['json','is','easy']");

        System.out.println("==========>" + jsonArray3);
    }
}
