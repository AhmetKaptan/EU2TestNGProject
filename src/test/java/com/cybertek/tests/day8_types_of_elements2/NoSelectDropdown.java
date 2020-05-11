package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {
    @Test
            public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1. locate your dropdown
        WebElement dropdownElement = driver.findElement(By.id("dropdownMenuLink"));

        dropdownElement.click();
        Thread.sleep(3000);

        List<WebElement> dropdownOptions = driver.findElements(By.className("dropdown-item"));
        Thread.sleep(3000);

        for (WebElement option : dropdownOptions) {
            System.out.println(option.getText());


        }

        //click yahoo
        Thread.sleep(3000);
        dropdownOptions.get(2).click();




    }



}
