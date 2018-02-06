package com.epam.lab.facadetask.driver;

import com.epam.lab.facadetask.propertyreader.ReadPropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DriverObject {

    private static WebDriver driver;

    DriverObject() {}

    private static void createDriver() {
        ReadPropertyFile reader = null;
        try {
            reader = new ReadPropertyFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.setProperty(reader.readDriverPath(), reader.readChromeDriver());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        if (driver == null) {
        createDriver();
        }
        return driver;
    }
}

