package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement nameBox = driver.findElement(By.tagName("input"));
        nameBox.sendKeys("ahmet oguzhan");

        WebElement emailBox= driver.findElement(By.name("email"));
        emailBox.sendKeys("ahmetoguzhana@gmail.com");

        driver.findElement(By.tagName("button")).click();

        System.out.println(driver.findElement(By.tagName("h3")).getText());


    }
}
