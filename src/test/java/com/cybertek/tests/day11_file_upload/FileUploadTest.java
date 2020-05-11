package com.cybertek.tests.day11_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUploadTest {
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

    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/upload");
        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));

        //path of the file ---- "C:\Users\lenovo\Desktop\file.txt"
        chooseFile.sendKeys("C:\\Users\\lenovo\\Desktop\\file.txt");

        //click upload button
        driver.findElement(By.cssSelector("#file-submit")).click();

        Thread.sleep(3000);

        //getting name of the file
        String actualText = driver.findElement(By.cssSelector("#uploaded-files")).getText();
        String expectedText = "file.txt";

        //verify file
        Assert.assertEquals(expectedText, actualText, "verify file.txt seen");

        //other way
        //Assert.assertEquals(actualText,"file.txt");


    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/upload");
        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));

        //sending file
        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/testfile.txt";
        String filePath = projectPath + "/" + relativePath;
        chooseFile.sendKeys(filePath);

        //click upload button
        driver.findElement(By.cssSelector("#file-submit")).click();

        Thread.sleep(3000);

        //getting name of the file
        String actualText = driver.findElement(By.cssSelector("#uploaded-files")).getText();
        String expectedText = "testfile.txt";

        //verify file
        Assert.assertEquals(expectedText, actualText, "verify file.txt seen");

        //other way
        //Assert.assertEquals(actualText,"file.txt");

    }
}