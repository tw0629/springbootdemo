package com.service.tw.java8_Lambda;

import com.service.tw.A_commonObject.Order;
import org.assertj.core.util.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author David Tian
 * @desc
 * @since 2020-01-07 16:59
 */
public class test1 {

    public static void main(String[] args) {
        //test();
    }


    public void test(){

        List<String> DBTypes = Arrays.asList("Oracle", "SYBASE","MYSQl子对象");
        List<String> JMXTypes = Arrays.asList( "消息中间件", "JBoss子对象", "Tomcat子对象",  "Apache子对象");
        List<String> HOSTTypes = Arrays.asList("HOST", "主机子对象");
        List<String> WMITypes = Arrays.asList("Windows单进程", "Windows");

        Map<String, String> map = Maps.newHashMap("","init");
        map.putAll(DBTypes.stream().collect(Collectors.toMap(Function.identity(), i -> "JDBC")));
        map.putAll(JMXTypes.stream().collect(Collectors.toMap(Function.identity(), i -> "JMX")));
        map.putAll(HOSTTypes.stream().collect(Collectors.toMap(Function.identity(), i -> "HOST")));
        map.putAll(WMITypes.stream().collect(Collectors.toMap(Function.identity(), i -> "WMI")));

        System.out.println("=======>"+map);

        String name = "主机子对象";
        String parentType=map.get(name);
        System.out.println("=======>" + parentType);

        System.out.println("======================>");



    }

    @Test
    public void test2(){
        List<Order> orderList = new ArrayList<>();

        List<String> list = Arrays.asList("2", "1","3", "7","6","8", "4","5");
        Order order = new Order();
        order.setNo("1");
        order.setList(list);
        orderList.add(order);

        List<String> list2 = Arrays.asList("22", "21","23", "27","26","28", "24","25");
        Order order2 = new Order();
        order2.setNo("2");
        order2.setList(list2);
        orderList.add(order2);

        List<Order> orderList2 = new ArrayList<>();
        Order order3 = new Order();
        order3.setNo("3");
        order3.setList(null);
        orderList2.add(order3);

        System.out.println(orderList2);

    }


}
