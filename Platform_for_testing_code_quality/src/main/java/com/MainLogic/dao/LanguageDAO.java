package com.MainLogic.dao;

import java.sql.*;
import java.util.HashSet;

import static com.MainLogic.dao.ConnectionToDB.getConnection;

public class LanguageDAO
{

    public static String createTable() throws ClassNotFoundException, SQLException
    {
        Statement statement =  getConnection().createStatement();
        statement.executeUpdate("CREATE TABLE LANGUAGE(id INTEGER AUTO_INCREMENT PRIMARY KEY ,name TEXT NOT NULL);");

        addLanguage("C#");
        addLanguage("Java");

        return "Created";
    }
    public static String deleteTable() throws ClassNotFoundException, SQLException
    {
        Statement statement = getConnection().createStatement();
        statement.executeUpdate("Drop TABLE LANGUAGE");

        return "Deleted";
    }
    private static String addLanguage(String name) throws ClassNotFoundException, SQLException
    {
        Statement statement =  getConnection().createStatement();

        String sql="INSERT INTO LANGUAGE SET name='"+name+"'";
        statement.executeUpdate(sql);

        return "Added";
    }
    public static HashSet<String> getLanguages() throws ClassNotFoundException, SQLException
    {
        HashSet<String> lang=new HashSet<>();
        Statement statement = getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM LANGUAGE");

        while (resultSet.next())
        {
            lang.add(resultSet.getString(2));
        }
        return lang;
    }

}