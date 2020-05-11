package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayDemoTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement userNameInput = driver.findElement(By.name("username"));

        System.out.println("userNameInput.isDisplayed() = " + userNameInput.isDisplayed());

        //verify that username not displayed in the screen
        Assert.assertFalse(userNameInput.isDisplayed(),"user name input NOT displayed");

        //click start button
        WebElement startButton = driver.findElement(By.xpath("//button[.='Start']"));
        startButton.click();
        System.out.println("=================AFTER CLICK=================");

        //wait until it appears
        Thread.sleep(5000);

        //verify username displayed on the screen
        Assert.assertTrue(userNameInput.isDisplayed(),"user name input displayed");
        System.out.println("userNameInput.isDisplayed() = " + userNameInput.isDisplayed());


    }
}
