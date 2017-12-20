package com.MainLogic.controller;

import com.MainLogic.MyConvertor;
import com.MainLogic.Service.Analyses;
import com.MainLogic.dao.LanguageDAO;
import com.MainLogic.dao.Metrics;
import com.MainLogic.dao.MetricsDAO;
import com.MainLogic.date.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;

@RestController
public class Controller
{

    @RequestMapping(value = "/startAnalysis",method = RequestMethod.PUT)
    @ResponseBody
    public void startAnalysis(HttpServletRequest servletRequest)
    {
        try
        {
            String body= MyConvertor.HttpServletRequestToString(servletRequest);
            Order orderOnAnalysis = MyConvertor.StringToOrder(body);
            Analyses.start(orderOnAnalysis);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/getListLanguage",method = RequestMethod.GET)
    @ResponseBody
    public HashSet<String> getListLanguage()
    {
        try
        {
            return LanguageDAO.getLanguages();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/getListMetrics",method = RequestMethod.PUT)
    @ResponseBody
    public HashSet<Metrics> getListMetrics(HttpServletRequest servletRequest)
    {
        try
        {
            String language= MyConvertor.HttpServletRequestToString(servletRequest);
            return MetricsDAO.getMetricsByLanguage(language);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
