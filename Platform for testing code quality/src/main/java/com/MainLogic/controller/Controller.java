package com.MainLogic.controller;

import com.MainLogic.entity.JavaCodeSimpleTest;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private JavaCodeSimpleTest javaCodeSimpleTest;

    @RequestMapping(value = "/getLenghtMetric/{str}",method = RequestMethod.GET)
    @ResponseBody
    public String test(@PathVariable("str") String str)
    {
        javaCodeSimpleTest = new JavaCodeSimpleTest(str);

        return javaCodeSimpleTest.metricOfLenght();
    }

}
