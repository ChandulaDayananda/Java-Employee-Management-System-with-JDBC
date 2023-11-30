package cis.data.databaseConnectivity;

import java.sql.*;

public class DatabaseConnectivity {
    public  Connection dbConnection;
    public  Statement dbStatement;

    public DatabaseConnectivity() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection("jdbc:mysql:///hrsystem", "root", "chandula123");
            dbStatement = dbConnection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
