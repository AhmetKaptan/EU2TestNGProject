package com.cybertek.tests.day12_actions_jseExecution;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecuterDemo {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void clickWithJS(){

        driver.get("http://practice.cybertekschool.com/");

        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));

        //clicking with JS executer
        //create Js executes object

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", dropdownLink);
    }
    @Test
    public void type(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputbox = driver.findElement(By.cssSelector("#input-example>input"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].value='Some Text';", inputbox);


    }
    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        //scroll down 10 times with loop
        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0, 250);");


        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0, -250);");

        }




    }
}
