package com.tw.gaodemap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.common.util.HttpclientUtil.*;
import com.model.gaodemap.AmapLocationInputModel;
import com.model.gaodemap.MapCoordinateModel;
import compare.urlConnectionAndHttpclient.UrlConnection;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


/**
 *
 *    位置 和 经纬度  之间的转换
 *
 *
 */
public class test {

    RestTemplate restTemplate = new RestTemplate();


    @Test
    public void test() {
        String key = "6be34d3dfe90911058f58278ed89e6fe";  //ycg公司
//      String key = "891f8b10fda5ce1bd2974144200771d1";  //我

//        String coordinate = "121.297906,31.310030";
        String coordinate = "100.197160,25.567816";

        String url = "https://restapi.amap.com/v3/geocode/regeo";

        MapCoordinateModel mapCoordinateModel = new MapCoordinateModel(key, coordinate);
        String address = ApiHttpClient.sendGet(url, mapCoordinateModel.toString());
        System.out.println("=========>" + address);
    }

    @Test
    public void test2() {
        String key = "6be34d3dfe90911058f58278ed89e6fe";  //ycg公司
//      String key = "891f8b10fda5ce1bd2974144200771d1";  //我
        String url = "https://restapi.amap.com/v3/geocode/geo";
//        String address = "上海市水厂路239号";
//        String address = "郑州市中牟县九龙镇四个联动大道与郑民高速交叉口润之新物流园";
        String address = "云南省大理白族自治州大理市下关镇320国道";


        AmapLocationInputModel amapLocationInputModel = new AmapLocationInputModel(address, key);
        String location = ApiHttpClient.sendGet(url, amapLocationInputModel.toString());
        String ss = JSON.parseObject(location).getString("geocodes");
        JSONArray objects = JSON.parseArray(ss);
        String coordinate = objects.getJSONObject(0).getString("location");

        System.out.println("=========>" + coordinate);
    }

    @Test
    public void test3() {
        String key = "6be34d3dfe90911058f58278ed89e6fe"; //ycg公司
//      String key = "891f8b10fda5ce1bd2974144200771d1"; //我

        String url1 = "https://restapi.amap.com/v3/geocode/geo";
        String url2 = "https://restapi.amap.com/v3/geocode/regeo";

        String addressInfo = "上海市嘉定区黄渡镇雅丹路789弄";

        //地址转经纬度
        AmapLocationInputModel amapLocationInputModel = new AmapLocationInputModel(addressInfo, key);
        String location = ApiHttpClient.sendGet(url1, amapLocationInputModel.toString());
        String ss = JSON.parseObject(location).getString("geocodes");
        JSONArray objects = JSON.parseArray(ss);
        String coordinate = objects.getJSONObject(0).getString("location");
        System.out.println("=====coordinate====>" + coordinate);

        System.out.println("=======================================");

        //经纬度转地址
        MapCoordinateModel mapCoordinateModel = new MapCoordinateModel(key, coordinate);
        String address = ApiHttpClient.sendGet(url2, mapCoordinateModel.toString());
        System.out.println("=====address=====>" + address);
    }


    //=============================================以下是为了 测试 httpclient 工具类====================================================
    //换用 httpClientUtils.getHttpClientJson(urladdress)
    @Test
    public void test4() {
        String key = "6be34d3dfe90911058f58278ed89e6fe";  //ycg公司
//      String key = "891f8b10fda5ce1bd2974144200771d1";  //我

//        String coordinate = "121.297906,31.310030";
        String coordinate = "121.364678,31.276646";

        String url = "https://restapi.amap.com/v3/geocode/regeo";

        MapCoordinateModel mapCoordinateModel = new MapCoordinateModel(key, coordinate);
        //String address = ApiHttpClient.sendGet(url, mapCoordinateModel.toString());
        String urladdress = url + "?" + mapCoordinateModel.toString();
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        String result = httpClientUtils.getHttpClientJson(urladdress);
        System.out.println("=========>" + result);
    }


