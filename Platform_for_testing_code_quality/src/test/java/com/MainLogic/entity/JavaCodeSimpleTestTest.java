package com.MainLogic.entity;

import static org.junit.jupiter.api.Assertions.*;

public class JavaCodeSimpleTestTest {

    @org.junit.jupiter.api.Test
    void testLength() {
        String expected="20";
        String test_value="Length of this is 20";
        String actual;
        JavaCodeSimpleTest temp= new JavaCodeSimpleTest(test_value);
        actual=temp.metricOfLenght();
        assertEquals(expected,actual);
    }
}
