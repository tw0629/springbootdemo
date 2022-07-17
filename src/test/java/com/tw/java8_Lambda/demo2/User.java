package com.tw.java8_Lambda.demo2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author David Tian
 * @desc
 * @since 2022/7/17 14:23
 */
public class User {

    private String id;
    private String name;
    private String groupId;
    private int num;
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String id, String name, String groupId, int num, int age) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
        this.num = num;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", groupId='" + groupId + '\'' +
                ", num=" + num +
                ", age=" + age +
                '}';
    }


    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>(10);
        list.add(new User("1", "1号", "A", 10, 10));
        list.add(new User("2", "2号", "A", 20, 10));
        list.add(new User("3", "3号", "E", 50, 12));
        list.add(new User("4", "4号", "B", 60, 20));
        list.add(new User("5", "5号", "C", 80, 40));
        list.add(new User("6", "6号", "B", 220, 20));
        list.add(new User("7", "7号", "A", 110, 2));
        list.add(new User("8", "8号", "D", 110, 68));
        //去重复获取组
        System.out.println("----------去重复获取组-------------------");
        list.stream().filter(distinctByKey(User::getGroupId)).map(User::getGroupId).forEach(s -> {
            System.out.println(s);
        });
        //从第2个开始(下标)
        System.out.println("-------------从第2个开始----------------");
        list.stream().skip(2).forEach(s -> {
            System.out.println(s);
        });
        //取10以内的
        System.out.println("-------------取10以内的----------------");
        list.stream().filter(user -> user.getAge() <= 10).forEach(s -> {
            System.out.println(s);
        });
        //取最大
        System.out.println("----------------取最大-------------");
        User user = list.stream().max(Comparator.comparing(User::getNum)).get();
        System.out.println(user);
        //分组求合
        System.out.println("---------------分组求合--------------");
        list.stream().collect(Collectors.groupingBy(User::getGroupId, Collectors.summingInt(User::getNum))).forEach((k, v) -> {
            System.out.println("K:" + k + "-V:" + v);
        });
        //分组取组内最大
        System.out.println("--------------分组取组内最大---------------");
        list.stream().collect(Collectors.groupingBy(User::getGroupId, Collectors.maxBy(Comparator.comparingInt(User::getNum)))).forEach((k, v) -> {
            System.out.println("K:" + k + "-V:" + v.get());
        });
        //分组取组内最小
        System.out.println("------------分组取组内最小-----------------");
        list.stream().collect(Collectors.groupingBy(User::getGroupId, Collectors.minBy(Comparator.comparingInt(User::getNum)))).forEach((k, v) -> {
            System.out.println("K:" + k + "-V:" + v.get());
        });
        //分组聚合多列
        System.out.println("---------------分组聚合多列计算--------------");
        list.stream().collect(Collectors.groupingBy(User::getGroupId, Collectors.collectingAndThen(Collectors.toList(), users -> {
            Double[] ints = new Double[2];
            Double asDouble1 = users.stream().mapToInt(User::getNum).average().getAsDouble();
            Double asDouble2 = users.stream().mapToInt(User::getAge).average().getAsDouble();
            ints[0] = asDouble1;
            ints[1] = asDouble2;
            return ints;
        }))).forEach((k, v) -> {
            System.out.println("K:" + k + "-V:" + v[0] + "," + v[1]);
        });
        //分组后组内排序
        System.out.println("---------------分组后组内排序--------------");
        list.stream().collect(Collectors.groupingBy(User::getGroupId, Collectors.collectingAndThen(Collectors.toList(), users -> {
            users.sort(Comparator.comparing(User::getNum).reversed());
            return users;
        }))).forEach((k, v) -> {
            System.out.println("k:" + k);
            System.out.println("v----->:");
            v.forEach(s -> {
                System.out.println(s);
            });
        });

    }
}
