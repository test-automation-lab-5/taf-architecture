package com.epam.task2.drivers;

import com.epam.task2.preferences.Preferences;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class SingletonDriver {
    private static WebDriver driver;

    private SingletonDriver() {
        System.setProperty(Preferences.preferencesTestGmail.getDriverType(), Preferences.preferencesTestGmail.getDriverURL());
        driver = new ChromeDriver() {
            {
                manage().timeouts().implicitlyWait(Preferences.preferencesTestGmail.getImplicitlyWait(), TimeUnit.SECONDS);
            }
        };
    }

    public static WebDriver getDriver() {
        if (Objects.isNull(driver))
            new SingletonDriver();
        return driver;
    }
}