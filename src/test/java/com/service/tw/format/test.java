package com.service.tw.format;

import org.junit.Test;

import java.text.DecimalFormat;

public class test {

    /**
     * DecimalFormat 是 NumberFormat 的一个具体子类，用于格式化十进制数字。
     *   DecimalFormat 包含一个模式 和一组符号
     *
     *   符号含义：
     *
     *   0 一个数字
     *
     *   # 一个数字，不包括 0
     *
     *   . 小数的分隔符的占位符
     *
     *   , 分组分隔符的占位符
     *
     *   ; 分隔格式。
     *
     *   - 缺省负数前缀。
     *
     *   % 乘以 100 和作为百分比显示
     *
     *   ? 乘以 1000 和作为千进制货币符显示；用货币符号代替；如果双写，用
     *
     *   国际货币符号代替。如果出现在一个模式中，用货币十进制分隔符代
     *
     *   替十进制分隔符。
     *
     *   X 前缀或后缀中使用的任何其它字符，用来引用前缀或后缀中的特殊字符。
     */

    @Test
    public void test() {
        // System.out.printf()==System.out.print(String.format())
    }

    @Test
    public void test2(){
        for(int i = 0 ; i <= 100; i++) {
            DecimalFormat format = new DecimalFormat("111");
            String suffix = format.format(i);
            System.out.println("=========>" + suffix);

        }
    }

    @Test
    public void test3(){
        double pi=3.1415927;//圆周率
        //取一位整数
        System.out.println(new DecimalFormat("0").format(pi));//3
        //取一位整数和两位小数
        System.out.println(new DecimalFormat("0.00").format(pi));//3.14
        //取两位整数和三位小数，整数不足部分以0填补。
        System.out.println(new DecimalFormat("00.000").format(pi));//03.142
        //取所有整数部分
        System.out.println(new DecimalFormat("#").format(pi));//3
        //以百分比方式计数，并取两位小数
        System.out.println(new DecimalFormat("#.##%").format(pi));//314.16%


        //自己测试
        System.out.println(new DecimalFormat("00").format(pi));//314.16%
        System.out.println(new DecimalFormat("000").format(pi));//314.16%
        System.out.println(new DecimalFormat("0000").format(pi));//314.16%
        System.out.println(new DecimalFormat("p").format(pi));//314.16%
        System.out.println(new DecimalFormat("11").format(pi));//314.16%
        System.out.println(new DecimalFormat("111").format(pi));//314.16%
        System.out.println(new DecimalFormat("1111").format(pi));//314.16%



        System.out.println("                               ");
        System.out.println("                               ");

        long c=299792458;//光速
        //显示为科学计数法，并取五位小数
        System.out.println(new DecimalFormat("#.#####E0").format(c));//2.99792E8
        //显示为两位整数的科学计数法，并取四位小数
        System.out.println(new DecimalFormat("00.####E0").format(c));//29.9792E7
        //每三位以逗号进行分隔。
        System.out.println(new DecimalFormat(",###").format(c));//299,792,458
        //将格式嵌入文本
        System.out.println(new DecimalFormat("光速大小为每秒,###米").format(c)); //光速大小为每秒299,792,458米
    }


    @Test
    public void test4() {

        DecimalFormat df = new DecimalFormat();
        double data = 1234.56789;
        System.out.println("格式化之前的数字: " + data);
        String style = "0.0";//定义要显示的数字的格式
        df.applyPattern(style);// 将格式应用于格式化器
        System.out.println("采用style: " + style + "  格式化之后: " + df.format(data));
        style = "00000.000 kg";//在格式后添加诸如单位等字符
        df.applyPattern(style);
        System.out.println("采用style: " + style + "  格式化之后: " + df.format(data));
        // 模式中的"#"表示如果该位存在字符，则显示字符，如果不存在，则不显示。
        style = "##000.000 kg";
        df.applyPattern(style);
        System.out.println("采用style: " + style + "  格式化之后: " + df.format(data));
        // 模式中的"-"表示输出为负数，要放在最前面
        style = "-000.000";
        df.applyPattern(style);
        System.out.println("采用style: " + style + "  格式化之后: " + df.format(data));
        // 模式中的","在数字中添加逗号，方便读数字
        style = "-0,000.0#";
        df.applyPattern(style);
        System.out.println("采用style: " + style + "  格式化之后: " + df.format(data));
        // 模式中的"E"表示输出为指数，"E"之前的字符串是底数的格式，
        // "E"之后的是字符串是指数的格式
        style = "0.00E000";
        df.applyPattern(style);
        System.out.println("采用style: " + style + "  格式化之后: " + df.format(data));
        // 模式中的"%"表示乘以100并显示为百分数，要放在最后。
        style = "0.00%";
        df.applyPattern(style);
        System.out.println("采用style: " + style + "  格式化之后: " + df.format(data));
        // 模式中的"\u2030"表示乘以1000并显示为千分数，要放在最后。
        style = "0.00\u2030";
        //在构造函数中设置数字格式
        DecimalFormat df1 = new DecimalFormat(style);
        //df.applyPattern(style);
        System.out.println("采用style: " + style + "  格式化之后: " + df1.format(data));

    }



}
