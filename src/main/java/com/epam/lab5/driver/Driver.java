package com.epam.lab5.driver;

import com.epam.lab5.propdata.DriverDataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver getDriver() {
        WebDriver driver;
        DriverDataReader driverDataReader = null;
        try {
            driverDataReader = new DriverDataReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty(driverDataReader.getChromeDriver(), driverDataReader.getDriverPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}
