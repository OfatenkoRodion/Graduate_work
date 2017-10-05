package com.MainLogic.entity;

public class JavaCodeSimpleTest {
    private String stringCode;

    public JavaCodeSimpleTest(String stringCode) {
        this.stringCode = stringCode;
    }
    public void setStringCode(String stringCode) {
        this.stringCode = stringCode;
    }
    public String metricOfLenght(){
        return "Your string lenght is:"+String.valueOf(stringCode.length())+" metric passed";
    }
}
