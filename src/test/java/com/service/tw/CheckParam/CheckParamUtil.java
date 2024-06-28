package com.service.tw.CheckParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

/**
 * @author David Tian
 * @since 2019-03-16
 */
public class CheckParamUtil {

    private static final Logger logger = LoggerFactory.getLogger(CheckParamUtil.class);

    public static String checkParamExistNull(Object obj, List<String> excludeNames) throws Exception{
        // 取到obj的class, 并取到所有属性
        Field[] fs = obj.getClass().getDeclaredFields();
        // 定义一个flag, 标记是否所有属性值为空
        String flag = "";
        // 遍历所有属性
        for (Field f : fs) {
            // 设置私有属性也是可以访问的
            f.setAccessible(true);
            // 1.排除不包括的属性名, 2.属性值不为空, 3.属性值转换成String不为""
            if(!excludeNames.contains(f.getName()) && ( f.get(obj) == null || "".equals(f.get(obj).toString()) )) {
                // 有属性满足3个条件的话, 那么说明对象属性不全为空
                flag = f.getName();
                return flag;
            }
        }
        return flag;
    }

    public static Object checkParam(Object... params ){

        for (Object obj : params) {
            if (Objects.isNull(obj)) {
                return obj;
            }
        }

        return null;
    }

}
