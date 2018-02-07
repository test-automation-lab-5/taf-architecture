package com.epam.task4.drivers;

import com.epam.task4.preferences.Preferences;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SingletonDriver {
    //private static WebDriver driver;
    private static Map<Long, WebDriver> drivers = new HashMap<>();
    private static Semaphore semaphore = new Semaphore(Preferences.preferencesTestGmail.getThreadsLimit());

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

    public static void acquireThread() throws InterruptedException {
        semaphore.acquire();
        getDriver();
    }

    public static void releaseThread() {
        if (!Objects.isNull(SingletonDriver.getDriver()))
            SingletonDriver.getDriver().quit();
        drivers.remove(Thread.currentThread().getId());
        semaphore.release();
    }

}