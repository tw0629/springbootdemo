package com.service.tw.java8_Lambda.demo_FunctionalInterface;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author David Tian
 * @desc
 * @since 2022/1/21 10:55
 */
public class functionalInterfaceTest {

    /**
     * Consumer
     */
    @Test
    public void test(){
        Consumer<Integer> consumer = x -> {
            int a = x + 2;
            System.out.println(a);// 12
            System.out.println(a + "_");// 12_
        };
        consumer.accept(10);

        Consumer<Integer> consumer2 = x -> {
            int a = x + 3;
            System.out.println(a);// 12
            System.out.println(a + "_");// 12_
        };
        consumer.andThen(consumer2);
    }

    /**
     * BiConsumer
     *
     * Map接口的终端操作，forEach的参数就是BiConsumer函数接口，对HashMap 的数据进行消费；
     *
     */
    @Test
    public void test2(){

        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");

        // forEach的参数就是BiConsumer函数接口
        map.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });

    }

}
