package com.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ConvertUtil {
    public static Logger logger = LoggerFactory.getLogger(ConvertUtil.class);

    public static <H,T> List<T> convertList(List<H> sourceList,Class<T> targetClass){
        logger.info("转换实体类List sourceListLength={},targetClass={}", sourceList.size(), targetClass);
        List<T> targetList = new ArrayList<>();
        for(H source:sourceList){
           targetList.add(convert(source, targetClass));
        }
        logger.info("转换实体类List结束");
        return targetList;
    }

    public static <H,T> List<T> convertListAfterHander(List<H> sourceList, Class<T> targetClass, ConvertHander hander){
        logger.info("转换实体类List sourceListLength={},targetClass={},hander={}", sourceList.size(), targetClass,hander);
        List<T> targetList = new ArrayList<>();
        for(H source:sourceList){
            targetList.add(convertAfterHander(source,targetClass,hander));
        }
        logger.info("转换实体类List结束");
        return targetList;
    }

    public static <T> T convert(Object source,Class<T> targetClass){
        logger.info("实体类转换 source={},targetClass={}", source, targetClass);
        try {
           T target = targetClass.newInstance();
           if(Objects.nonNull(source)) {
               BeanUtils.copyProperties(source, target);
           }
            logger.info("实体类转换完成 target={}", target);
            return target;
        } catch (Exception e) {
            logger.info("实体类转换异常",e);
            e.getMessage();
        }
        return null;
    }

    public static <H,T> T convertAfterHander(H source,Class<T> targetClass,ConvertHander hander){
        logger.info("实体类转换 source={},targetClass={},hander={}", source, targetClass,hander);
          T target= convert(source,targetClass);
            hander.afterHander(source,target);
        logger.info("实体类转换结束 target={}", target);
        return target;
    }
}