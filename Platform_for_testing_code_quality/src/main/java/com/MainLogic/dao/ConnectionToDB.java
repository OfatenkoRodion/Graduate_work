package com.MainLogic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDB
{
    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        String userName="root";
        String password="1234";
        String connectionURL = "jdbc:mysql://localhost:3306/static_metrics_software";
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(connectionURL,userName,password);
    }
}
