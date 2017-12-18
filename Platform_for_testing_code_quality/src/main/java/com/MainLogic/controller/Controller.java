package com.MainLogic.controller;

import com.MainLogic.MyConvertor;
import com.MainLogic.Service.Analyses;
import com.MainLogic.Service.SenderImpl;
import com.MainLogic.dao.DownloadFile;
import com.MainLogic.dao.Order;
import com.MainLogic.Service.SenderSsl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;


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

}
