package com.service.tw.StringUtils;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author David Tian
 * @since 2019-03-20
 */
public class splitTest {

    @Test
    public void splitTest1() {

        String commenttagids = "1";
        String[] split = commenttagids.split(",");
        List<String> list = Arrays.asList(split);

        System.out.println("==========XXXXX==========>"+list.toString());

    }
}
