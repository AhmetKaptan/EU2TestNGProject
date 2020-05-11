package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        //Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String message = driver.findElement(By.cssSelector("#finish")).getText();
        System.out.println(message);

    }





}
