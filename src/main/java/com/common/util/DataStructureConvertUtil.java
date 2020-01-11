package com.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * @author David Tian
 * @desc
 * @since 2019-08-18 11:37
 */
public class DataStructureConvertUtil {

    /**
     * map转换为object
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null) {
            return null;
        }

        Object obj = beanClass.newInstance();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }

            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }

        return obj;
    }

    /**
     * object转换为map
     * @param obj
     * @return
     * @throws Exception
     */
    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }

        return map;
    }

    /**
     * map转换为object
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static Object mapToObject2(Map<String, String> map, Class<?> beanClass) throws Exception {
        if (map == null) {
            return null;
        }
        Object obj = beanClass.newInstance();
        //org.apache.commons.beanutils.BeanUtils.populate(obj, map);
        BeanUtils.populate(obj, map);
        return obj;
    }

   /**
    * object转换为map
    * @param obj
    * @return
   */
   public static Map<?, ?> objectToMap2(Object obj) throws Exception{
    if (obj == null) {
        return null;
    }
    //return new org.apache.commons.beanutils.BeanMap(obj);
    return new BeanMap(obj);
    }

    /**
     * map转换为object
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static Object mapToObject3(Map<String, String> map, Class<?> beanClass) throws Exception{

        // jackson's objectmapper
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(map, beanClass);
    }

}
