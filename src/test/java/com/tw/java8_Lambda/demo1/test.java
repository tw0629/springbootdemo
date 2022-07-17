package com.tw.java8_Lambda.demo1;

import com.tw.A_commonObject.Order;
import com.tw.Date_test.DateUtils;
import com.tw.Date_test.DateUtils2;
import com.tw.Date_test.DateUtils3;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author David Tian
 * @desc https://mp.weixin.qq.com/s/vqxPxoxRzfTVGFswnpv4iQ
 * @since 2020-09-01 19:44
 */
public class test {

    private static List<Apple> appleList = new ArrayList<>();//存放apple对象集合

    static {

        Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
        Apple apple12 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
        Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
        Apple apple3 =  new Apple(3,"荔枝",new BigDecimal("9.99"),40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);
    }


    /**
     * 1、分组
     * List里面的对象元素，以某个属性来分组，例如，以id分组，将id相同的放在一起：
     */
    @Test
    public void test(){

        //写法逻辑: List 以ID分组 Map<Integer,List<Apple>>
        Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));

        System.err.println("groupBy:"+groupBy);
        //{1=[Apple{id=1, name='苹果1', money=3.25, num=10},
        //    Apple{id=1, name='苹果2', money=1.35, num=20}],
        // 2=[Apple{id=2, name='香蕉', money=2.89, num=30}],
        // 3=[Apple{id=3, name='荔枝', money=9.99, num=40}]}

    }


    /**
     * 2、List转Map
     */
    @Test
    public void test2(){

        //写法逻辑：需要注意的是：
        // toMap 如果集合对象有重复的key，会报错Duplicate key ....
        // apple1,apple12的id都为1。
        // 可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2

        // Collectors.toMap(key,v->v,(v1,v2)->v1)
        //其中key 就是map得key值
        //第二个参数就是map得value
        //第三个参数的作用是当出现一样的key值得时候如何取舍其中V1代表旧值，v2代表新值，示例中取旧值
        Map<Integer, Apple> appleMap = appleList.stream().collect(Collectors.toMap(Apple::getId, a -> a,(k1,k2)->k1));

        System.out.println("List转Map ===> " + appleMap);

        /*for(Map.Entry entry : appleMap.entrySet()){

            System.out.println("    ===> "+entry.getKey()+":"+entry.getValue().toString());
        }*/

        //List转Map ===> {1=com.tw.java8_Lambda.demo1.Apple@dbd940d, 2=com.tw.java8_Lambda.demo1.Apple@71d15f18, 3=com.tw.java8_Lambda.demo1.Apple@17695df3}
    }


    /**
     * 3 过滤Filter
     * 从集合中过滤出来符合条件的元素：
     */
    @Test
    public void test3(){
        //过滤出符合条件的数据
        List<Apple> filterList = appleList.stream().filter(a -> !a.getName().equals("香蕉")).collect(Collectors.toList());
        //appleList.stream().filter(a -> a.getName().equals("香蕉")).collect(Collectors.toList());

        System.err.println("filterList:"+filterList);
        //[Apple{id=2, name='香蕉', money=2.89, num=30}]

    }

    /**
     * 4、求和
     * 将集合中的数据按照某个属性求和
     */
    @Test
    public void test4(){

        //计算 总金额
        BigDecimal totalMoney = appleList.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.err.println("totalMoney:"+totalMoney);  //totalMoney:17.48
    }

    /**
     * 5、查找流中最大 最小值
     * Collectors.maxBy 和 Collectors.minBy 来计算流中的最大或最小值。
     */
    @Test
    public void test5(){
//        Optional<Dish> maxDish = Dish.menu.stream().
//                collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
//        maxDish.ifPresent(System.out::println);
//
//        Optional<Dish> minDish = Dish.menu.stream().
//                collect(Collectors.minBy(Comparator.comparing(Dish::getCalories)));
//        minDish.ifPresent(System.out::println);
    }


    @Test
    public void test6(){

      // 根据id去重
//      List<Apple> unique = appleList.stream().collect(
//              collectingAndThen(toCollection(() -> new TreeSet<Apple>(comparingLong(Apple::getId))), ArrayList::new));

    }


    /**
     * 分组最大
     */
    @Test
    public void test7(){
        List<Order> orderList = initOrderData();

        Map<String, List<Order>> mapOrder = orderList.stream().collect(Collectors.groupingBy(Order::getNo));

        Map<String, Optional<Order>> collect1 = orderList.stream().collect(Collectors.groupingBy(Order::getNo, Collectors.maxBy(Comparator.comparingLong(Order::getOrder))));
        List<Order> collect11 = collect1.values().stream().map(Optional::get).collect(Collectors.toList());

        Map<String, Optional<Order>> collect2 = orderList.stream().collect(Collectors.groupingBy(Order::getNo, Collectors.maxBy(Comparator.comparing(Order::getOrder))));
        List<Order> collect21 = collect2.values().stream().map(Optional::get).collect(Collectors.toList());


        List<Order> collect3 = collect11.stream().sorted(Comparator.comparing(Order::getDate, Comparator.reverseOrder())).collect(Collectors.toList());
        List<Order> collect4 = collect21.stream().sorted(Comparator.comparing(Order::getDate, Comparator.reverseOrder())).collect(Collectors.toList());

        System.out.println("");


    }

    public List<Order> initOrderData(){
        List<Order> orderList = new ArrayList<>();
        Order order = new Order();
        order.setNo("1");
        order.setOrder(1L);
        order.setDataLong(1L);
        order.setDate(DateUtils2.StringToDate("2022-04-01 06:00:00"));
        orderList.add(order);
        Order order2 = new Order();
        order2.setNo("1");
        order2.setOrder(2L);
        order2.setDataLong(2L);
        order2.setDate(DateUtils2.StringToDate("2022-04-06 06:00:00"));
        orderList.add(order2);
        Order order3 = new Order();
        order3.setNo("1");
        order3.setOrder(3L);
        order3.setDataLong(3L);
        order3.setDate(DateUtils2.StringToDate("2022-04-10 06:00:00"));
        orderList.add(order3);

        Order order4 = new Order();
        order4.setNo("2");
        order4.setOrder(4L);
        order4.setDataLong(4L);
        order4.setDate(DateUtils2.StringToDate("2022-05-10 06:00:00"));
        orderList.add(order4);
        Order order5 = new Order();
        order5.setNo("2");
        order5.setOrder(5L);
        order5.setDataLong(5L);
        order5.setDate(DateUtils2.StringToDate("2022-05-15 06:00:00"));
        orderList.add(order5);
        Order order6 = new Order();
        order6.setNo("2");
        order6.setOrder(6L);
        order6.setDataLong(6L);
        order6.setDate(DateUtils2.StringToDate("2022-05-20 06:00:00"));
        orderList.add(order6);

        Order order7 = new Order();
        order7.setNo("3");
        order7.setOrder(7L);
        order7.setDataLong(7L);
        order7.setDate(DateUtils2.StringToDate("2022-06-20 06:00:00"));
        orderList.add(order7);
        Order order8 = new Order();
        order8.setNo("3");
        order8.setOrder(8L);
        order8.setDataLong(8L);
        order8.setDate(DateUtils2.StringToDate("2022-06-23 06:00:00"));
        orderList.add(order8);
        Order order9 = new Order();
        order9.setNo("3");
        order9.setOrder(9L);
        order9.setDataLong(9L);
        order9.setDate(DateUtils2.StringToDate("2022-06-26 06:00:00"));
        orderList.add(order9);

        return orderList;
    }

}

