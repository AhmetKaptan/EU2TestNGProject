package com.cybertek.tests.day7_testNG;

import org.testng.annotations.*;

public class BeforeAfterTests {



    @Test
    public void test1(){
        System.out.println("This is my test 1");
    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("This is my test2");
    }
    @Test
    public void test3(){
        System.out.println("This is my test3");
    }


    @BeforeMethod
    public void setUp(){
        //WebDriver part
        System.out.println("BEFORE METHOD HERE");
        System.out.println("WebDriver Part");

    }

    @AfterMethod
    public void tearDown(){
        System.out.println("AFTER METHOD HERE");
        System.out.println("Driver Quit");

    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("--BEFORE CLASS--");
        System.out.println("RUNS ONLY ONE IN THE CLASS");

    }

    @AfterClass
    public void afterClass(){
        System.out.println("--AFTER CLASS--");
        System.out.println("RUNS ONLY ONE IN THE CLASS");
        System.out.println("GENERATE REPORT");
    }
}
