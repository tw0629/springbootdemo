package com.common.util.class2;

import com.common.util.AesUtils;
import com.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author David Tian
 * @desc
 * @since 2022/7/18 10:11
 */
public class ClassObjectTest {

    private static final Logger log = LoggerFactory.getLogger(AesUtils.class);


    /**
     * 根据属性名获取属性值
     * */
    private Object getFieldValueByName(String fieldName, Object object) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = object.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(object, new Object[] {});
            return value;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return null;
        }
    }

    public static Object getValueByPropertyName(Object obj, String propertyName) {
        // 1.根据属性名称就可以获取其get方法
        String getMethodName = "get"
                + propertyName.substring(0, 1).toUpperCase()
                + propertyName.substring(1);
        //2.获取方法对象
        Class c = obj.getClass();
        try {
            //get方法都是public的且无参数
            Method m= c.getMethod(getMethodName);
            //3 通过方法的反射操作方法
            Object value = m.invoke(obj);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 
     * 原文链接：https://blog.csdn.net/beiduofen2011/article/details/119904929
     * 其中主要分成两步：
     * 1、根据属性名去类里面查找是否存在这个属性，并获取
     * 2、如果存在属性，再从这个对象数据里面获取对应的值
     *
     * 在Class中里面有以下公共方法可以获取到类的属性：
     * public Field[] getDeclaredFields() throws SecurityException {...}
     * public Field getDeclaredField(String name){...}
     * public Field[] getFields() throws SecurityException {...}
     * public Field getField(String name){...}
     *
     * 其他：
     * default：即不加任何访问修饰符，通常称为“默认访问模式“。该模式下，只允许在同一个包中进行访问。
     */
    public static void main(String[] args) throws Exception{
        
        // 涵盖：属性,子属性,父属性
        Student stu = new Student();
        stu.setId(1L);
        stu.setPublicId(100L);
        
        stu.setName("tian");
        stu.setPublicName("publicTian");
        stu.setPrivateName("privateTian");
        stu.setProtectedName("protectedTian");
        
        Student.School sch = new Student.School();
        sch.setAddr("张巷");
        sch.setName("中学");
        stu.setSchool(sch);

        try {
            Field field = stu.getClass().getDeclaredField("name");
            field.setAccessible(true);
            Object obj = field.get(stu);
            System.out.println("---field--"+field+"---value--"+obj);

            Field field1 = stu.getClass().getDeclaredField("publicName");
            Object obj1 = field1.get(stu);
            System.out.println("---field1--"+field1+"---value1--"+obj1);

            Field field2 = stu.getClass().getDeclaredField("privateName");
            field2.setAccessible(true);
            Object obj2 = field2.get(stu);
            System.out.println("---field2--"+field2+"---value2--"+obj2);

            Field field3 = stu.getClass().getDeclaredField("protectedName");
            field3.setAccessible(true);
            Object obj3 = field3.get(stu);
            System.out.println("---field3--"+field3+"---value3--"+obj3);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
