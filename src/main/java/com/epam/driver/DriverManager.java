package com.epam.driver;

import com.epam.datasource.DriverProperties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static final Logger LOG = Logger.getLogger(DriverManager.class);

    private static Map<Long, WebDriver> drivers = new HashMap<>();
    private static Semaphore semaphore = new Semaphore(3);

    private DriverManager() {
    }

    private static WebDriver getInstance() {
        DriverProperties driverProperties = new DriverProperties();
        System.setProperty(driverProperties.getChromeDriver(), driverProperties.getUrl());
        return new ChromeDriver() {
            {
                manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
        };
    }

    public static WebDriver getDriver() {
        Long currentThread = Thread.currentThread().getId();
        WebDriver driver = drivers.get(currentThread);
        if (driver == null) {
            driver = getInstance();
            LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
            drivers.put(currentThread, driver);
        }
        return driver;
    }

    public static void getThread() {
        try {
            semaphore.acquire();
            getDriver();
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }

    }

    public static void releaseThread() {
            if (DriverManager.getDriver() != null)
            DriverManager.getDriver().quit();
        drivers.remove(Thread.currentThread().getId());
        semaphore.release();
    }
}
