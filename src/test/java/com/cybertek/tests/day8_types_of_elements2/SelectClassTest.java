package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");


        //1. locate your dropdown just like others
       WebElement dropdownElement =  driver.findElement(By.cssSelector("#state"));


       //2. create select object by passing that element as a constructor
        Select stateDropdown = new Select (dropdownElement);

        //3. getOptions === returns all the available options from the dropdown list
        List<WebElement> options = stateDropdown.getOptions();

        //print size of the options
        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {

            System.out.println(option.getText());

        }



    }
    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");


        //1. locate your dropdown just like others
        WebElement dropdownElement =  driver.findElement(By.cssSelector("#state"));


        //2. create select object by passing that element as a constructor
        Select stateDropdown = new Select (dropdownElement);

        //verify that first selection is Select a state
        String expectedOption = "Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

        //how to select options from dropdown? 3 main ways
        // 1. select using visible text
        Thread.sleep(3000);
        stateDropdown.selectByVisibleText("Texas");

        expectedOption = "Texas";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption,"verify expected option same actual");

        //2. select using index
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);

        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption,"verify 51 state is Wyoming");

        //3. select by value
        Thread.sleep(2000);
        stateDropdown.selectByValue("DC");

        expectedOption = "District Of Columbia";
        actualOption= stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption,"verify dc is district of columbia");







}}
