package com.MainLogic.controller;

import com.MainLogic.MyConvertor;
import com.MainLogic.Service.Analyses;
import com.MainLogic.dao.LanguageDAO;
import com.MainLogic.dao.Metrics;
import com.MainLogic.dao.MetricsDAO;
import com.MainLogic.date.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;
import static java.time.LocalTime.now;

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
    @Async
    @RequestMapping(value = "/getListMetrics",method = RequestMethod.PUT)
    @ResponseBody
    public Future<HashSet<Metrics>> getListMetrics(HttpServletRequest servletRequest)
    {
        try
        {
            String language = MyConvertor.HttpServletRequestToString(servletRequest);
            HashSet<Metrics> hs=MetricsDAO.getMetricsByLanguage(language);
            return new AsyncResult<>(hs);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e) {

            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    @Async
    @RequestMapping(value = "/getTest5",method = RequestMethod.PUT)
    public
    @ResponseBody
    Future<String> handleTestRequest ()
    {
        return new AsyncResult<>("hello");
    }


    @RequestMapping(value = "/getTest6",method = RequestMethod.PUT)
    @ResponseBody
    public DeferredResult<String> get() {
        DeferredResult<String> defResult = new DeferredResult<>();

        new Thread(() -> {
            String apiResponse = callApi("hello");
            defResult.setResult(apiResponse);
        }).start();

        return defResult;
    }

    private String callApi(String str)
    {
        // restTemplate.invoke(...)
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return str.toUpperCase();
    }
}
