package com.epam.lab5.driver;

import com.epam.lab5.testdata.properties.DriverDataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static com.epam.lab5.consts.Numbers.IMPLICITLY_WAIT_VALUE;
import static com.epam.lab5.consts.Numbers.SEMAPHORE_PERMITS_VAlUE;

public class SingletonDriver {

    private  WebDriver driver;
    static Semaphore semaphore = new Semaphore(SEMAPHORE_PERMITS_VAlUE);
    static Map<Long, WebDriver> driverMap = new HashMap<>();

    SingletonDriver(){};

    private  WebDriver initDriver() {
        DriverDataReader driverDataReader = null;
        try {
            driverDataReader = new DriverDataReader();
            semaphore.acquire();
        } catch (IOException|InterruptedException e) {
            e.printStackTrace();
        }

        System.setProperty(driverDataReader.getChromeDriver(),driverDataReader.getDriverPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_VALUE, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver getDriver() {
        long currentThread = Thread.currentThread().getId();
        WebDriver driver = driverMap.get(currentThread);
        if (driver == null) {
            driver = initDriver();;
            driverMap.put(currentThread, driver);
        }
        return driver;
    }
}
