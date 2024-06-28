package com.service.tw.mybatis;


import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * sql in 语句最大上限1000
 */
public class test {

    private static String getOracleSQLIn(List<?> ids, int count, String field) {
        count = Math.min(count, 1000);
        int len = ids.size();
        int size = len % count;
        if (size == 0) {
            size = len / count;
        } else {
            size = (len / count) + 1;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            int fromIndex = i * count;
            int toIndex = Math.min(fromIndex + count, len);
            String productId = StringUtils.defaultIfEmpty(StringUtils.join(ids.subList(fromIndex, toIndex), "','"), "");
            if (i != 0) {
                builder.append(" or ");
            }
            builder.append(field).append(" in ('").append(productId).append("')");
        }
        return StringUtils.defaultIfEmpty(builder.toString(), field + " in ('')");
    }
}
