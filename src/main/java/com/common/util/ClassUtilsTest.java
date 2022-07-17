package com.common.util;

import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Tian
 * @desc 测试ClassUtils
 * @since 2022/6/8 01:27
 */
public class ClassUtilsTest {

    public static void main(String[] args) {

        System.out.println(ClassUtils.isPrimitiveWrapper(Integer.class));
        System.out.println(ClassUtils.isPrimitiveWrapper(Character.class));
        System.out.println(ClassUtils.isPrimitiveWrapper(Void.class));
        System.out.println(ClassUtils.isPrimitiveWrapper(String.class));

        // byte，short，int，long，float，double，char，boolean
        System.out.println(ClassUtils.isPrimitiveWrapper(int.class));
        System.out.println(ClassUtils.isPrimitiveWrapper(long.class));
        System.out.println(ClassUtils.isPrimitiveWrapper(byte.class));
        System.out.println(ClassUtils.isPrimitiveWrapper(Object.class));


        // toreIdList: ["11653640772448", "210086", "210089", "210088"]
        List<String> list = new ArrayList<>();
        list.add("11653640772448");
        list.add("110086");
        list.add("110089");
        list.add("110088");

        StringBuilder filterSb = new StringBuilder();

        if(!CollectionUtils.isEmpty(list)){
            List<String> onlineStoreIds = new ArrayList<>();
            List<String> offlineStoreIds = new ArrayList<>();
            // 此时传入的为OnOffStoreId字段
            list.forEach(onOffStoreId -> {
                if(onOffStoreId.startsWith("1")){
                    // 去掉首位标识 即onOffStoreId = onlineOrOff+storeId
                    onlineStoreIds.add(onOffStoreId.substring(1,onOffStoreId.length()));
                }else if(onOffStoreId.startsWith("2")){
                    offlineStoreIds.add(onOffStoreId.substring(1,onOffStoreId.length()));
                }
            });

            // 线上店铺
            if(!CollectionUtils.isEmpty(onlineStoreIds) && CollectionUtils.isEmpty(offlineStoreIds)){
                String storeIdConditions = storeIdConditions(onlineStoreIds);
                filterSb.append(" and store.store_id in (" + storeIdConditions + ")");
            }
            // 线下店铺
            if(!CollectionUtils.isEmpty(offlineStoreIds) && CollectionUtils.isEmpty(onlineStoreIds)){
                String storeIdConditions = storeIdConditions(offlineStoreIds);
                filterSb.append(" and offline_store.reference_store_id in (" + storeIdConditions + ")");
            }
            // 线上/线下店铺
            if(!CollectionUtils.isEmpty(offlineStoreIds) && !CollectionUtils.isEmpty(onlineStoreIds)){
                String offConditions = storeIdConditions(offlineStoreIds);
                String onConditions = storeIdConditions(onlineStoreIds);
                filterSb.append(" and ( offline_store.reference_store_id in (" + offConditions + ") or store.store_id in (" + onConditions + ") )");
            }
        }

        System.out.println(filterSb);


    }

    private static String storeIdConditions(List<String> storeIdList){
        StringBuilder storeIdStr =  new StringBuilder();
        storeIdList.forEach(storeId -> {
            storeIdStr.append("'").append(storeId).append("'").append(",");
        });
        storeIdStr.deleteCharAt(storeIdStr.length()-1);
        return storeIdStr.toString();
    }
    
    
}
