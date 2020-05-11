package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.amazon.com");
        Thread.sleep(3000);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("n95 mask");
        Thread.sleep(3000);


        WebElement clickButton = driver.findElement(By.xpath("//input[@value='Go']"));
        clickButton.click();
        Thread.sleep(3000);


        WebElement results = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        System.out.println(results.getText());
        driver.quit();
    }
}
