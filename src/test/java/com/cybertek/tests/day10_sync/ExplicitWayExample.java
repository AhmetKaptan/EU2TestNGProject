package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWayExample {

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
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        //click start button
        driver.findElement(By.tagName("button")).click();

        //locate username inputbox
        WebElement usernameInputBox = driver.findElement(By.id("username"));

        //HOW TO WAIT EXPLIXITLY?
        //create explicit object
        WebDriverWait wait = new WebDriverWait(driver,10);

        //calling until method from wait object
        wait.until(ExpectedConditions.visibilityOf(usernameInputBox));

        usernameInputBox.sendKeys("Mike Smith");



    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        //click enable
        driver.findElement(By.xpath("//button[.='Enable']")).click();

        //locate inputbox
       WebElement inputBox= driver.findElement(By.xpath("(//input)[2]"));

        //wait until element clickable
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

       inputBox.sendKeys("MikeSmith");



    }



}
