package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //make browser full screen
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInputBox = driver.findElement(By.name("full_name"));

        fullNameInputBox.sendKeys("ahmet oguzhan");

        WebElement emailBox = driver.findElement(By.name("email"));
        emailBox.sendKeys("ahmetoguzhana@gmail.com");

        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();
        //lazyway
        //driver.findElement(By.name("wooden_spoon")).click();
        Thread.sleep(5000);
        WebElement signUpMessage = driver.findElement(By.name("signup_message"));
        String expectedSignUpMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String actualSignUpMessage = signUpMessage.getText();

        //lazy way
        //String message = driver.findElement(By.name("signup_message")).getText();

        if(actualSignUpMessage.equals(expectedSignUpMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }

}