    // 在中国是  经度大于纬度
    @Test
    public void test5() {
        String key = "6be34d3dfe90911058f58278ed89e6fe";  //ycg公司
//      String key = "891f8b10fda5ce1bd2974144200771d1";  //我

//        String coordinate = "121.297906,31.310030";
//        String coordinate = "121.332616,31.263332";
//        String coordinate = "31.263332,121.332616";
//        String coordinate = "23.22,120.22";
//        String coordinate = "120.22,23.22";
//        String coordinate = "39.9031898571,116.3988205872";
//        String coordinate = "117.251587,39.128291";

        String coordinate = "121.437866,31.199190";


        String url = "https://restapi.amap.com/v3/geocode/regeo";

        MapCoordinateModel mapCoordinateModel = new MapCoordinateModel(key, coordinate);
        //String address = ApiHttpClient.sendGet(url, mapCoordinateModel.toString());
        String urladdress = url + "?" + mapCoordinateModel.toString();
        String result = null;
        try {
            result = HttpClientUtil3.getMethodGetResponse(urladdress);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("=========>" + result);
    }

    @Test
    public void test6() {
        String key = "6be34d3dfe90911058f58278ed89e6fe";  //ycg公司
//      String key = "891f8b10fda5ce1bd2974144200771d1";  //我

        String coordinate = "121.297906,31.310030";
        String url = "https://restapi.amap.com/v3/geocode/regeo";


        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        map.put("location", coordinate);

        String result = HttpClientUtil2.doGet(url, map);

        System.out.println("=========>" + result);
    }

    @Test
    public void test7() {
        String key = "6be34d3dfe90911058f58278ed89e6fe";  //ycg公司
//      String key = "891f8b10fda5ce1bd2974144200771d1";  //我

        String coordinate = "121.297906,31.310030";

        String url = "https://restapi.amap.com/v3/geocode/regeo";

        MapCoordinateModel mapCoordinateModel = new MapCoordinateModel(key, coordinate);
        //String address = ApiHttpClient.sendGet(url, mapCoordinateModel.toString());
        String urladdress = url + "?" + mapCoordinateModel.toString();

        String result = HttpClientUtil4.get(urladdress);


        System.out.println("=========>" + result);
    }


    @Test
    public void test8() {
        String key = "6be34d3dfe90911058f58278ed89e6fe";  //ycg公司
//      String key = "891f8b10fda5ce1bd2974144200771d1";  //我

        String coordinate = "121.297906,31.310030";

        //https 和 http
        String url1 = "https://restapi.amap.com/v3/geocode/regeo";
        String url2 = "http://restapi.amap.com/v3/geocode/regeo";

        Map<String, Object> map = new HashMap<>();
        map.put("key", key);
        map.put("location", coordinate);
        JSONObject jsonObject = HttpClientUtils2.doGet(url2, map);
        String result = jsonObject.toString();


        System.out.println("=========>" + result);
    }

    @Test
    public void test9() {
//        String key = "6be34d3dfe90911058f58278ed89e6fe";  //ycg公司
        String key = "891f8b10fda5ce1bd2974144200771d1";  //我
        String coordinate = "121.297906,31.310030";
        String url = "https://restapi.amap.com/v3/geocode/regeo";

        MapCoordinateModel mapCoordinateModel = new MapCoordinateModel(key, coordinate);

        String result = UrlConnection.doGet(url, mapCoordinateModel.toString());

        System.out.println("=========>" + result);
    }


    @Test
    public void test10() {
//        String key = "6be34d3dfe90911058f58278ed89e6fe";  //ycg公司
        String key = "891f8b10fda5ce1bd2974144200771d1";  //我
        String location = "121.297906,31.310030";
        String url = "https://restapi.amap.com/v3/geocode/regeo";


//        Map<String, String> map = new HashMap<>();
//        map.put("key",key);
//        map.put("location", coordinate);
//        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url,List.class,map);
//        ResponseEntity<JSONObject> responseEntity = restTemplate.getForEntity(url,JSONObject.class,map);
//        JSONObject body = responseEntity.getBody();


        //有问题
//        ResponseEntity<List> entityList = restTemplate.getForEntity(url,List.class,key,location);
//        List body = entityList.getBody();


        //没问题，但返回为空
//        ResponseEntity<JSONObject> entityList = restTemplate.getForEntity(url,JSONObject.class,key,location);
//        JSONObject body = entityList.getBody();


        //没问题，但返回为空
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        map.put("location", location);
        ResponseEntity<JSONObject> entityList = restTemplate.getForEntity(url, JSONObject.class, map);
        JSONObject body = entityList.getBody();


        System.out.println("=========>" + body.toString());
    }


    @Test
    public void test11() {
        String s = "";
        String[] location = s.split(",");
//        if(location != null || location.length > 0){
        if (location.length == 0) {
//        if(location.length > 0){
            System.out.println("=========================");
        }

    }
}
