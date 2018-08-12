package com.example.basejava.basics.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author lingjun.jlj
 * @create 2017-09-07
 **/
public class jdbcTest {
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://182.254.243.200:3306/springboot";
            String user ="root";
            String password = "root123456";
            //建立和数据库的连接
            Connection con = DriverManager.getConnection(url,user,password);
            //sql
            String sql = "select * from sb_usr";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                int id = result.getInt("id");
                System.out.println(id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
