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

public class HoverTest {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    /**
     * hover over each image in the website
     * verify each name:user text is displayed
     */
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[1]"));

        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.moveToElement(img1).perform();
        WebElement link = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(link.isDisplayed(),"verify view profile is displayed");

        WebElement img2 = driver.findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[2]"));

        Thread.sleep(1000);
        actions.moveToElement(img2).perform();
        WebElement link1 = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(link1.isDisplayed(),"verify view profile is displayed");

        WebElement img3 = driver.findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[3]"));
        Thread.sleep(1000);
        actions.moveToElement(img3).perform();
        WebElement link2 = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(link2.isDisplayed(),"verify view profile is displayed");

    }

}
