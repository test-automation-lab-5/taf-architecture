package edu.epam.seleniumexample.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserDriver {

    private static BrowserDriver instance = new BrowserDriver();

    private BrowserDriver() {
    }
    public static BrowserDriver getInstance()
    {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(){
        protected WebDriver initialValue()
        {
            WebDriver initValue = new ChromeDriver();
//            if ("webdriver.chrome.driver".equals(PropertyContainer.driverType)) {
//                initValue = new ChromeDriver();
//            }
//            if ("webdriver.gecko.driver".equals(PropertyContainer.driverType)) {
//                initValue = new FirefoxDriver();
//            }
//            if(initValue == null){
//                throw new UnsupportedOperationException();
//            }
            return initValue;
        }
    };

    public WebDriver getDriver() {
        return driver.get();
    }

    public void quitDriver()
    {
        driver.get().quit();
        driver.remove();
    }
}



