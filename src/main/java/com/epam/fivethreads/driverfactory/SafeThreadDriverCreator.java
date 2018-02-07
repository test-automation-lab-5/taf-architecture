package com.epam.fivethreads.driverfactory;

import org.openqa.selenium.WebDriver;

public class SafeThreadDriverCreator {
    private SafeThreadDriverCreator() {

    }

    private static SafeThreadDriverCreator instance = new SafeThreadDriverCreator();

    public static SafeThreadDriverCreator getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
    {
        @Override
        protected WebDriver initialValue() {
            return DriverManagerFactory.getDriver();
        }
    };

    public WebDriver getDriver() // call this method to get the driver object and launch the browser
    {
        return driver.get();
    }
    public void removeDriver() // Quits the driver and closes the browser
    {
        driver.get().quit();
        driver.remove();
    }
}
