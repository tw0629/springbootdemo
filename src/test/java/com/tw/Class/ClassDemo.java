package com.tw.Class;

import org.junit.Test;

/**
 * @author David Tian
 * @desc
 * @since 2020-12-15 21:34
 */
public class ClassDemo {

    @Test
    public void test(){

        FindPoliciesQuery findPoliciesQuery = new FindPoliciesQuery();
        Class<? extends FindPoliciesQuery> aClass = findPoliciesQuery.getClass();
        System.out.println("========>"+aClass);

        Query query = new Query(){};
        Class<? extends Query> aClass1 = query.getClass();
        System.out.println("========>"+aClass1);
        System.out.println("========>");

    }
}

