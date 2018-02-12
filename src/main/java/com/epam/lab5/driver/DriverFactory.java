package com.epam.lab5.driver;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private DriverFactory() {
    }

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>()
    {
        @Override
        protected WebDriver initialValue()
        {
            return new SingletonDriver().getDriver();
        }

    };

    public  WebDriver getDriver() {
        return driver.get();
    }

    public void closeDriver() {
        SingletonDriver.driverMap.remove(Thread.currentThread().getId());
        SingletonDriver.semaphore.release();
        driver.get().quit();
        driver.remove();

    }
}
