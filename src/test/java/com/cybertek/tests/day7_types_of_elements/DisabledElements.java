package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement greenRB = driver.findElement(By.id("green"));

        //how to check web element enabled or not?
        System.out.println(greenRB.isEnabled());

        Assert.assertFalse(greenRB.isEnabled(),"verify green is not enabled");

    }

    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement disabledButton = driver.findElement(By.xpath("//input[@type='text']"));
        disabledButton.sendKeys("mike");

    }
}
