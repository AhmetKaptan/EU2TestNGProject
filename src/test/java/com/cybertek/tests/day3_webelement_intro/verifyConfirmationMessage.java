package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open browser
         * go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
         * enter any email
         * verify that email is displayed in the input box
         * click on Retrieve password
         * verify that confirmation message says 'Your e-mail's been sent!'
         */
        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to link http://practice.cybertekschool.com/forgot_passwordLinks
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));
        String expectedEmail = "ahmetoguzhana@gmail.com";
        emailInputBox.sendKeys(expectedEmail);

        //somehow we should gettext from chrome
        //there are 2 ways 1 is getText() method it gives us String
        //2. way getAttribute(value)=== get text es[ecially input boxes

        //String actualEmail = emailInputBox.getText();
        String actualEmail = emailInputBox.getAttribute("value");


        //verify email
        if(actualEmail.equals(expectedEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("expectedEmail = " + expectedEmail);
        }
        //click retrieve password
        WebElement retrievePassword = driver.findElement(By.id("form_submit"));
        retrievePassword.click();

        //verify that confirmation message says 'Your e-mail's been sent!'
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = actualConfirmationMessage.getText();
        System.out.println(actualConfirmationMessage.getText());

        if(actualMessage.equals(expectedMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        Thread.sleep(3000);
        driver.quit();




    }
}
