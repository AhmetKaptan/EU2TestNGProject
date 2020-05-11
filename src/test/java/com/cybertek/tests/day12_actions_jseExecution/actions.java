package com.cybertek.tests.day12_actions_jseExecution;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class actions {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        //Actions-->class that contains all the user interactions
        //how to create actions object/passing driver as a constructor
        Actions actions = new Actions(driver);

        //peform-->perform the action, complete the action
        //moveToElement --> move your mouse to webelement(hover over)
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

        WebElement link = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(link.isDisplayed(),"verify view profile is displayed");


    }
    @Test
    public void dragAndDrop() throws InterruptedException {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        Thread.sleep(2000);

        //if it is problem write this code
        driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();
        Thread.sleep(2000);
        actions.dragAndDrop(source,target).perform();
    }
    @Test
    public void DragAndDropChaining() throws InterruptedException {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();
        Thread.sleep(2000);

        //drag and drop without method
        //if you are chaining actions we use build() method
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().build().perform();
    }



}
