package com.tw.DataStructures.List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author David Tian
 * @since 2019-03-25
 */
public class listTest {

    @Test
    public void test5() {

        List<String> nullList = new ArrayList();
        nullList.add(null);
        nullList.add("");
        nullList.add("");
        nullList.add("w");
        nullList.add("");
        nullList.add("");
        //nullList.removeAll(nullList);
        nullList.removeAll(Collections.singleton(null));

        System.out.println("============>"+nullList.toString());
    }

    @Test
    public void test6() {

        List<String> nullList = new ArrayList();
        nullList.add("");
        nullList.add("1");
        nullList.add("1");
        nullList.add("w");
        nullList.add("w");
        nullList.add("");
        List uniqueVins = nullList.stream().distinct().collect(Collectors.toList());

        System.out.println("============>"+uniqueVins.toString());
        System.out.println("============>"+nullList.toString());

    }
}
