package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyUrlNotChanged {

    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser
         * go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
         * click on Retrieve password
         * verify that url did not change
         */

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to link
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save url before we click retrieve password button
        String expectedUrl = driver.getCurrentUrl();

        //click on retrieve password
        //WebElement == interface tht represent elements on the webpage
        //findElement == method used to find element on a webpage
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //we save the url after we click button
        String actualUrl = driver.getCurrentUrl();

        //verify that url did not change
        if(actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        Thread.sleep(5000);
        //close all tabs
        driver.quit();



    }
}
