package org.example;

import java.sql.*;

public class ConnectDB {

    private static String url = "jdbc:sqlserver://DESKTOP-O8NA0U3\\SQLEXPRESS01;database=progIngen;";
    private static Connection connection;
    public static int maxId;

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

            Statement stmt = connection.createStatement();
            ResultSet executeQuery = stmt.executeQuery("SELECT [workId] FROM InWork");

            maxId = 0;
            while (executeQuery.next()) {
                int id = Integer.parseInt(executeQuery.getString("workId"));
                if (maxId < id) {
                    maxId = id;
                }
            }
            maxId++;
            executeQuery.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}
