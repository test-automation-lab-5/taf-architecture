package com.epam.fivethreads.driver;

import com.epam.fivethreads.driverproperties.DriverData;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static com.epam.fivethreads.constant.Constant.*;

public class DriverManager {
    private static final Logger LOG = Logger.getLogger(DriverManager.class);
    //public static Semaphore semaphore = new Semaphore(3);
    private static WebDriver driver;

    private DriverManager() {

    }

    protected static WebDriver createDriver() {
        DriverData driverData = new DriverData();
        System.setProperty(driverData.getDriver(), driverData.getUrl());
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(GLOBAL_WAIT_TIME, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriver() {

        if (null == driver) {
            /*try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                System.out.println("Exception in driver getDriverThreadLocal");
            }
            */
            driver = createDriver();
        }
        return driver;
    }

}
