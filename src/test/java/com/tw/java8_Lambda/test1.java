package com.tw.java8_Lambda;

import org.assertj.core.util.Maps;

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


}
