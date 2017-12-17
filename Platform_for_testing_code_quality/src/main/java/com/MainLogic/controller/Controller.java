package com.MainLogic.controller;

import com.MainLogic.dao.DownloadFile;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
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
}
