package com.service.tw.T_Class_Object;

import com.service.tw.A_commonObject.Order;
import org.junit.Test;

import java.util.Date;


/**
 * @author David Tian
 * @since 2019-06-19
 */
public class test {

    @Test
    public void test() {

        Order order = new Order();
        order.setNo("1111111111111111");
        convert(order);
        convert2(order);
        convert3(Order.class);
        convert4(Order.class);
        convert5(Order.class);

        Order order1 = convert6(order);
        Order order2 = convert7(order);


        System.out.println("    ");
        System.out.println("==========>"+order);
        System.out.println("==========>"+order.toString());
        System.out.println("=====order1=====>"+order1);
        System.out.println("=====order2=====>"+order2);

    }

    private static <T> void convert(T t){

        //t不能set,因为此时是Obect

        System.out.println("    ");
        System.out.println("=====1=====>"+t);
        System.out.println("=====1=====>"+t.toString());
    }

    private static void convert2(Object t){

        //t不能set,因为此时是Obect

        System.out.println("    ");
        System.out.println("=====2=====>"+t);
        System.out.println("=====2=====>"+t.toString());

        Object tt = t;

        System.out.println("    ");
        System.out.println("=====2=====>"+tt);
        System.out.println("=====2=====>"+tt.toString());
    }

    private static void convert3(Class c) {
        System.out.println("    ");
        System.out.println("=====3=====>"+c);
        System.out.println("=====3=====>"+c.getTypeName());
        System.out.println("=====3=====>"+c.getName());
        System.out.println("=====3=====>"+c.toString());
        System.out.println("=====3=====>"+c.getDeclaredFields().length);
        try {
            System.out.println("=====3=====>"+c.getDeclaredField("no"));
            System.out.println("=====3=====>"+c.getDeclaredField("No"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    private static <T> void convert4(Class<T> c) {
        System.out.println("    ");
        System.out.println("=====4=====>"+c);
        System.out.println("=====4=====>"+c.getTypeName());
        System.out.println("=====4=====>"+c.getName());
        System.out.println("=====4=====>"+c.toString());
        System.out.println("=====4=====>"+c.getDeclaredFields().length);
        try {
            System.out.println("=====4=====>"+c.getDeclaredField("no"));
            System.out.println("=====4=====>"+c.getDeclaredField("No"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static void convert5(Class<?> c) {
        System.out.println("    ");
        System.out.println("=====5=====>"+c);
        System.out.println("=====5=====>"+c.getTypeName());
        System.out.println("=====5=====>"+c.getName());
        System.out.println("=====5=====>"+c.toString());
        System.out.println("=====5=====>"+c.getDeclaredFields().length);
        try {
            System.out.println("=====5=====>"+c.getDeclaredField("no"));
            System.out.println("=====5=====>"+c.getDeclaredField("No"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    private static <T> T  convert6(T c) {

        return c;
    }

    private static Order  convert7(Order c) {
        c.setDate(new Date());
        return c;
    }

}
