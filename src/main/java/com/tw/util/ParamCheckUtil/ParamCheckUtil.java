package com.tw.util.ParamCheckUtil;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description: 参数校验
 * @Author: David Tian
 * @Date 2019/2/23 2:34 PM
 */
public class ParamCheckUtil {
    /*校验Object*/
    public static void checkParamsNotNull(String errMsg, Object... params) {
        if (params != null && params.length > 0) {
            for (Object element : params) {
                if (element == null) {
                    //throw Exceptions.fail("ERROR", errMsg);
                }
            }
        }
    }

    /*校验String*/
    public static void checkStringNotNull(String errMsg, String... params) {
        if (params != null && params.length > 0) {
            for (String element : params) {
                if (StringUtils.isEmpty(element)) {
                    //throw Exceptions.fail("ERROR", errMsg);
                }
            }
        }
    }

    /**
     * @Description: 校验参数，全为空则异常
     * @Author: WindPursuer
     * @Date 2019-03-12 15:45
     */
    public static void checkStringAllNotNull(String errMsg, String... params) {
        if (params != null && params.length > 0) {
            for (String element : params) {
                if (StringUtils.isNotEmpty(element)) {
                    return;
                }
            }
            //throw Exceptions.fail("ERROR", errMsg);
        }
    }
}
