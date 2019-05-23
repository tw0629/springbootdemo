package com.tw.DataStructures.tree;

import org.junit.Test;

import java.util.*;

/**
 * @author David Tian
 * @since 2019-05-21
 *
 *
 * TreeMap 是一个有序的key-value集合，它是通过红黑树实现的。
 * TreeMap 继承于AbstractMap，所以它是一个Map，即一个key-value集合。
 * TreeMap 实现了NavigableMap接口，意味着它支持一系列的导航方法。比如返回有序的key集合。
 * TreeMap 实现了Cloneable接口，意味着它能被克隆。
 * TreeMap 实现了java.io.Serializable接口，意味着它支持序列化。
 *
 * TreeMap基于红黑树（Red-Black tree）实现。该映射根据其键的自然顺序进行排序，或者根据创建映射时提供的 Comparator 进行排序，具体取决于使用的构造方法。
 * TreeMap的基本操作 containsKey、get、put 和 remove 的时间复杂度是 log(n) 。
 * 另外，TreeMap是非同步的。 它的iterator 方法返回的迭代器是fail-fastl的。
 *
 */
public class TreeMapTest {

    /**
     *
     * key 有序不重复
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("---------------- 默认 排序结果-----------------");
        createDefaultSortTreeMap();
        System.out.println("---------------- 自定义 排序结果-----------------");
        createDefinitionSortTreeMap();
    }

    public static void createDefaultSortTreeMap() {
        TreeMap<String, String> map = new TreeMap<String, String>();

        init(map);
        print(map);
    }

    public static void createDefinitionSortTreeMap() {

        TreeMap<String, String> map = new TreeMap<String, String>(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }

        });

        init(map);
        print(map);
    }

    public static void init(Map<String, String> map) {
        map.put("c", "1");
        map.put("a", "1");
        map.put("bb", "1");
        map.put("b", "1");
        map.put("b", "2");
    }

    public static void print(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }


    /**
     *
     *  KEY 无序不重复
     */
    @Test
    public void test(){

        Map<String, String> map = new HashMap<>();
        init(map);

        System.out.println("=====>"+map);
    }

    @Test
    public void test2(){

        TreeMap<Object, Object> objectObjectTreeMap = new TreeMap<>();
    }

}
