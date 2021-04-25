package org.example;

import org.example.entities.Equipment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QueryClass {

    private static final Connection connection = ConnectDB.getConnection();

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Equipment> loadEquipFromDB () {

        List<Equipment> equipment = new ArrayList<>();
        int i;

        try {
            Statement statement = connection.createStatement();
            ResultSet executeQuery = statement.executeQuery("SELECT * FROM Equipments");

            while (executeQuery.next()) {
                i  = executeQuery.getInt("number");
                String name = executeQuery.getString("name");
                String location = executeQuery.getString("location");
                String maintenance = executeQuery.getString("maintenance");
                String nextVal = executeQuery.getString("nextValueSOT");

                equipment.add(new Equipment(i, name, location, maintenance, nextVal));


            }

            executeQuery.close();
            statement.close();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return equipment;
    }

}
