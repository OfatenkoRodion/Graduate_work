package com.MainLogic.dao;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            LanguageDAO.createTable();
            MetricsDAO.createTable();
            Metrics mm=new Metrics();
            mm.setDescription("des");
            mm.setName("mm1");
            mm.setId_language(1);
            MetricsDAO.addMetrics(mm);

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
