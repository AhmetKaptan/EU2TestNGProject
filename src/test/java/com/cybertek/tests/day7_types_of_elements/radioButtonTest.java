package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class radioButtonTest {
    @Test
    public void RadioBtnTest1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRB = driver.findElement(By.id("blue"));
        WebElement redRB = driver.findElement(By.id("red"));

        //how to check is radio button selected
        System.out.println("blueRB.isSelected() = " + blueRB.isSelected());
        System.out.println("redRB.isSelected() = " + redRB.isSelected());

        //TASK verify blue is selected red is not selected
        Assert.assertTrue(blueRB.isSelected(),"blue is selected");
        Assert.assertFalse(redRB.isSelected(),"red is NOT selected");

        redRB.click();

        //TASK verify blue is NOT selected red is  selected
        Assert.assertFalse(blueRB.isSelected(),"blue is NOT selected");
        Assert.assertTrue(redRB.isSelected(),"red is selected");


        //Thread.sleep(5000);
       // driver.quit();

    }
}
