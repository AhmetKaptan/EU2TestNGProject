package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlChanged {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open browser
         * go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
         * enter any email
         * click on Retrieve password
         * verify that url changed to http://practice.cybertekschool.com/email_sent
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        //sendKeys == send keyboard action to thee webelement
        emailInputBox.sendKeys("ahmetoguzhana@gmail.com");

        Thread.sleep(3000);
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //verify that url changed to http://practice.cybertekschool.com/email_sent
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        String actualUrl = driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        Thread.sleep(3000);
        driver.quit();

        System.out.println("actualUrl = " + actualUrl);
        System.out.println("expectedUrl = " + expectedUrl);
    }
}
