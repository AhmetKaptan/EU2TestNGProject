package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
    public static WebDriver getDriver(String browserType){
        WebDriver driver = null;

        //"chrome" "Chrome" or "CHROME"
        switch (browserType.toLowerCase()){
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case  "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.setCapability("marionette", false);
                WebDriver webDriver = new FirefoxDriver(options);
                driver = new FirefoxDriver();
                break;


            default:
        }

        return driver;
    }




}
