package com.cybertek.tests.day9_popups_tags_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframes {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        //how to switch to iframe
        //1. by name or id of iframe
        driver.switchTo().frame("mce_0_ifr");

        //clear before sendKeys
        driver.findElement(By.id("tinymce")).clear();
        //sendKeys
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith");
        Thread.sleep(3000);

        //goes back to main frame html
        //useful when we have multiple frames
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        //2. by using index
        driver.switchTo().frame(0);

        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith BY index");

        //second way to switch parent tp go back
        Thread.sleep(2000);
        driver.switchTo().parentFrame();

        //3. by using webelement
        WebElement iframeLocator = driver.findElement(By.tagName("iframe"));
        Thread.sleep(2000);

        driver.switchTo().frame(iframeLocator);
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith BY WEBELEMENT");



    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        //switching to frame top
        driver.switchTo().frame("frame-top");
        // top frame has 3 children left middle right
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        //switch to frame top which is parentFrame
        driver.switchTo().parentFrame();

        //switch to right frame
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //to switch to main html by defaultContent
        driver.switchTo().defaultContent();

        //to switch to bottom
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }





}
