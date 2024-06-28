package com.tw.beanutils;

import com.alibaba.fastjson.JSONObject;
import com.model.*;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class test {

    /**
     * 测试BeanUtils.copyProperties
     * 对象换转:多了属性 转换到 少了属性
     */
    @Test
    public void test() {
        TerminalAddressEntity terminalAddressEntity = new TerminalAddressEntity();
        // terminalAddressEntity.setLabelname("aaa");
        terminalAddressEntity.setProvince("山西");
        terminalAddressEntity.setTerminalAddressId(123L);
        terminalAddressEntity.setWorkerCode("666");
        CarMessage carMessage = new CarMessage();
        carMessage.setVin("123456");
        terminalAddressEntity.setCarMessage(carMessage);

        TerminalAddressModel terminalAddressModel = new TerminalAddressModel();

        BeanUtils.copyProperties(terminalAddressEntity, terminalAddressModel);

        System.out.println(JSONObject.toJSONString(null));
        System.out.println(JSONObject.toJSONString(terminalAddressModel));
        System.out.println(terminalAddressModel.toString());
    }

    /**
     * 测试BeanUtils.copyProperties
     * 对象换转:少了属性 转换到 多了属性
     */
    @Test
    public void test2() {
        TerminalAddressEntity2 terminalAddressEntity2 = new TerminalAddressEntity2();
        terminalAddressEntity2.setProvince("山西");
        terminalAddressEntity2.setTerminalAddressId(123L);
        terminalAddressEntity2.setWorkerCode("666");

        TerminalAddressModel2 terminalAddressModel2 = new TerminalAddressModel2();


        BeanUtils.copyProperties(terminalAddressEntity2, terminalAddressModel2);

        System.out.println(terminalAddressModel2.toString());
    }

    @Test
    public void test3() {

        String trade_order_id = "10020090519476573795820421120";
        int mo = Math.abs(trade_order_id.hashCode()) % 128;
        System.out.println("=======>" + mo);
        System.out.println();

        List<String> storeIdList = new ArrayList<>();
        storeIdList.add("123");
        storeIdList.add("456");
        storeIdList.add("qwe");
        String s = storeIdConditions(storeIdList);
        System.out.println("=======>" + s);


    }

    private String storeIdConditions(List<String> storeIdList){
        StringBuilder storeIdStr =  new StringBuilder();
        storeIdList.forEach(storeId -> {
            storeIdStr.append("'").append(storeId).append("'").append(",");
        });
        storeIdStr.deleteCharAt(storeIdStr.length()-1);
        return storeIdStr.toString();
    }

}
