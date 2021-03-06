package com.MainLogic.dao;

import java.sql.*;
import java.util.HashSet;

import static com.MainLogic.dao.ConnectionToDB.getAzureConnection;

public class LanguageDAO
{

    public static String createTable() throws ClassNotFoundException, SQLException
    {
        Statement statement =  getAzureConnection().createStatement();
        //statement.executeUpdate("CREATE TABLE LANGUAGE(id INTEGER AUTO INCREMENT PRIMARY KEY ,name TEXT NOT NULL);");
        statement.executeUpdate("CREATE TABLE LANGUAGE(id INTEGER PRIMARY KEY IDENTITY (1,1),name TEXT NOT NULL);");

        addLanguage("Java");
        addLanguage("C#");

        return "Created";
    }
    public static String deleteTable() throws ClassNotFoundException, SQLException
    {
        Statement statement = getAzureConnection().createStatement();
        statement.executeUpdate("Drop TABLE LANGUAGE");

        return "Deleted";
    }
    private static String addLanguage(String new_name) throws ClassNotFoundException, SQLException
    {
        Statement statement =  getAzureConnection().createStatement();

        //String sql="INSERT INTO LANGUAGE SET name='"+name+"'";
        String sql="INSERT INTO LANGUAGE  VALUES ('"+new_name+"')";
        statement.executeUpdate(sql);

        return "Added";
    }
    public static HashSet<String> getLanguages() throws ClassNotFoundException, SQLException
    {
        HashSet<String> lang=new HashSet<>();
        Statement statement = getAzureConnection().createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM LANGUAGE");

        while (resultSet.next())
        {
            lang.add(resultSet.getString(2));
        }
        return lang;
    }

}