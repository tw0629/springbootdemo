package com.service.tw.DataStructures.tree;

import com.service.tw.A_commonObject.Order;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author David Tian
 * @since 2019-05-22
 */
public class TreeMapTest2 {


    @Test
    public void test(){

        TreeMap<Order, String> tree = new TreeMap<>(new Comparator<Order>() {

            @Override
            public int compare(Order o1, Order o2) {

                return o2.getDate().compareTo(o1.getDate());
            }
        });
        init(tree);

        print(tree);
    }

    public static void init(Map<Order, String> map) {
        Order order = null;
        Date date1 = createDate("2016-10-24 21:59:06");
        order = new Order("1",date1);
        map.put(order, "1");

        Date date2 = createDate("2017-10-24 21:59:06");
        order = new Order("2",date2);
        map.put(order, "2");

        Date date3 = createDate("2018-10-24 21:59:06");
        order = new Order("3",date3);
        map.put(order, "3");

        Date date4 = createDate("2019-10-24 21:59:06");
        order = new Order("4",date4);
        map.put(order, "4");

        Date date5 = createDate("2020-10-24 21:59:06");
        order = new Order("5",date5);
        map.put(order, "5");

    }

    public static Date createDate(String date){

        //String string = "2016-10-24 21:59:06";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = sdf.parse(date);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        //System.out.println(parse);

        return parse;
    }

    public static void print(Map<Order, String> map) {
        Iterator<Map.Entry<Order, String>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Order, String> entry = it.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }


}
