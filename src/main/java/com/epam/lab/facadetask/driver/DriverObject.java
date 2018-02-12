package com.epam.lab.facadetask.driver;

import com.epam.lab.facadetask.propertyreader.ReadPropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class DriverObject {

    private static Map<String, WebDriver> driverMap = new HashMap<>();
    private static Semaphore semaphore = new Semaphore(3);

    private DriverObject() {
    }

    private static WebDriver createDriver() {
        ReadPropertyFile reader = null;
        try{
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            reader = new ReadPropertyFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (reader != null) {
            System.setProperty(reader.readDriverPath(), reader.readChromeDriver());
        }
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriver() {
        String identifier = Thread.currentThread().getName();
        WebDriver driver = driverMap.get(identifier);
        if (driver == null) {
            driver = createDriver();
            driverMap.put(identifier, driver);
        }
        return driver;
    }

    public void releaseThread() {
        DriverObject.getDriver().quit();
        driverMap.remove(Thread.currentThread().getName());
        semaphore.release();
    }
}

