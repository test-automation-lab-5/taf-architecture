package com.epam.lab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class DriverFactory {

    private DriverFactory() {

    }

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
    {
        //@Override
      /*  protected WebDriver initialValue()
        {
            return new ChromeDriver(); // can be replaced with other browser drivers
        }*/
        @Override
        protected WebDriver initialValue() {
            return SingletonDriver.getDriver();
        }
    };

    public WebDriver getDriver() {
        return driver.get();
    }

    public void removeDriver() {
        driver.get().close();
        driver.get().quit();
        driver.remove();
    }
}