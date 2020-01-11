package com.common.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author David Tian
 * @since 2019-02-20
 */
public class StringUtil {

    /**
     * 将float转换为百分数,保留三位有效数字
     * @param f
     * @return
     */
    public static String floatConvertPercentage(Float f,int n){

        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMaximumFractionDigits(n);
        String s = numberFormat.format(f);
        return s;
    }


    public static String floatRetain(float price){
        DecimalFormat decimalFormat =new DecimalFormat(".0");
        String p = decimalFormat.format(price);
        return p;
    }

    public static List<Integer> stringConvertInteger(List<String> stringList){
        List<Integer> integerList = new ArrayList<>();

        for(String s : stringList){
            integerList.add(Integer.valueOf(s));
        }
        return integerList;

    }


    public static void main(){

        float f = 3.1415926f;

        System.out.println("=======XXXXXX======>"+floatRetain(f));
    }

}
