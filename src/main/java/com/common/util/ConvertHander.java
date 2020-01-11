package com.common.util;


public interface ConvertHander {
    /**
     * 类转化后需要做的额外操作
     * @param source
     * @param target
     */
    void afterHander(Object source, Object target);
}
