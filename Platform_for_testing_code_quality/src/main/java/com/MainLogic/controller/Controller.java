package com.MainLogic.controller;

import com.MainLogic.MyConvertor;
import com.MainLogic.Service.Analyses;
import com.MainLogic.date.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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

    @RequestMapping(value = "/getListLanguage",method = RequestMethod.PUT)
    @ResponseBody
    public void getListLanguage(HttpServletRequest servletRequest)
    {
        try
        {
            String body= MyConvertor.HttpServletRequestToString(servletRequest);
            Order orderOnAnalysis = MyConvertor.StringToOrder(body);
            Analyses.start(orderOnAnalysis);
        }
        catch (IOException e)
        {
            e.printStackTrace();        }
    }
}
