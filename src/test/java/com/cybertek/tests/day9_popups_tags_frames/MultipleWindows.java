package com.cybertek.tests.day9_popups_tags_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;


    @BeforeMethod
    public void setupMethod(){
        driver =  WebDriverFactory.getDriver("chrome");


    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void switchWindowsTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/windows");
        //get title
        System.out.println("Title before new window= " + driver.getTitle());
        Thread.sleep(2000);
        //click click here button
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(2000);

        //get title again
        System.out.println("Title after new window= " + driver.getTitle());

        String currentWindowHandle = driver.getWindowHandle();
        System.out.println(currentWindowHandle);

        //we will switch to new window
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println("windowHandles = " + windowHandles.size());

        for (String handle : windowHandles) {
            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }

        }

        System.out.println("Title after switching window = " + driver.getTitle());

    }

    @Test
    public void moreThan2Windows() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/windows");


        Thread.sleep(2000);
        //click click here button
        driver.findElement(By.linkText("Click Here")).click();

        //we will switch to new window
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println("Before Switch = " + driver.getTitle());

        //loop through each window
        for (String handle : windowHandles) {
            //one by one change it
            driver.switchTo().window(handle);
            //look for your window which title is equal
            if(driver.getTitle().equals("New Window")) {

                //stop
                break;
            }

        }
        System.out.println("After switch = " + driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());
    }

}
