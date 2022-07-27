package com.zzh.pifashop;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test_Sql {

    @Test
    public void linkTest(){
        try{  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("连接成功1");
        }
        catch(Exception e) {
            System.out.println("连接失败1");
        }
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "databaseName=Student;"
                        + "encrypt=false;"
                        + "user=sa;"
                        + "password=12345678;";
        Connection con;//处理与特定数据库的连接


        try {
            con = DriverManager.getConnection(connectionUrl);
            System.out.println("连接成功2");
            con.close();
        }
        catch(SQLException e) {
            System.out.println("请输入正确的表名"+e);
            System.out.println("连接失败2");
        }
    }

//    public static void main(String[] args) {
//        try{  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            System.out.println("连接成功1");
//        }
//        catch(Exception e) {
//            System.out.println("连接失败1");
//        }
//        String connectionUrl =
//                "jdbc:sqlserver://localhost:1433;"
//                        + "databaseName=Student;"
//                        + "encrypt=false;"
//                        + "user=sa;"
//                        + "password=12345678;";
//        Connection con;//处理与特定数据库的连接
//
//
//        try {
//            con = DriverManager.getConnection(connectionUrl);
//            System.out.println("连接成功2");
//            con.close();
//        }
//        catch(SQLException e) {
//            System.out.println("请输入正确的表名"+e);
//            System.out.println("连接失败2");
//        }
//    }
}
