package com.tw.beanutils;

import com.model.TerminalAddressEntity;
import com.model.TerminalAddressEntity2;
import com.model.TerminalAddressModel;
import com.model.TerminalAddressModel2;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

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
        TerminalAddressModel terminalAddressModel = new TerminalAddressModel();

        BeanUtils.copyProperties(terminalAddressEntity, terminalAddressModel);

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
        String s1 = "天地";
        String s2 = "哈哈";
        String s3 = "天地";

        System.out.println("=======>" + s1.equals(s2));
        System.out.println("=======>" + s2.equals(s1));
        System.out.println("=======>" + s3.equals(s1));
        System.out.println("=======>" + s1.equals(s3));
    }

}
