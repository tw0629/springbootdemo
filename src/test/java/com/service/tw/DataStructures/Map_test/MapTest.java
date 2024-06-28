package com.service.tw.DataStructures.Map_test;

import com.model.CommentInfoDTO;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author David Tian
 * @desc
 * @since 2019-12-13 16:38
 */
public class MapTest {

    @Test
    public void test(){

        Map<String, Object> map = new HashMap<>();

        CommentInfoDTO commentInfoDTO = new CommentInfoDTO();
        commentInfoDTO.setId(111111L);
        commentInfoDTO.setContent("xXXXXXXXx");
        try {
            map = MapToolUtils.objectToMap(commentInfoDTO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("======1======>"+map);


        Map<String, Object> map2 = MapToolUtils.beanToMap(commentInfoDTO);
        System.out.println("======2======>"+map2);


        CommentInfoDTO commentInfoDTO2 = new CommentInfoDTO();
        commentInfoDTO2 = MapToolUtils.mapToBean(map2, commentInfoDTO2);
        System.out.println("=======3=====>"+commentInfoDTO2.toString());

        Object tian = map.get("tian");


        System.out.println("============>"+tian);


    }



}
