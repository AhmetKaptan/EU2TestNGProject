package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {
    @Test
    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRB = driver.findElement(By.id("blue"));

        //get the value of type attribute from web page
        System.out.println(blueRB.getAttribute("type"));

        System.out.println(blueRB.getAttribute("name"));

        //get the value of "checked"
        //it gives us true or false
        System.out.println(blueRB.getAttribute("checked"));

        //if attribute does not exist i gives us null
        System.out.println(blueRB.getAttribute("href"));

        System.out.println(blueRB.getAttribute("outerHTML"));

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement button2 = driver.findElement(By.name("button2"));

        //full html code of button2
        System.out.println(button2.getAttribute("outerHTML"));


    }
}
