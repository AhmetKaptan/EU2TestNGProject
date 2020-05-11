package com.cybertek.tests.day7_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {
    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title","Title","verify title");

        System.out.println("Second assertion");
        Assert.assertEquals(1,1);

    }

    @Test
    public void test2(){
        System.out.println("second test case");
        Assert.assertEquals("url","url");
    }

    @Test
    public void test3(){
        String expected = "Cyb";
        String actual = "Cybertek";
        //verify that your title is starting Cyb

        Assert.assertTrue(actual.startsWith(expected),"if it is not you will see this message on the console");
        Assert.assertTrue(1>1,"i am checking 2is greater than 1");

    }

    @Test
    public void test4(){
        //verify that email contains
        String email = "mike@smith.com";
        //Assert.assertEquals(email,"@");
        Assert.assertTrue(email.contains("@"),"verify email has @ sign");
        email.contains("@");

    }

    @Test
    public void test5(){
        //verify smt is false
        Assert.assertFalse(0>1,"verify that 0 is not greater than 1");
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("one","two");
    }





}
