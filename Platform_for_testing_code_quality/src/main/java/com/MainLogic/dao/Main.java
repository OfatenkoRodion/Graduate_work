package com.MainLogic.dao;

import java.sql.SQLException;
import java.util.HashSet;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
           /*HashSet<Metrics> mms= MetricsDAO.getMetricsByLanguage("Java");

           for (Metrics mtr: mms)
               System.out.println(mtr.getName()+" "+mtr.getDescription()+" "+mtr.getId_language());*/

           LanguageDAO.createTable();
           MetricsDAO.createTable();

            Metrics mm=new Metrics();
            mm.setDescription("des0");
            mm.setName("mm0");
            mm.setId_language(1);
            MetricsDAO.addMetrics(mm);

            mm.setDescription("des2");
            mm.setName("mm2");
            mm.setId_language(1);
            MetricsDAO.addMetrics(mm);

            mm.setDescription("des3");
            mm.setName("mm2");
            mm.setId_language(2);
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
