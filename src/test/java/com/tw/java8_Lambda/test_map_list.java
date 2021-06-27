package com.tw.java8_Lambda;

import org.checkerframework.checker.units.qual.K;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class test_map_list {

    private Map<String, Integer> items;

    @Before
    public void init(){
        items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
    }


    // 遍历Map
    @Test
    public void test() {

        //==============Java8之前的方式==============
        System.out.println("                                            ");
        System.out.println("++++++++++++++Java8之前的方式+++++++++++++++");
        System.out.println("                                            ");

        //==============第一种：通过Map.keySet遍历key和value==============
        System.out.println("==============通过Map.keySet遍历key和value================推荐======");
        for (String key : items.keySet()) {
            System.out.println("key= " + key + " and value= " + items.get(key));
        }

        //==============第二种：通过Map.values()遍历所有的value，但不能遍历key==============
        System.out.println("==============通过Map.values()遍历所有的value，但不能遍历key==============");
        for (Integer v : items.values()) {
            System.out.println("value= " + v);
        }

        //==============第三种：通过Map.entrySet使用iterator遍历key和value==============
        System.out.println("==============通过Map.entrySet使用iterator遍历key和value==============");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }

        //==============第四种：通过Map.entrySet使用iterator遍历key和value==============
        System.out.println("==============通过Map.entrySet使用iterator遍历key和value==============");
        Iterator<Map.Entry<String, Integer>> it = items.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //==============第五种：使用迭代器遍历列表==============
        System.out.println("==============使用迭代器遍历列表==============");
        Set<String> set = items.keySet();
        Iterator<String> it2 = set.iterator();
        while (it2.hasNext()) {
            String str = it2.next();
            System.out.println(str + "/" + items.get(str));
        }


        //============Java8的方式==========
        System.out.println("                                            ");
        System.out.println("++++++++++++++++Java8的方式++++++++++++++++++");
        System.out.println("                                            ");

        //==============第五种: forEach + Lambda表达式==============
        System.out.println("==============forEach + Lambda表达式==================推荐=======");
        items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));


        items.forEach((k, v) -> {
            System.out.println("Item : " + k + " Count : " + v);
            if ("E".equals(k)) {
                System.out.println("Hello E");
            }
        });

    }


    // 遍历List:
    @Test
    public void test2() {

        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");

        //============Java8之前的方式==========
        System.out.println("                                            ");
        System.out.println("++++++++++++++Java8之前的方式+++++++++++++++");
        System.out.println("                                            ");

        //============第一种：使用最简单的循环遍历列表==========
        System.out.println("============使用最简单的循环遍历列表==========");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }

        //============第二种：使用for-each循环遍历列表==========
        System.out.println("============使用for-each循环遍历列表=================推荐======");
        for (String item : items) {
            System.out.println(item);
        }

        //============第三种：使用方法引用遍历列表==========
        System.out.println("============使用方法引用遍历列表==========");
        items.forEach(System.out::println);

        //============第四种：使用迭代器遍历列表==========
        System.out.println("============使用迭代器遍历列表==========");
        Iterator<String> it = items.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }


        //============Java8的方式====================
        System.out.println("                                            ");
        System.out.println("++++++++++++++++Java8的方式++++++++++++++++++");
        System.out.println("                                            ");

        //============第五种：forEach + Lambda表达式==========
        System.out.println("============forEach + Lambda表达式================推荐======");
        items.forEach(item -> System.out.println(item));


        items.forEach(item -> {
            if ("C".equals(item)) {
                System.out.println(item);
            }
        });
    }

    // new Thread()
    @Test
    public void test3() {

        // Java 8之前：
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();


        // Java 8方式：
        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();

    }

    // Swing API编程
    @Test
    public void test4() {
        // Java 8之前：
        JButton show = new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });

        // Java 8方式：
        show.addActionListener((e) -> {
            System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
        });
    }

    @Test
    public void test5() {
        // Java 8之前：
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }

        // Java 8之后：
        List<String> features2 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));

        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
        features2.forEach(System.out::println);

    }

    @Test
    public void test6() {

        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter2(languages, (str) -> ((String) str).startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> ((String) str).endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> ((String) str).length() > 4);


    }

    public static void filter(List<String> names, Predicate condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    public static void filter2(List names, Predicate condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });
    }


    @Test
    public void test7() {
        List<String> names = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        //甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
        //例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        names.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));
    }

    @Test
    public void test8() {
        // 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            System.out.println(price);
        }

        // 使用lambda表达式
        List<Integer> costBeforeTax2 = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax2.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);

    }

    @Test
    public void test9() {

        // 为每个订单加上12%的税
        // 老方法：
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            total = total + price;
        }
        System.out.println("Total : " + total);

        // 新方法：
        List<Integer> costBeforeTax2 = Arrays.asList(100, 200, 300, 400, 500);
        Double doublebill = costBeforeTax2.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + doublebill);
    }

    @Test
    public void test10() {

        List<String> strList = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp", "d", "dd");

        // 创建一个字符串列表，每个字符串长度大于2
        List<String> filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
        System.out.println("======>" + strList.toString());
        System.out.println("======>" + filtered.toString());
    }

    @Test
    public void test11() {

        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);
    }

    @Test
    public void test12() {
        // 用所有不同的数字创建一个正方形列表
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }

    @Test
    public void test13() {
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }

    /**
     * map computeIfAbsent方法
     */
    @Test
    public void test14() {

        /*
        // 方法定义
        default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
            ...
        }

        // java8之前。从map中根据key获取value操作可能会有下面的操作
        Object key = map.get("key");
        if (key == null) {
            key = new Object();
            map.put("key", key);
        }*/


        // java8之后。上面的操作可以简化为一行，若key对应的value为空，会将第二个参数的返回值存入并返回
        // Map<String, Integer> items
        Object key  = items.computeIfAbsent("Z", k -> 8);
        Object key2 = items.computeIfAbsent("A", k -> 1);

        System.out.println("======>");

    }

}
