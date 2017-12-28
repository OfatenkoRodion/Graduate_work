package com.MainLogic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDB
{
    public static Connection getAzureConnection() throws ClassNotFoundException, SQLException
    {
        String userName="Rodion";
        String password="";
        String connectionURL = "jdbc:sqlserver://ofatenko.database.windows.net:1433;database=TestBase2;user=Rodion@ofatenko;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(connectionURL,userName,password);
    }
    public static Connection getLocalConnection() throws ClassNotFoundException, SQLException
    {
        String userName="Root";
        String password="1234";
        String connectionURL = "jdbc:mysql://localhost:3306/static_metrics_software";
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(connectionURL,userName,password);
    }

}
