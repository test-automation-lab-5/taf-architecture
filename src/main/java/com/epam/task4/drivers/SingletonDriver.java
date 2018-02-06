package com.epam.task4.drivers;

import com.epam.task4.preferences.Preferences;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SingletonDriver {
    //private static WebDriver driver;
    private static Map<Long, WebDriver> drivers = new HashMap<>();

    private SingletonDriver() {
    }

    private static WebDriver newInstance() {
        System.setProperty(Preferences.preferencesTestGmail.getDriverType(), Preferences.preferencesTestGmail.getDriverURL());
        return new ChromeDriver() {
            {
                manage().timeouts().implicitlyWait(Preferences.preferencesTestGmail.getImplicitlyWait(), TimeUnit.SECONDS);
            }
        };
    }

    public static WebDriver getDriver() {
        return drivers.computeIfAbsent(Thread.currentThread().getId(), f -> newInstance());
    }
}