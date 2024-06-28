package com.service.tw.java8_Lambda;

import com.model.TerminalAddressEntity;
import com.service.tw.java8_Lambda.demo1.Apple;
import com.service.tw.java8_Lambda.demo2.Student;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.*;

public class test_stream_foreach {

    @Test
    public void test() {
        //初始化数据
        List<TerminalAddressEntity> dispatchList = new ArrayList<>();
        TerminalAddressEntity terminalAddressEntity = new TerminalAddressEntity();
        terminalAddressEntity.setTerminalAddressId(1L);
        terminalAddressEntity.setProvince("1");
        terminalAddressEntity.setWorkerCode("1");
        dispatchList.add(terminalAddressEntity);

        terminalAddressEntity = new TerminalAddressEntity();
        terminalAddressEntity.setTerminalAddressId(2L);
        terminalAddressEntity.setProvince("2");
        terminalAddressEntity.setWorkerCode("2");
        dispatchList.add(terminalAddressEntity);

        terminalAddressEntity = new TerminalAddressEntity();
        terminalAddressEntity.setTerminalAddressId(3L);
//        terminalAddressEntity.setProvince("1");
//        terminalAddressEntity.setWorkerCode("1");
        dispatchList.add(terminalAddressEntity);

        terminalAddressEntity = new TerminalAddressEntity();
        terminalAddressEntity.setTerminalAddressId(4L);
        terminalAddressEntity.setProvince("4");
        terminalAddressEntity.setWorkerCode("4");
        dispatchList.add(terminalAddressEntity);

        terminalAddressEntity = new TerminalAddressEntity();
        terminalAddressEntity.setTerminalAddressId(5L);
//        terminalAddressEntity.setProvince("1");
//        terminalAddressEntity.setWorkerCode("1");
        dispatchList.add(terminalAddressEntity);

        //==========================================

        List<TerminalAddressEntity> exDispatchModels = new ArrayList<>();

        TerminalAddressEntity terminalAddressEntity2 = new TerminalAddressEntity();
        terminalAddressEntity2.setTerminalAddressId(777777L);
        terminalAddressEntity2.setProvince("xxxxx");
        terminalAddressEntity2.setWorkerCode("xxxxx");
        exDispatchModels.add(terminalAddressEntity2);

        System.out.println("======================本次初始化的数据 如下：=====================");
        System.out.println("                                                                 ");
        System.out.println("dispatchList ：  " + dispatchList.toString());
        System.out.println("                                                                 ");
        System.out.println("exDispatchModels ：  " + exDispatchModels.toString());
        System.out.println("                                                                 ");


        System.out.println("==============本次测试的逻辑代码 ----- Lambda表达式 如下：================");

        //   本次测试的逻辑代码 ----- Lambda表达式

        // ************ START 解决获取坐标为空的错误(解决通过高德未获取到坐标的问题) ****************

        dispatchList.stream().map(mapper -> {
            if (mapper.getProvince() == null && mapper.getWorkerCode() == null) {
                return mapper;
            } else {
                return null;
            }
        }).forEach(exDispatchModels::add);     //todo ???

        System.out.println("                                                                 ");
        System.out.println("exDispatchModels ：  " + exDispatchModels.toString());


        exDispatchModels.removeAll(Collections.singleton(null));  // 出去list中 空元素


        System.out.println("                                                                 ");
        System.out.println("dispatchList ：  " + dispatchList.toString());
        System.out.println("                                                                 ");
        System.out.println("exDispatchModels ：  " + exDispatchModels.toString());
        System.out.println("                                                                 ");


        // 测试其他        forEach 内部迭代

        System.out.println("==============  测试其他    forEach 内部迭代 ,其他方法 如下：================");
        System.out.println("                                                                 ");

        dispatchList.stream().map(mapper -> {
            if (mapper.getProvince() == null && mapper.getWorkerCode() == null) {
                return mapper;
            } else {
                return null;
            }
        }).forEach(System.out::println);     //todo ???


        System.out.println("                                                                 ");

/*        dispatchList.stream().map(mapper -> {
            if (mapper.getProvince() == null && mapper.getWorkerCode() == null) {
                return mapper;
            } else {
                return null;
            }
        }).forEach(exDispatchModels::);     //todo ???

        System.out.println("exDispatchModels ：  " + exDispatchModels.toString());
        System.out.println("                                                                 ");*/


    }


    @Test
    public void test2(){
        List<Apple> appleList = new ArrayList<>();
        Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
        Apple apple2 = new Apple(2,"芒果2",new BigDecimal("1.35"),20);
        Apple apple3 =  new Apple(3,"香蕉3",new BigDecimal("2.89"),30);
        appleList.add(apple1);
        appleList.add(apple2);
        appleList.add(apple3);

        List<Apple> appleList2 = new ArrayList<>();
        CollectionUtils.addAll(appleList2, new Object[appleList.size()]);
        Collections.copy(appleList2, appleList);

        List<Apple> appleList3 = new ArrayList<>();
        CollectionUtils.addAll(appleList3, new Object[appleList.size()]);
        Collections.copy(appleList3, appleList);


        Student s1 = new Student(1L, "肖战", 15, "浙江");
        s1.setAppleList(appleList2);
        Student s2 = new Student(2L, "王一博", 15, "湖北");
        s2.setAppleList(appleList2);
        Student s3 = new Student(3L, "杨紫", 17, "北京");
        s3.setAppleList(appleList3);
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);


        Optional<Student> op = students.stream().reduce((d1, d2) -> {
            d1.getAppleList().addAll(d2.getAppleList());
            return d1;
        });

        Student student = op.get();

        System.out.println("=========> "+op.get());

    }

    @Test
    public void test3() {
        List<Apple> appleList = new ArrayList<>();
        Apple apple1 = new Apple(1, "苹果1", new BigDecimal("3.25"), 10);
        Apple apple2 = new Apple();
        BeanUtils.copyProperties(apple1,apple2);
        System.out.println(apple2);
    }

}
