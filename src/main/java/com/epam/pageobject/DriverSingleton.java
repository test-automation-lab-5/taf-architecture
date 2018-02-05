package com.epam.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {

    public static WebDriver driver;
    public static WebDriver getInstance() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
