package com.MainLogic.controller;

import com.MainLogic.dao.DownloadFile;
import com.MainLogic.dao.Order;
import com.MainLogic.dao.SenderSsl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;

@RestController
public class Controller {



    @RequestMapping(value = "/DownloadFile",method = RequestMethod.PUT)
    @ResponseBody
    public void test(HttpServletRequest servletRequest)
    {
        try
        {
            String body="";
            if ("PUT".equalsIgnoreCase(servletRequest.getMethod()))
            {
                Scanner s = null;
                try
                {
                    s = new Scanner(servletRequest.getInputStream(), "UTF-8").useDelimiter("\\A");
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                body = (s.hasNext() ? s.next() : "");
                DownloadFile.start(body,"F:\\");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    Order order= new Order();
    @RequestMapping(value = "/getObj",method = RequestMethod.GET)
    @ResponseBody
    public Order get_msg()
    {
        order.setGmail("madnessjust4Gmail.com");
        order.setGitFilePath("https://raw.githubusercontent.com/OfatenkoRodion/Graduate_work/master/Platform_for_testing_code_quality/%D0%94%D0%B8%D0%BF%D0%BB%D0%BE%D0%BC.iml");
        return order;
    }
    /*

    {"gmail":"gmail","gitFilePath":"path"}

    */
    @RequestMapping(value = "/setObj",method = RequestMethod.PUT)
    @ResponseBody
    public void set_msg(HttpServletRequest servletRequest)
    {
        String body="";
        if ("PUT".equalsIgnoreCase(servletRequest.getMethod()))
        {
            Scanner s = null;
            try
            {
                s = new Scanner(servletRequest.getInputStream(), "UTF-8").useDelimiter("\\A");
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            body = (s.hasNext() ? s.next() : "");
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                order= objectMapper.readValue(body, Order.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // RequestBody
    // {"gmail":"madnessjust4@gmail.com","gitFilePath":"https://raw.githubusercontent.com/OfatenkoRodion/Graduate_work/master/Platform_for_testing_code_quality/src/main/java/com/MainLogic/Main.java"}

    @RequestMapping(value = "/startAnalysis",method = RequestMethod.PUT)
    @ResponseBody
    public void startAnalysis(HttpServletRequest servletRequest)
    {

        String body="";
        if ("PUT".equalsIgnoreCase(servletRequest.getMethod()))
        {
            Scanner s = null;
            try
            {
                s = new Scanner(servletRequest.getInputStream(), "UTF-8").useDelimiter("\\A");
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            body = (s.hasNext() ? s.next() : "");
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Order orderOnAnalysis= objectMapper.readValue(body, Order.class);
                System.out.println(orderOnAnalysis.getGitFilePath());
                System.out.println(orderOnAnalysis.getGmail());
                SenderSsl sslSender = new SenderSsl("justmadnessyo@gmail.com", "Nice idea but no");
                sslSender.send("This is Subject", "SSL: This is text!", "madnessjustyo@gmail.com", orderOnAnalysis.getGmail());
                DownloadFile.start(orderOnAnalysis.getGitFilePath(),"F:\\");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
