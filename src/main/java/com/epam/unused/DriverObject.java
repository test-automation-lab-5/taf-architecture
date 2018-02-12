package com.epam.unused;

import com.epam.datasource.DriverProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverObject {

    private static WebDriver driver;
    private static Map<Long, WebDriver> driverMap = new HashMap<>();
    private DriverObject() {}


    private static WebDriver createDriver(){
        DriverProperties driverProperties = new DriverProperties();
        System.setProperty(driverProperties.getChromeDriver(), driverProperties.getUrl());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver driverQuit(){
        Long currentThread = Thread.currentThread().getId();
        WebDriver driver = driverMap.get(currentThread);
        if (driver != null){
            driver.quit();
        }
        return driver;
    }

    public static WebDriver getDriver() {
        Long currentThread = Thread.currentThread().getId();
        WebDriver driver = driverMap.get(currentThread);
        if (driver == null) {
            driver = createDriver();
            System.out.println(Thread.currentThread().getId());
            driverMap.put(currentThread, driver);
        }
        return driver;
    }
}
