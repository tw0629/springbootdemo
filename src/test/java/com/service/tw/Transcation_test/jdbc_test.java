package com.service.tw.Transcation_test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class jdbc_test {

    private static final String url = "jdbc:mysql://localhost:3306/db_user";        //数据库地址
    private static final String url2 = "jdbc:mysql://localhost:3306/db_account";        //数据库地址
    private static final String url3 = "jdbc:mysql://192.168.83.128:3306/db_account";        //数据库地址
    private static final String username = "root";        //数据库用户名
    private static final String password = "123";        //数据库密码
    private static final String driver = "com.mysql.jdbc.Driver";        //mysql驱动


    @Test
    public void test() throws Exception {
        Connection conn = null;

        Class.forName(driver);
        conn = DriverManager.getConnection(url, username, password);
        String sql = "INSERT into user(name) VALUES (?)";        //插入sql语句
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "w");
        ps.execute();

    }


    /**
     * mysql  是默认 提交事务的
     * <p>
     * 相同数据库的 不同表/同一张表, 同时进行多个ACID操作, 本地事务是支持 提交/回退的
     */
    @Test
    public void test2() throws Exception {

        Connection conn = null;

        try {

            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);

            // 将自动提交设置为 false
            //若设置为 true 则数据库将会把每一次数据更新认定为一个事务并自动提交
            conn.setAutoCommit(false);

            String sql = "INSERT into user(name) VALUES (?)";        //插入sql语句
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "哈哈哈");
            ps.execute();

            int i = 10 / 0;  //模拟异常

//            String sql2 = "INSERT into user(name) VALUES (?)";     // 模拟相同数据库的 同一张表
            String sql2 = "INSERT into user2(name) VALUES (?)";       // 模拟相同数据库的 不同表
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, "呵呵呵");
            ps2.execute();


            conn.commit();
            System.out.println("Transaction commit...");

        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
                System.out.println("Connection rollback...");
            }
        } finally {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
    }


    /**
     * mysql  是默认 提交事务的
     * <p>
     * 不同数据库的表, 同时进行多个ACID操作, 本地事务是支持 提交/回退的
     * <p>
     * 其实, 以下这样写 根本不是 模拟同时对不同数据库的表的多个操作， 多个回退的操作rollback() , 还是相当于 两个事务, 不是在同一个事务
     */
    @Test
    public void test3() throws Exception {

        Connection conn = null;
        Connection conn2 = null;

        try {

            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            // 将自动提交设置为 false
            //若设置为 true 则数据库将会把每一次数据更新认定为一个事务并自动提交
            conn.setAutoCommit(false);

            String sql = "INSERT into user(name) VALUES (?)";        //插入sql语句
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "XXXXX3");
            ps.executeUpdate();


            //int i = 10/0;  //模拟异常


            conn2 = DriverManager.getConnection(url2, username, password);
            conn2.setAutoCommit(false);

            String sql2 = "INSERT into account(money) VALUES (?)";        //插入sql语句
            PreparedStatement ps2 = conn2.prepareStatement(sql2);
            ps2.setString(1, "111111113");
            ps2.executeUpdate();


            conn.commit();
            conn2.commit();
            System.out.println("Transaction commit...");

        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
                System.out.println("Connection rollback...");
            }
            if (conn2 != null) {
                conn2.rollback();
                System.out.println("Connection rollback...");
            }
        } finally {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
            if (conn2 != null && !conn2.isClosed()) {
                conn2.close();
            }
        }
    }


    /**
     * 默认是 mysql 开启事务的
     */
    @Test
    public void test4() throws Exception {

        Connection conn = null;
        Connection conn2 = null;

        Class.forName(driver);
        conn = DriverManager.getConnection(url, username, password);
        // 将自动提交设置为 false
        //若设置为 true 则数据库将会把每一次数据更新认定为一个事务并自动提交
//        conn.setAutoCommit(false);

        String sql = "INSERT into user(name) VALUES (?)";        //插入sql语句
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "XXXXX");
        ps.executeUpdate();

        //conn.commit();


        int i = 10 / 0;  //模拟异常


        conn2 = DriverManager.getConnection(url2, username, password);
//        conn2.setAutoCommit(false);

        String sql2 = "INSERT into account(money) VALUES (?)";        //插入sql语句
        PreparedStatement ps2 = conn2.prepareStatement(sql2);
        ps2.setString(1, "111111112");
        ps2.executeUpdate();


//        int i = 10/0;  //模拟异常


//        conn.commit();
//        conn2.commit();
//        System.out.println("Transaction commit...");
    }


}
