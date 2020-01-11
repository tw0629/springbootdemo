package com.tw.gaodemap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.util.HttpclientUtil.ApiHttpClient;
import com.model.gaodemap2.CheckInfoModel;
import com.model.gaodemap2.MapCoordinateModel2;
import com.model.gaodemap2.ReponseDistance;
import org.junit.Test;

public class test2 {

    /**
     *
     *   两个经纬度之间的距离
     *   两个地址之间的距离
     *
     *   address=上海市水厂路239号
     *   "location" : "121.363817,31.273409",
     *
     *   address=上海市普陀区武威路地铁站
     *   "location" :"121.364678,31.276646",
     *
     */


    @Test
    public void test() {
        String key = "6be34d3dfe90911058f58278ed89e6fe";  //ycg公司
//      String key = "891f8b10fda5ce1bd2974144200771d1";  //我

        String origins = "121.364678,31.276646";
        String destination = "121.363817,31.273409";

//        String url = "https://restapi.amap.com/v3/geocode/regeo";
        String url = "https://restapi.amap.com/v3/distance";
        MapCoordinateModel2 mapCoordinateModel2 = new MapCoordinateModel2(key, origins, destination);

        String address = ApiHttpClient.sendGet(url, mapCoordinateModel2.toString());

        System.out.println("                     " );
        System.out.println("=========>" + address);

        ReponseDistance reponseDistance = JSONObject.parseObject(address, ReponseDistance.class);

        if (Integer.parseInt(reponseDistance.getStatus()) == 1) {

            String distance = reponseDistance.getResults().get(0).getDistance();
            System.out.println("                     " );
            System.out.println("=========>" + distance);
        }

    }


    @Test
    public void test2() {

        String key = "891f8b10fda5ce1bd2974144200771d1";
        String origins = "121.364678,31.276646";
        String destination = "121.363817,31.273409";
        String amapDistanceUrl = "https://restapi.amap.com/v3/distance";

        MapCoordinateModel2 amapDistanceInputModel = new MapCoordinateModel2(key,origins,destination);
        System.out.println("getDistanceByCoordinate params Info Json = " + JSON.toJSONString(amapDistanceInputModel));

        CheckInfoModel checkInfoModel = new CheckInfoModel();
        String resultAmapInfo = ApiHttpClient.sendGet(amapDistanceUrl, amapDistanceInputModel.toString());

        System.out.println("getDistanceByCoordinate result Info Json = " + resultAmapInfo);

        ReponseDistance reponseDistance = JSON.parseObject(resultAmapInfo,ReponseDistance.class);


        if(null == reponseDistance){
            checkInfoModel.setValue(false, "Amap Result is null");
//            return checkInfoModel;
            System.out.println("=======>"+checkInfoModel.toString());
        }

        if(!reponseDistance.getStatus().equals("1")){
            checkInfoModel.setValue(false, reponseDistance.getInfo());
//            return checkInfoModel;
            System.out.println("=======>"+checkInfoModel.toString());
        }

        String distance = reponseDistance.getResults().get(0).getDistance();

        checkInfoModel.setValue(true, distance);
//            return checkInfoModel;
        System.out.println("=======>"+checkInfoModel.toString());

    }

}
