package com.cybertek.tests.day14_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTests {

    @Test
    public void test1(){

        String browser = ConfigurationReader.get("browser");
        System.out.println("browser = " + browser);

        System.out.println(ConfigurationReader.get("driver_username"));

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));


        //driver.findElement(By.id("id")).sendKeys(ConfigurationReader.get("driver_username")); //dynamic


    }



}
