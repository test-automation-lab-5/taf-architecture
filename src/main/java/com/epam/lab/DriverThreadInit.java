package com.epam.lab;

import org.openqa.selenium.WebDriver;

public class DriverThreadInit {

    private DriverThreadInit() {

    }

    private static DriverThreadInit instance = new DriverThreadInit();

    public static DriverThreadInit getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
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
        return threadDriver.get();
    }

    public void removeDriver() {
        threadDriver.get().close();
        threadDriver.get().quit();
        threadDriver.remove();
    }
}