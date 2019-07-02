package com.example.common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author lingjun.jlj
 * @create 2017-09-07
 * @description: JDBC 数据库连接
 **/
public class jdbcTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://192.168.60.99:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Hongkong&useSSL=false";
            String user = "root";
            String password = "123456";
            //建立和数据库的连接
            Connection con = DriverManager.getConnection(url, user, password);
            //sql
            String sql = "select * from test";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                String name = result.getString("name");
                System.out.println(name);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
