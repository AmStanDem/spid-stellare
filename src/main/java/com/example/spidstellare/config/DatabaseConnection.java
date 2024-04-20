package com.example.spidstellare.config;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
{
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/spid_stellare";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    public static Connection initializeDatabase()
    {
        try
        {
            Class.forName("org.mariadb.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            return null;
        }
    }
}
