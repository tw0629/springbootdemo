package com.service.tw.java8_Lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Optional;

/**
 * @author David Tian
 * @desc
 * @since 2022/9/1 17:35
 */
public class OptionalTest {

    @Test
    public void test2() {

        Item3 item3 = new Item3("4个");
        Item2 item2 = new Item2(item3);
        Item item = new Item(item2);

        String data = Optional.ofNullable(item.getItem2()).map(Item2::getItem3).map(Item3::getItem4).orElse("aaa");

        System.out.println(data);

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Item{
        private Item2 item2;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Item2{
        private Item3 item3;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Item3{
        private String item4;
    }
}
