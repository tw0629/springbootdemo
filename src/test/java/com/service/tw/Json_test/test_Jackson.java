package com.service.tw.Json_test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class test_Jackson {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {

        HashMap<Object, Object> map = new HashMap<>();
        map.put("tian","tian");
        map.put("wei","wei");

        String s = mapper.writeValueAsString(map);
        System.out.println("map to string:"+ s);
        Map map2 = mapper.readValue(s, Map.class);
        Object ob = map2.get("tian");
        System.out.println("string to map:"+ ob);
        System.out.println();

    }
}
