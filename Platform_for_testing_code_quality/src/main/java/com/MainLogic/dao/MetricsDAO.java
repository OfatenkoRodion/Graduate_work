package com.MainLogic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import static com.MainLogic.dao.ConnectionToDB.getConnection;

public class MetricsDAO
{
    public static String createTable() throws ClassNotFoundException, SQLException
    {
        Statement statement =  getConnection().createStatement();
        statement.executeUpdate("CREATE TABLE METRICS(id INTEGER AUTO_INCREMENT PRIMARY KEY ,id_language INTEGER, name TEXT NOT NULL,description TEXT NOT NULL, FOREIGN KEY(id_language) REFERENCES LANGUAGE(id) );");

        return "Created";
    }
    public static String deleteTable() throws ClassNotFoundException, SQLException
    {
        Statement statement = getConnection().createStatement();
        statement.executeUpdate("Drop TABLE METRICS");

        return "Deleted";
    }
    public static String addMetrics(Metrics metrics) throws ClassNotFoundException, SQLException
    {
        Statement statement =  getConnection().createStatement();

        String sql="INSERT INTO METRICS SET id_language='"+metrics.getId_language()+"',name='"+metrics.getName()+"',description='"+metrics.getDescription()+"'";
        statement.executeUpdate(sql);

        return "Added";
    }
    public static HashSet<Metrics> getMetrics() throws ClassNotFoundException, SQLException
    {
        HashSet<Metrics> metrics=new HashSet<>();
        Statement statement = getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM METRICS");

        while (resultSet.next())
        {
            int id_lang=resultSet.getInt(2);
            String name=resultSet.getString(3);
            String description=resultSet.getString(4);
            Metrics mts=new Metrics();
            mts.setId_language(id_lang);
            mts.setName(name);
            mts.setDescription(description);
            metrics.add(mts);
        }
        return  metrics;
    }
}
