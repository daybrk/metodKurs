package org.example;

import org.example.entities.Equipment;
import org.example.entities.EquipmentsInWork;
import org.example.entities.InWork;

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

    public static String insertEquip =
            "INSERT INTO [EquipmentsInWork] " +
                    "([workId], [name], [location], [maintenance], [nextValueSOT], [faultCause], [inspector])";


    public static Boolean addEquipToWork(int id, String name, String location,
                                        String maintenance, String nextValueSOT, String faultCause, String inspector) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(insertEquip +
                    " VALUES (" + id + ",'" + name + "','" + location + "','" + maintenance + "','"
                    + nextValueSOT + "','" + faultCause + "','" + inspector + "')");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: addEquipToWork");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String insertWork =
            "INSERT INTO [InWork] " +
                    "([workId], [brigade], [workStatus])";


    public static Boolean addNewInWork(int id, String brigade, String workStatus) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(insertWork +
                    " VALUES (" + id + ",'" + brigade + "','" + workStatus + "')");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: addNewInWork");
            e.printStackTrace();
            return false;
        }
        return true;
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

    public static List<EquipmentsInWork> loadEquipInWork () {

        List<EquipmentsInWork> equipmentInWork = new ArrayList<>();
        int i;

        try {
            Statement statement = connection.createStatement();
            ResultSet executeQuery = statement.executeQuery("SELECT * FROM EquipmentsInWork");

            while (executeQuery.next()) {
                i  = executeQuery.getInt("workId");
                String name = executeQuery.getString("name");
                String location = executeQuery.getString("location");
                String maintenance = executeQuery.getString("maintenance");
                String nextVal = executeQuery.getString("nextValueSOT");
                String fault = executeQuery.getString("faultCause");
                String inspector = executeQuery.getString("inspector");

                equipmentInWork.add(new EquipmentsInWork(i, name, location, maintenance, nextVal, fault, inspector));

            }

            executeQuery.close();
            statement.close();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return equipmentInWork;
    }

    public static List<InWork> loadInWork () {

        List<InWork> inWork = new ArrayList<>();
        int i;

        try {
            Statement statement = connection.createStatement();
            ResultSet executeQuery = statement.executeQuery("SELECT * FROM inWork");

            while (executeQuery.next()) {
                i  = executeQuery.getInt("workId");
                String brigade = executeQuery.getString("brigade");
                String workStatus = executeQuery.getString("workStatus");

                inWork.add(new InWork(i, brigade, workStatus));

            }

            executeQuery.close();
            statement.close();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return inWork;
    }
}
