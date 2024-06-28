package com.service.tw.BigDecimal_test;

import com.common.util.BigDecimalUtil;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 总结
 * (1)商业计算使用BigDecimal。
 * <p>
 * (2)尽量使用参数类型为String的构造函数。
 * <p>
 * (3) BigDecimal都是不可变的（immutable）的，在进行每一步运算时，都会产生一个新的对象，所以在做加减乘除运算时千万要保存操作后的值。
 * <p>
 * (4)我们往往容易忽略JDK底层的一些实现细节，导致出现错误，需要多加注意。
 */

public class BigDecimal_test {


    /**
     * 有些小数会有 精度缺失 问题
     * <p>
     * 涉及 小数 一定要用 BigDecimal ，不要在用 float double
     */
    @Test
    public void test() {
        BigDecimal a = new BigDecimal(1);       //精度缺失
        BigDecimal a2 = new BigDecimal(1.2);    //精度缺失
        BigDecimal a3 = new BigDecimal(1.22);   //精度缺失
        BigDecimal a4 = new BigDecimal("1.22");
        BigDecimal a5 = new BigDecimal(1.25);


        System.out.println("====================1====================");
        System.out.println(a);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);
        System.out.println("===================1=====================");
        System.out.println("                                         ");

        Double b = new Double(1.2);
        double b2 = 1.273;

        System.out.println("===================2=====================");
        System.out.println(b);
        System.out.println(b2);
        System.out.println("===================2=====================");
        System.out.println("                                         ");


        double m = 1.273;
        double m2 = 1.273333;

        BigDecimal n = new BigDecimal("1.273");
        BigDecimal n2 = new BigDecimal("1.273333");
        BigDecimal multiply = n.multiply(n2);

