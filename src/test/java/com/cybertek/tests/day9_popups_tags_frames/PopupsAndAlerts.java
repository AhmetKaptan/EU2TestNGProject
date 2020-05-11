package com.cybertek.tests.day9_popups_tags_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

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
    public void test1() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //locate and click button (lazy way)
        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();

        //click yes button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[.='No']")).click();


    }

    @Test
    public void Alerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //locate and click for js alert button
        driver.findElement(By.xpath("//button[1]")).click();
        Thread.sleep(3000);
        //switch to js alert windows
        Alert alert = driver.switchTo().alert();
        //click OK button on the alert
        alert.accept();

        Thread.sleep(3000);

        //click on click for JS confirm
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(3000);
        //click cancel button
        alert.dismiss();

        Thread.sleep(3000);

        //click on click prompt
        driver.findElement(By.xpath("//button[3]")).click();
        Thread.sleep(3000);
        //sendKeys
        alert.sendKeys("mike.smith");
        Thread.sleep(3000);
        alert.accept();


    }





}
