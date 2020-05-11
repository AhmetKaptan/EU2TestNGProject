package com.cybertek.tests.day12_actions_jseExecution;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class hoverTest2 {
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

            for (int i = 1; i <=3 ; i++) {
                String imgXPath = "(//img)["+i+"]";

                WebElement img = driver.findElement(By.xpath(imgXPath));
                Actions actions = new Actions(driver);
                Thread.sleep(1000);
                actions.moveToElement(img).perform();

            }






        }

    }




