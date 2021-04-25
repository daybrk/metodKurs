package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    private static String url = "jdbc:sqlserver://DESKTOP-O8NA0U3\\SQLEXPRESS01;database=progIngen;";
    private static Connection connection;

    public static String getUrl() {
        return url;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void ex() {


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, "User", "User");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

}
