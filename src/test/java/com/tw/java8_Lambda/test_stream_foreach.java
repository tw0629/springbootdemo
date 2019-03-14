package com.tw.java8_Lambda;

import com.model.TerminalAddressEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
}
