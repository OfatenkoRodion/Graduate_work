package com.MainLogic;

import com.MainLogic.dao.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Scanner;

public class MyConvertor
{
    public static String HttpServletRequestToString(HttpServletRequest servletRequest) throws IOException
    {
        if ("PUT".equalsIgnoreCase(servletRequest.getMethod()))
        {
            Scanner s = new Scanner(servletRequest.getInputStream(), "UTF-8").useDelimiter("\\A");
            return (s.hasNext() ? s.next() : "");
        }
        return null;
    }

    public static Order StringToOrder(String jackson) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jackson, Order.class);
    }
}
