package com.company.database;

import com.company.database.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Postgres implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionURL = "jdbc:postgresql://localhost:5432/SchoolManagementSystem";
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(connectionURL, "postgres", "1234567898");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
}
