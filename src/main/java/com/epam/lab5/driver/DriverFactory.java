package com.epam.lab5.driver;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private DriverFactory() {

    }

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
    {
        @Override
        protected WebDriver initialValue()
        {
            return new SingletonDriver().getDriver();
        }

    };

    public WebDriver getDriver() {
        return driver.get();
    }

    public void closeDriver() {
        driver.get().quit();
        driver.remove();

    }
}