        System.out.println(m * m2);
        System.out.println(multiply);

    }


    @Test
    public void test2() {


        //双精度浮点型变量double可以处理16位有效数。
        //小数点后16位
        System.out.println(1.01 + 2.02);    //3.0300000000000002   而不是3.03


        //这是因为不论是float 还是double都是浮点数，而计算机是二进制的，浮点数会失去一定的精确度。
        //有没有不失精度的办法呢？这里就要用到BigDecimal了。

        //在实际应用中，需要对更大或者更小的数进行运算和处理。
        // float和double只能用来做科学计算或者是工程计算，在商业计算中要用java.math.BigDecimal。


        //BigDecimal所创建的是对象，我们不能使用传统的+、-、*、/等算术运算符直接对其对象进行数学运算，
        // 而必须调用其相对应的方法。方法中的参数也必须是BigDecimal的对象。
        // 构造器是类的特殊方法，专门用来创建对象，特别是带有参数的对象。


        //      重要！！！！！
        System.out.println("                                                 ");
        //创建BigDecimal对象主要有两种。
        BigDecimal b1 = new BigDecimal("1.34");//1.34
        BigDecimal b2 = BigDecimal.valueOf(1.34);//1.34
        System.out.println("b1 =============> " + b1);
        System.out.println("b2 =============> " + b2);


        System.out.println("                                                 ");
        //42位
        BigDecimal b3 = new BigDecimal(1.34);//1.3400000000 0000007993 6057773011 2709105014 8010253906 25
        BigDecimal b4 = new BigDecimal("1.34");//1.34
        System.out.println("b3 =============> " + b3);
        System.out.println("b4 =============> " + b4);


        //private static final BigDecimal zeroThroughTen[] = {
        //        new BigDecimal(BigInteger.ZERO,       0,  0, 1),
        //        new BigDecimal(BigInteger.ONE,        1,  0, 1),
        //        new BigDecimal(BigInteger.valueOf(2), 2,  0, 1),
        //        new BigDecimal(BigInteger.valueOf(3), 3,  0, 1),
        //        new BigDecimal(BigInteger.valueOf(4), 4,  0, 1),
        //        new BigDecimal(BigInteger.valueOf(5), 5,  0, 1),
        //        new BigDecimal(BigInteger.valueOf(6), 6,  0, 1),
        //        new BigDecimal(BigInteger.valueOf(7), 7,  0, 1),
        //        new BigDecimal(BigInteger.valueOf(8), 8,  0, 1),
        //        new BigDecimal(BigInteger.valueOf(9), 9,  0, 1),
        //        new BigDecimal(BigInteger.TEN,        10, 0, 2),
        //    };
        System.out.println("                                                 ");
        BigDecimal b5 = BigDecimal.ZERO;
        BigDecimal b6 = BigDecimal.ONE;
        BigDecimal b7 = BigDecimal.TEN;
        System.out.println("b5 =============> " + b5);
        System.out.println("b6 =============> " + b6);
        System.out.println("b7 =============> " + b7);


        System.out.println("                                                 ");
        int a0 = BigDecimal.ROUND_UP;
        int a1 = BigDecimal.ROUND_DOWN;
        int a2 = BigDecimal.ROUND_CEILING;
        int a3 = BigDecimal.ROUND_FLOOR;
        int a4 = BigDecimal.ROUND_HALF_UP;
        int a5 = BigDecimal.ROUND_HALF_DOWN;
        int a6 = BigDecimal.ROUND_HALF_EVEN;
        int a7 = BigDecimal.ROUND_UNNECESSARY;
        System.out.println("a0 =============> " + a0);
        System.out.println("a1 =============> " + a1);
        System.out.println("a2 =============> " + a2);
        System.out.println("a3 =============> " + a3);
        System.out.println("a4 =============> " + a4);
        System.out.println("a5 =============> " + a5);
        System.out.println("a6 =============> " + a6);
        System.out.println("a7 =============> " + a7);


    }


    @Test
    public void test3() {

        //      重要！！！！！
        System.out.println("                                                 ");
        //创建BigDecimal对象主要有两种。
        BigDecimal b1 = new BigDecimal("1.34");//1.34
        BigDecimal b2 = BigDecimal.valueOf(1.34);//1.34
        System.out.println("b1 =============> " + b1);
        System.out.println("b2 =============> " + b2);


        System.out.println("                                                 ");
        //BigDecimal.ZERO、new BigDecimal("0")、BigDecimal.valueOf(0)
        System.out.println(BigDecimal.ZERO.equals(new BigDecimal("0")));              //true
        System.out.println(BigDecimal.ZERO.equals(BigDecimal.valueOf(0)));                //true
        System.out.println(new BigDecimal("0").equals(BigDecimal.valueOf(0)));       //true

        System.out.println(BigDecimal.ZERO == new BigDecimal("0"));                    //false
        System.out.println(BigDecimal.ZERO == BigDecimal.valueOf(0));                      //true
        System.out.println(BigDecimal.valueOf(0) == new BigDecimal("0"));             //false

    }


    @Test
    public void test4() {

        //      重要！！！！！
        System.out.println("                                                 ");
        //创建BigDecimal对象主要有两种。
        BigDecimal b1 = new BigDecimal("1.34");//1.34
        BigDecimal b2 = BigDecimal.valueOf(1.34);//1.34
        System.out.println("b1 =============> " + b1);
        System.out.println("b2 =============> " + b2);


        //BigDecimal的加减乘除运算
        //  public BigDecimal add(BigDecimal value);//加法
        //  public BigDecimal subtract(BigDecimal value);//减法
        //  public BigDecimal multiply(BigDecimal value);//乘法
        //  public BigDecimal divide(BigDecimal value);//除法


        //  BigDecimal的add方法 === 一个坑
        //BigDecimal的运算都没有对原值进行操作，而是返回一个新的BigDecimal对象，
        // 这点可能有些小伙伴会搞错要注意一下。

        System.out.println("                                                 ");
        BigDecimal b3 = new BigDecimal("1.34");
        System.out.println("b3: " + b3);
        BigDecimal b4 = new BigDecimal("2.34");

        b3.add(b4);                             // 一个坑
        System.out.println("b3: " + b3);        //b3并没有变

        BigDecimal a5 = b3.add(b4);             // 正确写法 ,有赋值 ********************
        System.out.println("b5: " + a5);


        System.out.println("                                                 ");
        BigDecimal one = BigDecimal.valueOf(1);
        BigDecimal two = BigDecimal.valueOf(2);
        BigDecimal three = one.add(two);
        int i1 = one.compareTo(two);//-1
        int i2 = two.compareTo(two);//0
        int i3 = three.compareTo(two);//1
        System.out.println("i1 =============> " + i1);
        System.out.println("i2 =============> " + i2);
        System.out.println("i3 =============> " + i3);


    }


    //BigDecimal的加减乘除运算
    @Test
    public void test6() {

        //BigDecimal的加减乘除运算
        //  public BigDecimal add(BigDecimal value);//加法
        //  public BigDecimal subtract(BigDecimal value);//减法
        //  public BigDecimal multiply(BigDecimal value);//乘法
        //  public BigDecimal divide(BigDecimal value);//除法


        BigDecimal bignum1 = new BigDecimal("10");
        BigDecimal bignum2 = new BigDecimal("5");
        BigDecimal bignum3 = null;

        //加法
        bignum3 = bignum1.add(bignum2);
        System.out.println("和 是：" + bignum3);

        //减法
        bignum3 = bignum1.subtract(bignum2);
        System.out.println("差  是：" + bignum3);

        //乘法
        bignum3 = bignum1.multiply(bignum2);
        System.out.println("积  是：" + bignum3);

        //除法
        bignum3 = bignum1.divide(bignum2);
        System.out.println("商  是：" + bignum3);

    }


    //BigDecimalUtil 工具类的加减乘除运算
    @Test
    public void test7() {

        double a = 10;
        double b = 5;

        double add = BigDecimalUtil.add(a, b);
        double sub = BigDecimalUtil.sub(a, b);
        double mul = BigDecimalUtil.mul(a, b);
        double div = BigDecimalUtil.div(a, b);

        System.out.println("                              ");
        System.out.println("add ==============> " + add);
        System.out.println("sub ==============> " + sub);
        System.out.println("mul ==============> " + mul);
        System.out.println("div ==============> " + div);

    }


    @Test
    public void test8() {
        Double a = 1d;
        double a2 = 1;
        System.out.println(a);
        System.out.println(a2);

        Float a3 = 1f;
        float a4 = 1;
        System.out.println(a3);
        System.out.println(a4);

        Long a5 = 1l;
        long a6 = 1;
        System.out.println(a5);
        System.out.println(a6);
    }


    // BigDecimal 转换为 基本类型
    @Test
    public void test9() {

        //      重要！！！！！
        System.out.println("                                                 ");
        //创建BigDecimal对象主要有两种。
        BigDecimal b1 = new BigDecimal("1.34");//1.34
        BigDecimal b2 = BigDecimal.valueOf(1.34);//1.34
        System.out.println("b1 =============> " + b1);
        System.out.println("b2 =============> " + b2);


        // BigDecimal 转换为 基本类型
        System.out.println("                                                 ");
        double v = b1.doubleValue();
        System.out.println("v =============> " + v);
        BigDecimal b3 = new BigDecimal(1.34);   //1.3400000000 0000007993 6057773011 2709105014 8010253906 25
        double v1 = b3.doubleValue();
        float v2 = b3.floatValue();
        int i = b3.intValue();
        long l = b3.longValue();
        String s = b3.toString();
        int precision = b3.precision();
        System.out.println("b3 =============> " + b3);
        System.out.println("v1 =============> " + v1);
        System.out.println("v2 =============> " + v2);
        System.out.println("i =============> " + i);
        System.out.println("l =============> " + l);
        System.out.println("s =============> " + s);
        System.out.println("precision =============> " + precision);


        System.out.println("                                                 ");
        BigDecimal max = b3.max(BigDecimal.valueOf(5.34));
        System.out.println("max =============> " + max);

    }

}
